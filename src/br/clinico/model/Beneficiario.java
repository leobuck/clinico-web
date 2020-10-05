package br.clinico.model;

import java.io.Serializable;

public class Beneficiario implements Serializable {
	
	private int codigo;
	private String nome;
	private int nrProntuario;
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		codigo = codigo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		nome = nome;
	}
	public int getNrProntuario() {
		return nrProntuario;
	}
	public void setNrProntuario(int nrProntuario) {
		nrProntuario = nrProntuario;
	}
}
