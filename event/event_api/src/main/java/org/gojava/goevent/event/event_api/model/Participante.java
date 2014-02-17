package org.gojava.goevent.event.event_api.model;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Participante extends Pessoa {
	
	@Column(nullable=false)
	private Integer numeroInscricao;

	public Integer getNumeroInscricao() {
		return numeroInscricao;
	}

	public void setNumeroInscricao(Integer numeroInscricao) {
		this.numeroInscricao = numeroInscricao;
	}
	
}
