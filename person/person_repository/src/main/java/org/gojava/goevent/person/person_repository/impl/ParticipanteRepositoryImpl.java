/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.gojava.goevent.person.person_repository.impl;

import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.gojava.goevent.person.person_api.repository.ParticipanteRepository;
import org.gojava.goevent.person.person_api.model.Participante;

/**
 *
 * @author filipe.portes
 */
@Stateless
@TransactionAttribute(TransactionAttributeType.REQUIRED)
public class ParticipanteRepositoryImpl implements ParticipanteRepository {
    
    @PersistenceContext(unitName = "person_dao_PU")
    protected EntityManager em;

    @Override
    public void persist(Participante participante) {
        em.persist(participante);
    }
    
    @Override
    public Participante merge(Participante participante) {
        return em.merge(participante);
    }
    
    @Override
    public void remove(Participante participante) {
        em.refresh(participante);
        em.remove(participante);
    }

    @Override
    public Participante findById(Integer id) {
        
        return (Participante) em.find(Participante.class, id);
    }
    
    @Override
    public List<Participante> findAll(){
        return em.createQuery(" select e from Participante e ").getResultList();
    }
    
}
