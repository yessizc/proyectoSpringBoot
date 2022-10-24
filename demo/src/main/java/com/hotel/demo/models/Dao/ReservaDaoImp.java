package com.hotel.demo.models.Dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.hotel.demo.models.entity.Reserva;

import java.util.List;


@Repository("ReservaDaoJPA")
public class ReservaDaoImp  implements IReservaDao{

    @PersistenceContext
    private EntityManager em;

    @SuppressWarnings("unchecked")
    @Transactional(readOnly = true)
    @Override
    public List<Reserva> findAll(){
        return em.createQuery("from Reserva").getResultList();

    }

    @Override
    @Transactional
    public void save (Reserva reserva){
        if (reserva.getId()!=null && reserva.getId()>0){
            em.merge(reserva);
        }
        else{
        em.persist(reserva);
        }
    }

    @Override
    @Transactional (readOnly = true)
    public Reserva findOne(Long id){
        return em.find(Reserva.class, id);
    }

    @Override
    @Transactional
    public void delete (Long id){
        Reserva reserva=findOne(id);
        em.remove(reserva);
    }
    
   

    
    
}
