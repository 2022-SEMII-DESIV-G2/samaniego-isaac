package com.lab10;

import static spark.Spark.*;

public class App {
    public static void main(String[] args) {
        get("/hello", (req, res) -> "Hello World");
    }
}
