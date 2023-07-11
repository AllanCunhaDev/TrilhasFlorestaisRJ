package com.example.trilhas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.trilhas.trilhasconfig.TrilhasConfig;
import com.example.trilhas.trilhasconfig.TrilhasRepository;
import com.example.trilhas.trilhasconfig.TrilhasRequestDTO;
import com.example.trilhas.trilhasconfig.TrilhasResponseDTO;

@RestController
@RequestMapping("trilhas")

public class TrilhasController {

    @Autowired
    private TrilhasRepository repository;

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping
    public void saveTrilhas(@RequestBody TrilhasRequestDTO data) {
        TrilhasConfig trilhasData = new TrilhasConfig(data);
        repository.save(trilhasData);
        return;

    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping()
    public List<TrilhasResponseDTO> getAll() {

        List<TrilhasResponseDTO> trilhasList = repository.findAll().stream().map(TrilhasResponseDTO::new).toList();
        return trilhasList;
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePost(@PathVariable TrilhasConfig id) {
        repository.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
