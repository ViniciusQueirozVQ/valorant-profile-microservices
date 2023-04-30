package com.example.detalhes.controller;

import com.example.detalhes.models.DetalhesPersonagem;
import com.example.detalhes.repository.DetalhesPersonagemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api/detalhes")
public class DetalhesPersonagemController {
    @Autowired
    private DetalhesPersonagemRepository repository;

    @GetMapping(path = {"id"})
    public ResponseEntity<DetalhesPersonagem> detalhar(@PathVariable("id") Long id) {
        Optional<DetalhesPersonagem> detalhes = repository.findById(id);

        if (detalhes.isEmpty())
            return ResponseEntity.notFound().build();

        return ResponseEntity.ok().body(detalhes.get());
    }
}