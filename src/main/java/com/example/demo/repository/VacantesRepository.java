package com.example.demo.repository;

import com.example.demo.model.Vacante;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface VacantesRepository extends JpaRepository<Vacante, Integer> {

    public List<Vacante> findByEstatus(String estatus);

    public List<Vacante> findByDestacadoAndEstatusOrderByIdDesc(Integer destacado, String estatus);

    public List<Vacante> findBySalarioBetweenOrderBySalarioDesc(double monto_inicial, double monto_final);

    public List<Vacante> findByEstatusIn(String[] estatus);

}
