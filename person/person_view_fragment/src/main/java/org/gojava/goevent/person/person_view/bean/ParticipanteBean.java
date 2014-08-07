package org.gojava.goevent.person.person_view.bean;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import org.glassfish.osgicdi.OSGiService;
import org.gojava.goevent.person.person_api.repository.ParticipanteRepository;
import org.gojava.goevent.person.person_api.model.Participante;

/**
 *
 * @author filipe.portes
 */
@ManagedBean
@ViewScoped
public class ParticipanteBean {

    @Inject
    @OSGiService(dynamic = true)
    private ParticipanteRepository participanteRepository;
    
    private Participante participante;
    
    private List<Participante> participantes;

    public void salvar() {

        if(participante.getId() == null){
            participanteRepository.persist(participante);
            participantes.add(participante);
        }else{
            participanteRepository.merge(participante);
        }
        
        participante = null;

        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_INFO, "Participante salvo com sucesso.", null));
    }

//    public void excluir(Participante participante) {
//
//        participanteRepository.remove(participante);
//        
//        participantes.remove(participante);
//        
//        FacesContext.getCurrentInstance().addMessage(null,
//                new FacesMessage(FacesMessage.SEVERITY_INFO, "Participante excluído com sucesso.", null));
//    }
    
    public Participante getParticipante() {
        if (participante == null) {
            participante = new Participante();
        }
        return participante;
    }

    public void setParticipante(Participante participante) {
        this.participante = participante;
    }

    public List<Participante> getParticipantes() {
        if(participantes == null){
            participantes = participanteRepository.findAll();
        }
        return participantes;
    }

    public void setParticipantes(List<Participante> participantes) {
        this.participantes = participantes;
    }
    
}
