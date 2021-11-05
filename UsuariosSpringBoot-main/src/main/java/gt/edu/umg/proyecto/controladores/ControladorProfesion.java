/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.edu.umg.proyecto.controladores;

import gt.edu.umg.proyecto.dto.Profesion;
import gt.edu.umg.proyecto.negocio.Negocio;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author Linda Castillo and Antonio Barrera
 */
@Controller
public class ControladorProfesion {
    
    @Autowired
    private Negocio Negocio;

    @GetMapping("/agregarProfesion")
    public String agregarProfesion(Profesion profesion) {
        return "datosProfesion";
    }

    @GetMapping("/listarProfesiones")
    public String listarProfesiones(Model model) {
        model.addAttribute("profesiones", Negocio.listarProfesiones());
        return "listarProfesiones";
    }

    @GetMapping("/editarProfesion/{ID_PROFESION}")
    public String editarProfesion(Profesion profesion, Model model) {
        profesion = Negocio.encontrar(profesion);
        model.addAttribute("profesion", profesion);
        return "datosProfesion";
    }

    @GetMapping("/eliminarProfesion/{ID_PROFESION}")
    public String eliminarProfesion(Profesion profesion) {
        Negocio.eliminar(profesion);
        return "redirect:/listarProfesiones";
    }
    
    @PostMapping("/guardarProfesion")
    public String guardarProfesion(@Valid Profesion profesion, BindingResult resultado, Model model) {
        if (resultado.hasErrors()) {
            return "datosProfesion";
        }
        Negocio.guardar(profesion);
        return "redirect:/profesion";
    }
}
