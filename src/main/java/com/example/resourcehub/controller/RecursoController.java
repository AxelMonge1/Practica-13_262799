package com.example.resourcehub.controller;

import com.example.resourcehub.models.Recurso;
import com.example.resourcehub.services.RecursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/recursos")
public class RecursoController {
    @Autowired
    private RecursoService recursoService;

    @GetMapping
    public List<Recurso> listar(){
        return recursoService.obtenerTodos();
    }

    @GetMapping("/{id}")
    public Recurso obtenerPorId(@PathVariable Long id){
        return recursoService.obtenerPorId(id).orElse(null);
    }

    @PostMapping
    public Recurso crearRecurso(@RequestBody Recurso recurso){
        return recursoService.crearRecurso(recurso);
    }

    @PutMapping("/{id}")
    public Recurso actualizar(@PathVariable Long id, @RequestBody Recurso recurso){
        return recursoService.actualizarCompleto(id, recurso).orElse(null);
    }

    @PatchMapping("/{id}")
    public Recurso actualizarParcial(@PathVariable Long id, @RequestBody Recurso recurso){
        return recursoService.actualizarParcial(id, recurso).orElse(null);
    }

    @DeleteMapping("/{id}")
    public void eliminarRecurso(@PathVariable Long id){
        recursoService.eliminarRecurso(id);
    }
}