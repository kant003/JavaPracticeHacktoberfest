package main

import (
    "bufio"
    "fmt"
    "os"
)

// TODO: Get all file lines, and print them to stdio
func main() {
    fmt.Println("TODO: Fetch file results");
}

func catFile(filename string) {
    file, err := os.Open(filename);
    if err != nil {
        fmt.Println("Error occured!");
    }

    scanner := bufio.NewScanner(file);
    for scanner.Scan() {
        fmt.Println(scanner.Text());
    }
}
