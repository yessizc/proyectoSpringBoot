package com.hotel.demo.models.service;

import java.util.List;

import com.hotel.demo.models.entity.Reserva;

public interface IReservaService {

    public List<Reserva> findAll();
    public void save (Reserva reserva);
    public Reserva findOne(Long id);
    public void delete (Long id);
    
}
