package com.example.demo.services.db;

import com.example.demo.model.Categoria;
import com.example.demo.repository.CategoriasRepository;
import com.example.demo.services.ICategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Primary
public class CategoriasServiceJPA implements ICategoriaService {

    @Autowired
    private CategoriasRepository categoriasRepo;

    @Override
    public List<Categoria> listar() {
        return this.categoriasRepo.findAll();
    }

    @Override
    public Categoria buscarId(Integer id) {
        Optional<Categoria> cat = this.categoriasRepo.findById(id);
        if (cat.isPresent())
            return cat.get();

        return null;
    }

    @Override
    public void guardar(Categoria c) {
        this.categoriasRepo.save(c);
    }
}
