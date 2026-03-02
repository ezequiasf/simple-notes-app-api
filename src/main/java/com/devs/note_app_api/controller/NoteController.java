package com.devs.note_app_api.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/note")
@RequiredArgsConstructor
public class NoteController {

    @GetMapping("/exemplo")
    public String exmplo() {
        return "Resposta do servidor";
    }
}
