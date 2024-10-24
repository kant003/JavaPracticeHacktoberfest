package main

import (
	"fmt"
	"html/template"
	"net/http"
	"sync"
)

type Task struct {
	Name string
}

var (
	tasks    []Task
	taskLock sync.Mutex
)

func main() {
	http.HandleFunc("/", homeHandler)
	http.HandleFunc("/add", addTaskHandler)

	fmt.Println("Servidor iniciado en http://localhost:8080")
	http.ListenAndServe(":8080", nil)
}

func homeHandler(w http.ResponseWriter, r *http.Request) {
	tmpl := template.Must(template.ParseFiles("index.html"))

	taskLock.Lock()
	defer taskLock.Unlock()

	tmpl.Execute(w, tasks)
}

func addTaskHandler(w http.ResponseWriter, r *http.Request) {
	if r.Method == "POST" {
		taskName := r.FormValue("task")

		if taskName != "" {
			taskLock.Lock()
			tasks = append(tasks, Task{Name: taskName})
			taskLock.Unlock()
		}

		http.Redirect(w, r, "/", http.StatusSeeOther)
	}
}
