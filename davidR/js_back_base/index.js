//const experss = require("express");
import express from "express";
import dotenv from "dotenv";
dotenv.config();

let PORT = process.env.PORT;
let nombre = "David";

const app = express();

app.get("/greet", greet);
app.get("/", start);

function start(req, res) {
  res.send("Hola desde express");
}

function greet(req, res) {
  console.log("Hola Mundo");
  res.send("Hola Mundo!!!!!!!!!!!!!!!!!!!!!");
}

app.listen(3000, () => console.log("Servidor encendido en puerto 3000"));
