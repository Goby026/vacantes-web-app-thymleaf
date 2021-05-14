package com.example.demo.services;

import com.example.demo.models.Categoria;
import com.example.demo.models.Vacante;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;

@Service
public class VacantesServicesImp implements IVacantesService{

    private List<Vacante> vacantes = null;

    public VacantesServicesImp() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        this.vacantes = new LinkedList<Vacante>();

        try{

            Vacante v = new Vacante();
            v.setId(1);
            v.setNombre("Ingeniero de sistemas");
            v.setCategoria(null );
            v.setDescripcion("Se requiere de los servicios de un/a ingeniero/a de Sistemas");
            v.setFecha(sdf.parse("05-06-2020"));
            v.setSalario(14800.00);
            v.setDestacado(1);
            v.setLogo("uno.png");

            Vacante v2 = new Vacante();
            v2.setId(2);
            v2.setNombre("Ingeniero de minas");
            v2.setCategoria(null);
            v2.setDescripcion("Se requiere de los servicios de un/a ingeniero/a de minas");
            v2.setFecha(sdf.parse("04-01-2020"));
            v2.setSalario(16300.00);
            v2.setDestacado(0);
            v2.setLogo("dos.png");

            Vacante v3 = new Vacante();
            v3.setId(3);
            v3.setNombre("Psicologa/o");
            v3.setCategoria(null);
            v3.setDescripcion("Se requiere de los servicios de un/a psicologa/o para evaluación de personal");
            v3.setFecha(sdf.parse("29-02-2021"));
            v3.setSalario(4800.00);
            v3.setDestacado(0);
            v3.setLogo("tres.png");

            Vacante v4 = new Vacante();
            v4.setId(4);
            v4.setNombre("Veterinaria/o");
            v4.setCategoria(null);
            v4.setDescripcion("Se requiere de los servicios de un/a veterinaria/o para curar a mi perrito");
            v4.setFecha(sdf.parse("02-01-2021"));
            v4.setSalario(930.00);
            v4.setDestacado(1);
            v4.setLogo("noImage.png");

            vacantes.add(v);
            vacantes.add(v2);
            vacantes.add(v3);
            vacantes.add(v4);

        } catch (Exception e) {
            System.out.println("Error "+ e.getMessage());
        }
    }

    @Override
    public List<Vacante> listar() {
        return this.vacantes;
    }

    @Override
    public Vacante buscarId(Integer id) {
//        Método clásico
//        for( Vacante v : this.vacantes ){
//            if (v.getId() == id){
//                return v;
//            }
//        }
//        return null;

        return this.vacantes.stream()
                .filter( vacante -> id.equals(vacante.getId()) )
                .findAny()
                .orElse(null);
    }

    @Override
    public void guardar(Vacante v) {
            this.vacantes.add(v);
    }
}
