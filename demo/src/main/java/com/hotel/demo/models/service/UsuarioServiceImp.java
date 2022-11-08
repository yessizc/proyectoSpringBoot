package com.hotel.demo.models.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hotel.demo.models.Dao.IUsuarioDao;
import com.hotel.demo.models.entity.Usuario;

@Service
public class UsuarioServiceImp implements IUsuarioService{

    @Autowired
    private IUsuarioDao usuarioDao;


    @Transactional (readOnly = true)
    @Override
    public List<Usuario> findAll() {
        return usuarioDao.findAll();
    }

    @Transactional
    @Override
    public void save(Usuario usuario) {
        usuarioDao.save(usuario);
        
    }
    @Transactional (readOnly = true)
    @Override
    public Optional<Usuario> findOne(Long id) {
        
        return usuarioDao.findById(id.intValue());
    }

    @Override
    public void delete(Long id) {
        usuarioDao.deleteById(id.intValue());
        
    }
    
}
