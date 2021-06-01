package com.example.demo.controllers;

import com.example.demo.model.Categoria;
import com.example.demo.services.ICategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping(value = "/categorias")
public class CategoriasController {

    @Autowired
    private ICategoriaService service;

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String mostrarIndex(Model model){
        List<Categoria> categorias = this.service.listar();
        model.addAttribute("categorias", categorias);
        return "categorias/listarCategorias";
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String crear(Categoria categoria ,Model model){

        List<Categoria> categorias = this.service.listar();

        return "categorias/formCategoria";
    }

    @PostMapping(value = "/save")
    public String guardar(Categoria categoria, BindingResult result, Model model, RedirectAttributes attr){

        if (result.hasErrors()){
            for (ObjectError error: result.getAllErrors()){
                System.out.println("Ocurrió un error: "+ error.getDefaultMessage());
            }
            return "cagegorias/formCategoria";
        }

        this.service.guardar(categoria);
        attr.addFlashAttribute("msg", "Registro guardado");

        return "redirect:/categorias/index";
    }

}
