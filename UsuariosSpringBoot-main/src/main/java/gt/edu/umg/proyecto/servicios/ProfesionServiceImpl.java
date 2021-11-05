/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.edu.umg.proyecto.servicios;

import gt.edu.umg.proyecto.dao.InterProfesionDao;
import gt.edu.umg.proyecto.dto.Profesion;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Linda Castillo and Antonio Barrera
 */
@Service
public class ProfesionServiceImpl implements ProfesionService {

    @Autowired
    private InterProfesionDao InterProfesionDao;

    @Override
    @Transactional(readOnly = true)
    public List<Profesion> listar() {
        return (List<Profesion>) InterProfesionDao.findAll();
    }

    @Override
    @Transactional
    public void guardar(Profesion profesion) {
        InterProfesionDao.save(profesion);
    }

    @Override
    @Transactional
    public void eliminar(Profesion profesion) {
        InterProfesionDao.delete(profesion);
    }
    
    @Override
    @Transactional(readOnly = true)
    public Profesion encontrar(Profesion profesion) {
        return InterProfesionDao.findById(profesion.getID_PROFESION()).orElse(null);
    }

    @Override
    @Transactional(readOnly = true)
    public long contar() {
        return InterProfesionDao.count();
    }

}
