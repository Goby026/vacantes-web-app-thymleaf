package com.example.demo.controllers;

import com.example.demo.model.Categoria;
import com.example.demo.model.Vacante;
import com.example.demo.services.ICategoriaService;
import com.example.demo.services.IVacantesService;
import com.example.demo.util.Utileria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping(value = "/vacantes")
public class VacantesController {

    @Value("${tmapp.ruta.img}")
    private String ruta;

    @Autowired
    private IVacantesService service;

    @Autowired
    private ICategoriaService cat_service;

    @GetMapping("/index")
    public String mostrarIndex(Model model) {
        List<Vacante> vacantes = this.service.listar();
        model.addAttribute("vacantes", vacantes);
        //System.out.println("LISTA DE VACANTES :");
        //vacantes.forEach(vacante -> System.out.println(vacante) );
        return "vacantes/listVacantes";
    }

    @GetMapping("/view/{id}")
    public String verDetalle(@PathVariable("id") int idVacante, Model model) {
        Vacante v = service.buscarId(idVacante);
        model.addAttribute("vacante", v);
        return "vacantes/detalle";
    }

    @ModelAttribute
    public void setGenericos(Model model){
        model.addAttribute("categorias", this.cat_service.listar());
    }

    @GetMapping("/delete/{id}")
    public String eliminar(@PathVariable("id") int idVacante, RedirectAttributes attr) {
        this.service.eliminar(idVacante);
        attr.addFlashAttribute("msg","La vacante fue eliminada");
        return "redirect:/vacantes/index";
    }

    @GetMapping("/create")
    public String crear(Vacante vacante, Model model) {

//   ------se agrega la lista al modelo en el metodo setGenericos------
//        List<Categoria> categorias = this.cat_service.listar();
//        model.addAttribute("categorias", categorias);

        return "vacantes/formVacante";
    }

//    @PostMapping("/save")
//    public String guardar(@RequestParam("nombre") String nombre,
//                          @RequestParam("descripcion") String descripcion,
//                          @RequestParam("categoria") String categoria,
//                          @RequestParam("estatus") String estatus,
//                          @RequestParam("fecha") String fecha,
//                          @RequestParam("destacado") int destacado,
//                          @RequestParam("salario") double salario,
//                          @RequestParam("imagen") String imagen,
//                          @RequestParam("detalles") String detalles
//                          ){
//        System.out.println(nombre +" "+ descripcion +" "+ categoria +" "+ estatus +" "+ fecha +" "+ destacado +" "+ salario +" "+ imagen +" "+ detalles);
//        return "vacantes/listVacantes";
//    }

    @PostMapping("/save")
    public String guardar(@RequestParam("imagen") MultipartFile multipart, Vacante v, BindingResult result, RedirectAttributes attr) {
//        cabe resaltar: si spring detecta que se está enviando el ID, entonces
//        no realizará un insert sino ejecutará una setencia update
        if (result.hasErrors()) {
//            model.addAttribute("error", result.getFieldError());
            for (ObjectError error : result.getAllErrors()) {
                System.out.println("Ocurrió un error: " + error.getDefaultMessage());
            }
            return "vacantes/formVacante";
        }

        if (!multipart.isEmpty()) {
//            String ruta = "h:/Imagenes/";
            String nombreImagen = Utileria.guardarArchivo(multipart, this.ruta);

            if (nombreImagen != null) {
                v.setLogo(nombreImagen);
            }
        }

        this.service.guardar(v);
        attr.addFlashAttribute("msg", "Registro guardado");

//        return "vacantes/listVacantes";
//        redirect: es como hacer una peticion get dentro de la peticion post de este controlador
        return "redirect:/vacantes/index";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable("id") int id, Model model){
        Vacante v = this.service.buscarId(id);
        model.addAttribute("vacante", v);

//   ------se agrega la lista al modelo en el metodo setGenericos------
//        model.addAttribute("categorias", this.cat_service.listar());

        return "vacantes/formVacante";
    }

}
