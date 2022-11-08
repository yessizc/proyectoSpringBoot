package com.hotel.demo.models.Dao;

import java.util.List;

import com.hotel.demo.models.entity.Usuario;

public interface IUsuarioDao {
    public List<Usuario> findAll();
	public void save (Usuario reserva);
	public Usuario findOne (Long id);
	public void delete (Long id);

    
}
