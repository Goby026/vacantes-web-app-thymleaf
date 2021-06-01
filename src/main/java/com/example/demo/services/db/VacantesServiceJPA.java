package com.example.demo.services.db;

import com.example.demo.model.Vacante;
import com.example.demo.repository.VacantesRepository;
import com.example.demo.services.IVacantesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Primary
public class VacantesServiceJPA implements IVacantesService {

    @Autowired
    private VacantesRepository repository;

    @Override
    public List<Vacante> listar() {
        return this.repository.findAll();
    }

    @Override
    public Vacante buscarId(Integer id) {
        Optional<Vacante> option = this.repository.findById(id);
        if (option.isPresent()){
            return option.get();
        }
        return null;
    }

    @Override
    public void guardar(Vacante v) {
        this.repository.save(v);
    }

    @Override
    public List<Vacante> buscarDestacadas() {
        return this.repository.findByDestacadoAndEstatusOrderByIdDesc(1, "Aprobada");
    }

    @Override
    public void eliminar(Integer id) {
        this.repository.deleteById(id);
    }
}
