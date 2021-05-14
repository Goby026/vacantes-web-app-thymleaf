package com.example.demo.services;

import com.example.demo.models.Vacante;

import java.util.List;

public interface IVacantesService {
    List<Vacante> listar();
    Vacante buscarId(Integer id);
    void guardar(Vacante v);
}
