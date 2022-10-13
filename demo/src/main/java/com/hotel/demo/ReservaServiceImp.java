
package com.hotel.demo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import antlr.collections.List;
import models.service.IReservaService;

@Service

public class ReservaServiceImp<Reserva> implements IReservaService{
    @Autowired
    private IReservaService reservaDao;

    @Transactional (readOnly = true)
    @Override
    public List<Reserva> finddAll(){
        return reservaDao.finddAll()

    }
    
}
