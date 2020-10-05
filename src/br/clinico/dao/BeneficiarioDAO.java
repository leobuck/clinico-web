package br.clinico.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.PreparedStatement;

import br.clinico.db.ConnectionFactory;
import br.clinico.model.Beneficiario;

public class BeneficiarioDAO {

	public void insert(Beneficiario benef) {
		String SQL = "";
		int cont = 1, idBenef = 0;
		
		try {
			Connection connection = new ConnectionFactory().getConnection();
			
			idBenef = getProximoIdBeneficiario();
			benef.setCodigo(idBenef);
			
			SQL = "INSERT INTO beneficiario (ben_id, ben_nome) VALUES (?, ?)";
			
			PreparedStatement ps = (PreparedStatement) connection.prepareStatement(SQL);
			ps.setInt(cont++, benef.getCodigo());
			ps.setString(cont++, benef.getNome());
			
			ps.executeQuery();
			
			ps.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public int getProximoIdBeneficiario() throws SQLException {
		String SQL = "";
		int proxId = 0;
		PreparedStatement ps;
		ResultSet rs;
		Connection connection = null;
		
		try {
			connection = new ConnectionFactory().getConnection();
			
			connection.setAutoCommit(false);
			
			SQL = "UPDATE parametros SET par_ultimo_id_beneficiario = MAX(par_ultimo_id_beneficiario) + 1";
			ps = (PreparedStatement) connection.prepareStatement(SQL);
			ps.executeQuery();
			ps.close();
			
			SQL = "SELECT par_ultimo_id_beneficiario FROM parametros";
			ps = (PreparedStatement) connection.prepareStatement(SQL);
			rs = ps.executeQuery();
			proxId = rs.getInt("par_ultimo_id_beneficiario");
			ps.close();
			rs.close();
			
			connection.commit();
			
		} catch (SQLException e) {
			e.printStackTrace();
			connection.rollback();
		}
		
		return proxId;
	}
}
