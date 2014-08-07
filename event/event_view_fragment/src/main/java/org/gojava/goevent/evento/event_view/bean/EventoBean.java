package org.gojava.goevent.evento.event_view.bean;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.Date;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import org.glassfish.osgicdi.OSGiService;
import org.gojava.goevent.event.event_api.repository.EventoRepository;
import org.gojava.goevent.event.event_api.model.Evento;

/**
 *
 * @author filipe.portes
 */
@ManagedBean
@ViewScoped
public class EventoBean {

    @Inject
    @OSGiService(dynamic = true)
    private EventoRepository eventoRepository;
    
    private Evento evento;
    
    private List<Evento> eventos;

    public void salvar() {

        getEvento().setDataInicio(new Date());

        eventoRepository.persist(evento);
        
        eventos.add(evento);
        
        evento = null;

        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_INFO, "Evento salvo com sucesso.", null));
    }

    public void excluir(Evento evento) {

        eventoRepository.remove(evento);
        
        eventos.remove(evento);
        
        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_INFO, "Evento excluído com sucesso.", null));
    }

    public Evento getEvento() {
        if (evento == null) {
            evento = new Evento();
        }
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }

    public List<Evento> getEventos() {
        if(eventos == null){
            eventos = eventoRepository.findAll();
        }
        return eventos;
    }

    public void setEventos(List<Evento> eventos) {
        this.eventos = eventos;
    }
    
}
