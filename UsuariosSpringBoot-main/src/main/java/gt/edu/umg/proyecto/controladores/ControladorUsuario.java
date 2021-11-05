/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.edu.umg.proyecto.controladores;

//import gt.edu.umg.proyecto.dto.Departamento;
//import gt.edu.umg.proyecto.dto.Profesion;
import gt.edu.umg.proyecto.dto.Usuario;
import gt.edu.umg.proyecto.negocio.Negocio;
import java.util.HashMap;
import java.util.Map;
import javax.validation.Valid;
//import java.util.HashMap;
//import java.util.Map;
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
public class ControladorUsuario {

    @Autowired
    private Negocio Negocio;

    @GetMapping("/agregarUsuario")
    public String agregarUsuario(Usuario usuario, Model model) {
        model.addAttribute("departamentos", Negocio.listarDepartamentos());
        model.addAttribute("profesiones", Negocio.listarProfesiones());
        return "datosUsuario";
    }

    @GetMapping("/listarUsuarios")
    public String listarUsuarios(Model model) {
        Map<Integer, String> departamentos = new HashMap<>();
        Map<Integer, String> profesiones = new HashMap<>();
        Negocio.listarDepartamentos().forEach(departamento -> {
            departamentos.put(departamento.getID_DEPTO(), departamento.getDESCRIPCION_DEPTO());
        });
        Negocio.listarProfesiones().forEach(profesion -> {
            profesiones.put(profesion.getID_PROFESION(), profesion.getDESCRIPCION_PROFESION());
        });
        model.addAttribute("usuarios", Negocio.listarUsuarios());
        model.addAttribute("departamentos", departamentos);
        model.addAttribute("profesiones", profesiones);
        return "listarUsuarios";
    }

    @GetMapping("/editarUsuario/{ID_USUARIO}")
    public String editarUsuario(Usuario usuario, Model model) {
        usuario = Negocio.encontrar(usuario);
         model.addAttribute("departamentos", Negocio.listarDepartamentos());
        model.addAttribute("profesiones", Negocio.listarProfesiones());
        model.addAttribute("usuario", usuario);
        return "datosUsuario";
    }

    @GetMapping("/eliminarUsuario/{ID_USUARIO}")
    public String eliminarUsuario(Usuario usuario) {
        Negocio.eliminar(usuario);
        return "redirect:/listarUsuarios";
    }

    @PostMapping("/guardarUsuario")
    public String guardarUsuario(@Valid Usuario usuario, BindingResult resultado, Model model) {
        if (resultado.hasErrors()) {
            model.addAttribute("departamentos", Negocio.listarDepartamentos());
            model.addAttribute("profesiones", Negocio.listarProfesiones());
            return "datosUsuario";
        }
        if (usuario.getID_USUARIO() <= 0) {
            java.util.Date tiempo = new java.util.Date();
            java.sql.Timestamp fechaRegistro = new java.sql.Timestamp(tiempo.getTime());
            usuario.setFECHA_REGISTRO(fechaRegistro);
        }
        Negocio.guardar(usuario);
        return "redirect:/usuario";
    }
}
