/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.gojava.goevent.event.event_view.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import org.glassfish.osgicdi.OSGiService;
import org.gojava.goevent.event.event_api.dao.EventoDAO;
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
    private EventoDAO eventoDAO;
    
    private Evento evento;
    
    private List<Evento> eventos;

    public void salvar() {

        getEvento().setDataInicio(new Date());

        eventoDAO.persist(evento);
        
        eventos.add(evento);
        
        evento = null;

        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_INFO, "Evento salvo com sucesso.", null));
    }

    public void excluir(Evento evento) {

        eventoDAO.remove(evento);
        
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

    public EventoDAO getEventoDAO() {
        return eventoDAO;
    }

    public void setEventoDAO(EventoDAO eventoDAO) {
        this.eventoDAO = eventoDAO;
    }

    public List<Evento> getEventos() {
        if(eventos == null){
            eventos = eventoDAO.findAll();
        }
        return eventos;
    }

    public void setEventos(List<Evento> eventos) {
        this.eventos = eventos;
    }
    
}
