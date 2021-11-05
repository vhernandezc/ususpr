/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.edu.umg.proyecto.servicios;

import gt.edu.umg.proyecto.dto.Profesion;
import java.util.List;

/**
 *
 * @author jeant
 */
public interface ProfesionService {
    public List<Profesion> listar();
    public void guardar(Profesion profesion);
    public void eliminar(Profesion profesion);
    public Profesion encontrar(Profesion profesion);
    public long contar();
}
