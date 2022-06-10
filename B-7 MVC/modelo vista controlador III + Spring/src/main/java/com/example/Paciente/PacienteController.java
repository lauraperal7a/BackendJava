package com.example.Paciente;


import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController


public class PacienteController {
    @GetMapping("/index")
    public String welcome(Model model) {
        model.addAttribute("nombre", "diez");
        return "index";
    }

}
