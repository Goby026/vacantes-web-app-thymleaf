package com.example.demo.services;

import com.example.demo.model.Categoria;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class CategoriaServiceImp implements ICategoriaService {

    private LinkedList<Categoria> categorias = null;

    public CategoriaServiceImp() {
        this.categorias = new LinkedList<>();
        Categoria c = new Categoria();
        c.id = 1;
        c.nombre = "Ingeniería";
        c.descripcion = "Facultad de ingeniería";

        Categoria c2 = new Categoria();
        c2.id = 2;
        c2.nombre = "Comunicaciones";
        c2.descripcion = "Facultad de Ciencias de la comunicación";

        Categoria c3 = new Categoria();
        c3.id = 3;
        c3.nombre = "Medicina";
        c3.descripcion = "Facultad de medicina";

        categorias.add(c);
        categorias.add(c2);
        categorias.add(c3);
    }

    @Override
    public List<Categoria> listar() {
        return this.categorias;
    }

    @Override
    public Categoria buscarId(Integer id) {
        return this.categorias.stream()
                .filter( cat -> id.equals( cat.getId() ) )
                .findAny()
                .orElse(null);
    }

    @Override
    public void guardar(Categoria c) {
        this.categorias.add(c);
    }
}
