package com.example.demo.services;


import com.example.demo.model.Categoria;

import java.util.List;

public interface ICategoriaService {
    List<Categoria> listar();
    Categoria buscarId(Integer id);
    void guardar(Categoria c);
}
