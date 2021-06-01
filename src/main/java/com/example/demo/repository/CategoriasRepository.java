//package net.gobydev.repository;
package com.example.demo.repository;

import com.example.demo.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CategoriasRepository extends JpaRepository<Categoria, Integer> {

}
