/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.edu.umg.proyecto.negocio;

import gt.edu.umg.proyecto.dto.Departamento;
import gt.edu.umg.proyecto.dto.Profesion;
import gt.edu.umg.proyecto.dto.Usuario;
import gt.edu.umg.proyecto.servicios.DepartamentoService;
import gt.edu.umg.proyecto.servicios.ProfesionService;
import gt.edu.umg.proyecto.servicios.UsuarioService;
import java.util.List;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Linda Castillo and Antonio Barrera
 */
@Service
public class Negocio {

    @Autowired
    private UsuarioService UsuarioService;

    @Autowired
    private ProfesionService ProfesionService;

    @Autowired
    private DepartamentoService DepartamentoService;
    
    private boolean yaExiste(Profesion profesion) {
        boolean resultado = false;
        List<Profesion> profesiones = null;
        try {
            profesiones = ProfesionService.listar();
            for (Profesion registro : profesiones) {
                if (Objects.equals(registro.getDESCRIPCION_PROFESION(), profesion.getDESCRIPCION_PROFESION())) {
                    resultado = true;
                    break;
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
        }
        return resultado;
    }

    public List<Usuario> listarUsuarios() {
        List<Usuario> datos = null;
        try {
            datos = UsuarioService.listar();
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
        }
        return datos;
    }

    public List<Profesion> listarProfesiones() {
        List<Profesion> datos = null;
        try {
            datos = ProfesionService.listar();
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
        }
        return datos;
    }

    public List<Departamento> listarDepartamentos() {
        List<Departamento> datos = null;
        try {
            datos = DepartamentoService.listar();
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
        }
        return datos;
    }

    public boolean guardar(Usuario usuario) {
        boolean resultado = false;
        try {
            UsuarioService.guardar(usuario);
            resultado = true;
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
        }
        return resultado;
    }

    public boolean guardar(Profesion profesion) {
        boolean resultado = false;
        try {
            if (!yaExiste(profesion)) {
                if (ProfesionService.contar() < 10) {
                    ProfesionService.guardar(profesion);
                    resultado = true;
                } else {
                    resultado = false;
                }
            } else {
                resultado = false;
            }

        } catch (Exception ex) {
            ex.printStackTrace(System.out);
        }
        return resultado;
    }

    public boolean eliminar(Usuario usuario) {
        boolean resultado = false;
        try {
            UsuarioService.eliminar(usuario);
            resultado = true;
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
        }
        return resultado;
    }

    public boolean eliminar(Profesion profesion) {
        boolean resultado = false;
        try {
            ProfesionService.eliminar(profesion);
            resultado = true;
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
        }
        return resultado;
    }

    public Usuario encontrar(Usuario usuario) {
        Usuario usuarioEncontrado = null;
        try {
            usuarioEncontrado = UsuarioService.encontrar(usuario);
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
        }
        return usuarioEncontrado;
    }

    public Profesion encontrar(Profesion profesion) {
        Profesion profesionEncontrada = null;
        try {
            profesionEncontrada = ProfesionService.encontrar(profesion);
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
        }
        return profesionEncontrada;
    }

}
