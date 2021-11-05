/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.edu.umg.proyecto.servicios;

import gt.edu.umg.proyecto.dao.InterDepartamentoDao;
import gt.edu.umg.proyecto.dto.Departamento;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author jeant
 */
@Service
public class DepartamentoServiceImpl implements DepartamentoService{

    @Autowired
    private InterDepartamentoDao InterDepartamentoDao;
    
    @Override
    @Transactional(readOnly = true)
    public List<Departamento> listar() {
        return (List<Departamento>) InterDepartamentoDao.findAll();
    }
    
}
