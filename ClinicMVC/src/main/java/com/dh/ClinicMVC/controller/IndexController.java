package com.dh.ClinicMVC.controller;

import com.dh.ClinicMVC.model.Odontologo;
import com.dh.ClinicMVC.service.IOdontologoService;
import com.dh.ClinicMVC.service.implementation.OdontologoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/odontologo")
public class IndexController {

    private IOdontologoService odontologoService;

    public IndexController(OdontologoService odontologoService) {
        this.odontologoService = odontologoService;
    }

    //métodos -> endpoints -> GET/POST/PUT/DELETE

    //localhost:8080/odontologo?id=1&nombre=Vanina
    @GetMapping
    public String buscarOdontologoPorId(Model model, @RequestParam Integer id, @RequestParam String nombre) {
        Odontologo odontologo = odontologoService.buscarPorId(id);
        model.addAttribute("nombre", odontologo.getNombre());
        model.addAttribute("apellido", odontologo.getApellido());
        return "buscarOdontologo";
    }

    //localhost:8080/odontologo/1
    @GetMapping("/{id}")
    public String buscarOdontologoPorIdVariable(Model model, @PathVariable Integer id) {
        Odontologo odontologo = odontologoService.buscarPorId(id);
        model.addAttribute("nombre", odontologo.getNombre());
        model.addAttribute("apellido", odontologo.getApellido());
        return "buscarOdontologo";
    }

}
