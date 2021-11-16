package com.hhgg.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class CorsController {

    @GetMapping("/api/view")
    public String cors() {
        return "static/cors";
    }
}
