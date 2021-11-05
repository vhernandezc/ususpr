/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.edu.umg.proyecto.dto;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

/**
 *
 * @author Linda Castillo and Antonio Barrera
 */
@Data
@Entity
@Table(name = "TB_DEPARTAMENTO")
public class Departamento implements Serializable {

    private static final long serialVersionUI = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ID_DEPTO;
    private String DESCRIPCION_DEPTO;

}
