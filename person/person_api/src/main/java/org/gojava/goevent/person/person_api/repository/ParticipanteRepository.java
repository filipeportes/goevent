/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.gojava.goevent.person.person_api.repository;

import java.util.List;
import org.gojava.goevent.person.person_api.model.Participante;

/**
 *
 * @author filipe.portes
 */
public interface ParticipanteRepository {

    void persist(Participante participante);
    
    Participante merge(Participante participante);

    void remove(Participante participante);
    
    List<Participante> findAll();
    
    Participante findById(Integer id);
    
}
