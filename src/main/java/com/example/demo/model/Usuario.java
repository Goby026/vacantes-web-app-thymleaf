package com.example.demo.model;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name = "usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NonNull
    private String nombre;
    @NonNull
    private String email;
    @NonNull
    private String username;
    @NonNull
    private String password;
    @NonNull
    private Integer status;
    @NonNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fechaRegistro;

    @NonNull
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "usuarioperfil",
            joinColumns = @JoinColumn(name = "idusuario"),
            inverseJoinColumns = @JoinColumn(name = "idperfil")
    )
    private List<Perfil> perfiles;

    public void agregar(Perfil tempPerfil){

        if (this.perfiles == null){
            this.perfiles = new LinkedList<Perfil>();
        }

        this.perfiles.add(tempPerfil);

    }
}
