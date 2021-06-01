package com.example.demo.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor //contructor sin argumentos
@RequiredArgsConstructor //requiere algunos atributos que esten con la notacion @NonNull o final
@Table(name = "perfiles")
@Entity
public class Perfil {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;

    @NonNull
    public String perfil;

    @Override
    public String toString() {
        return "Perfil{" +
                "id=" + id +
                ", perfil='" + perfil + '\'' +
                '}';
    }
}
