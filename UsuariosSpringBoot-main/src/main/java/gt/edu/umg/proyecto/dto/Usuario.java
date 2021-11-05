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
import java.sql.Timestamp;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.NotEmpty;

/**
 *
 * @author Linda Castillo and Antonio Barrera
 */
@Data
@Entity
@Table(name = "tb_usuarios")
public class Usuario implements Serializable {
    
    private static final long serialVersionUI = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ID_USUARIO;
    
    @NotNull
    private int ID_DEPTO;
    
    @NotNull
    private int ID_PROFESION;
   
    @NotEmpty
    private String NOMBRE;
    
    @NotEmpty
    private String APELLIDO;
    
    @NotEmpty
    private String CORREO_ELECTRONICO;
    
    @NotEmpty
    private String TELEFONO;
    
    @NotEmpty
    private String FECHA_NACIMIENTO;
    
    @NotNull
    @Digits(integer = 2, fraction = 6)
    private Double LONGITUD;
    
    @NotNull
    @Digits(integer = 2, fraction = 6)
    private Double LATITUD;
    
    private Timestamp FECHA_REGISTRO;

}
