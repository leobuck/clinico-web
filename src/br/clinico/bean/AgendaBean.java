package br.clinico.bean;

import java.util.Date;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

@ManagedBean
public class AgendaBean {
	
	private Date dataAgenda;
	
	@PostConstruct
	public void init() {
		setDataAgenda(new Date());
	}

	public Date getDataAgenda() {
		return dataAgenda;
	}

	public void setDataAgenda(Date dataAgenda) {
		this.dataAgenda = dataAgenda;
	}
	
	
}
