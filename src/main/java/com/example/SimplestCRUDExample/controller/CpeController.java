package com.example.SimplestCRUDExample.controller;

import com.example.SimplestCRUDExample.model.Cpe;
import com.example.SimplestCRUDExample.repo.CpeRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cpes")
public class CpeController {

    private final CpeRepository repo;

    public CpeController(CpeRepository repo) {
        this.repo = repo;
    }

    @GetMapping
    public List<Cpe> getAllCpe() {
        return repo.findAll();
    }
}