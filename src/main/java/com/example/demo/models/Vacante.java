package com.example.demo.models;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class Vacante {
    private Integer id;
    private String nombre;
    private Categoria categoria;
    private String descripcion;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fecha;

    private Double salario;
    private Integer destacado;
    private String logo="noImage.png";
    private String estatus;
    private String detalles;

    @Override
    public String toString() {
        return "Vacante{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", categoria=" + categoria +
                ", descripcion='" + descripcion + '\'' +
                ", fecha=" + fecha +
                ", salario=" + salario +
                ", destacado=" + destacado +
                ", logo='" + logo + '\'' +
                ", estatus='" + estatus + '\'' +
                ", detalles='" + detalles + '\'' +
                '}';
    }
}


