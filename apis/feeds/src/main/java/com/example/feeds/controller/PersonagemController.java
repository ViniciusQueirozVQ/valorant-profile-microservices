package com.example.feeds.controller;

import com.example.feeds.models.Personagem;
import com.example.feeds.repository.PersonagemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/api/personagens")
public class PersonagemController {
    @Autowired
    private PersonagemRepository repository;

    @GetMapping
    public ResponseEntity<Page<Personagem>> listar(@PageableDefault(size = 5, sort = {"nome"}) Pageable paginacao) {
        Page<Personagem> personagems = repository.findAll(paginacao);
        if(personagems.isEmpty())
            return ResponseEntity.notFound().build();

        return ResponseEntity.ok().body(personagems);
    }
}