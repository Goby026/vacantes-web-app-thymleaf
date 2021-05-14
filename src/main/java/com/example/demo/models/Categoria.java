package com.example.demo.models;

import lombok.Data;

@Data
public class Categoria {

    public Integer id;
    public String nombre;
    public String descripcion;

    @Override
    public String toString() {
        return "Categoria{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                '}';
    }
}
