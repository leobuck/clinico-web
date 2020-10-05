package br.clinico.bean;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

@ManagedBean
public class TesteBean {
	private int numero;
	
	@PostConstruct
	public void init() {
		setNumero(1);
	}
	
	public void setNumero(int numero) {
		this.numero = numero;
	}
	
	public int getNumero() {
		return numero;
	}
}
