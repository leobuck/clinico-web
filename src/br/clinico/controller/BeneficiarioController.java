package br.clinico.controller;

import br.clinico.dao.BeneficiarioDAO;
import br.clinico.model.Beneficiario;

public class BeneficiarioController {
	private BeneficiarioDAO dao;
	
	public BeneficiarioController() {
		dao = new BeneficiarioDAO();
	}

	public void insert(Beneficiario benef) {
		dao.insert(benef);
	}
}
