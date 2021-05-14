package com.example.demo.controllers;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import com.example.demo.models.Vacante;
import com.example.demo.services.IVacantesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	@Autowired
	private IVacantesService serviceVacantes;

	@GetMapping("/tabla")
	public String mostrarTabla(Model model){

		List<Vacante> lista = serviceVacantes.listar();

		model.addAttribute("vacantes", lista);

		return "tabla";
	}

//	@GetMapping("/detalle")
//	public String mostarDetalle(Model model){
//		Vacante v = new Vacante();
//		v.setId(1);
//		v.setNombre("Ingeniero de Sistemas");
//		v.setDescripcion("Se solicita los servicios de un Ingeniero de sistemas");
//		v.setFecha( new Date() );
//		v.setSalario(4800.00);
//
//		model.addAttribute("vacante", v);
//
//		return "detalle";
//	}

	@GetMapping("/listado")
	public String mostrarListado(Model model){
		List<String> lista = new LinkedList<String>();
		lista.add("Ingeniero de sistemas");
		lista.add("Auxiliar de contabilidad");
		lista.add("Vendedor");
		lista.add("Arquitecto");

		model.addAttribute("empleos", lista);

		return "listado";
	}

	@GetMapping("/")
	public String getHome(Model model) {

		List<Vacante> lista = serviceVacantes.listar();

		model.addAttribute("vacantes", lista);
		
		return "home";
	}

}
