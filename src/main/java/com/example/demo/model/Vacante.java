package com.example.demo.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;


@NoArgsConstructor //contructor sin argumentos
@RequiredArgsConstructor //requiere algunos atributos que esten con la notacion @NonNull o final
@Entity
@Table(name = "vacantes")
@Data
public class Vacante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NonNull
    private String nombre;

    @NonNull
    //@Transient //anotacion para que este atributo sea ignorado en las relaciones (hasta realizar las relaciones)
    @OneToOne()
    @JoinColumn(name = "idcategoria")
    private Categoria categoria;

    @NonNull
    private String descripcion;

    @NonNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fecha;

    @NonNull
    private Double salario;
    @NonNull
    private Integer destacado;
    @NonNull
    private String logo="noImage.png";
    @NonNull
    private String estatus;
    @NonNull
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
