package br.clinico.bean;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import br.clinico.controller.BeneficiarioController;
import br.clinico.model.Beneficiario;

@ManagedBean (name = "cadBenefBean")

@ViewScoped
public class CadastroBeneficiarioBean {
	
	@ManagedProperty(value = "#")
	private Beneficiario beneficiario;
	
	@PostConstruct
	public void init() {
		beneficiario = new Beneficiario();
		beneficiario.setNome("teste");
	}

	public void salvar() {
		System.out.println(">>> clicou");
		BeneficiarioController benefController = new BeneficiarioController();
		benefController.insert(beneficiario);
	}
	
	public Beneficiario getBeneficiario() {
		return beneficiario;
	}

	public void setBeneficiario(Beneficiario beneficiario) {
		this.beneficiario = beneficiario;
	}
	
}
