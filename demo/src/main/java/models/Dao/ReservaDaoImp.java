package models.Dao;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.boot.autoconfigure.security.ConditionalOnDefaultWebSecurity;
import org.springframework.data.jpa.repository.support.EntityManagerBeanDefinitionRegistrarPostProcessor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import antlr.collections.List;

@Repository("ReservaDaoJPA")
public class ReservaDaoImp  implements IReservaDao{

    @PersistenceContext
    private EntityManager em;

    @SuppressWarnings ("unchecked")
    @Transactional
    @Override
   

    }
    
}
