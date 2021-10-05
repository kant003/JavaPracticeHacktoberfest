package main

import (
    "bufio"
    "fmt"
    "os"
    "flag"
)

// TODO: Get all file lines, and print them to stdio
func main() {
    flag.Parse()
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

    if err := scanner.Err(); err != nil {
        fmt.Println("Error occured!");
    }
}
