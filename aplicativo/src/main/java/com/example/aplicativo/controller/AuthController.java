package com.example.aplicativo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuthController {

    @GetMapping("/login")
    public String login() {
        return "login"; // Renderizar la página de inicio de sesión
    }

    @GetMapping("/registro")
    public String registro() {
        return "registro"; // Renderizar la página de registro
    }
}
