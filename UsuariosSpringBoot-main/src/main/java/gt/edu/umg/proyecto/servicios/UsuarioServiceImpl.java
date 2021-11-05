/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.edu.umg.proyecto.servicios;

import gt.edu.umg.proyecto.dao.InterUsuarioDao;
import gt.edu.umg.proyecto.dto.Usuario;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Linda Castillo and Antonio Barrera
 */
@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private InterUsuarioDao InterUsuarioDao;

    @Override
    @Transactional(readOnly = true)
    public List<Usuario> listar() {
        return (List<Usuario>) InterUsuarioDao.findAll();
    }

    @Override
    @Transactional
    public void guardar(Usuario usuario) {
        InterUsuarioDao.save(usuario);
    }

    @Override
    @Transactional
    public void eliminar(Usuario usuario) {
        InterUsuarioDao.delete(usuario);
    }
    
    @Override
    @Transactional(readOnly = true)
    public Usuario encontrar(Usuario usuario) {
        return InterUsuarioDao.findById(usuario.getID_USUARIO()).orElse(null);
    }

}
