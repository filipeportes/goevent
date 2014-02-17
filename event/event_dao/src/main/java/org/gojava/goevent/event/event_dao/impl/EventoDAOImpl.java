/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.gojava.goevent.event.event_dao.impl;

import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.gojava.goevent.event.event_api.dao.EventoDAO;
import org.gojava.goevent.event.event_api.model.Evento;

/**
 *
 * @author filipe.portes
 */
@Stateless
@TransactionAttribute(TransactionAttributeType.REQUIRED)
public class EventoDAOImpl implements EventoDAO {
    
    @PersistenceContext
    protected EntityManager em;

    @Override
    public void persist(Evento evento) {
        em.persist(evento);
    }
    
    @Override
    public void remove(Evento evento) {
        evento = em.merge(evento);
        em.remove(evento);
    }

    @Override
    public Evento findById(Integer id) {
        
        return (Evento) em.find(Evento.class, id);
    }
    
    @Override
    public List<Evento> findAll(){
        return em.createQuery(" select e from Evento e ").getResultList();
    }
    
}
