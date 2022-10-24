
package com.hotel.demo.models.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hotel.demo.models.Dao.IReservaDao;
import com.hotel.demo.models.entity.Reserva;


@Service

public class ReservaServiceImp  implements IReservaService{
    @Autowired
    private IReservaDao reservaDao;

    @Transactional (readOnly = true)
    @Override
    public List<Reserva> findAll(){
        return reservaDao.findAll();

    }
    @Transactional
    @Override
    public void save(Reserva reserva) {
        reservaDao.save(reserva);
        
    }

    @Transactional(readOnly = true)
    @Override
    public Reserva findOne(Long id) {
        return reservaDao.findOne(id);
    }

    @Override
    public void delete(Long id) {
        reservaDao.delete(id);
        
    }
    
}
