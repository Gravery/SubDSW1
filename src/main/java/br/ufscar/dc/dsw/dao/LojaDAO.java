package br.ufscar.dc.dsw.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.ufscar.dc.dsw.domain.Loja;

public class LojaDAO extends GenericDAO {

	public void insert(Loja loja) {
		String sql = "INSERT INTO Loja(cnpj, nome, email, senha, descricao) VALUES (?, ?, ?, ?, ?)";

		try {
			Connection conn = this.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			;

			statement = conn.prepareStatement(sql);
			statement.setString(1, loja.getCNPJ());
			statement.setString(2, loja.getNome());
			statement.setString(3, loja.getEmail());
			statement.setString(4, loja.getSenha());
			statement.setString(5, loja.getDescricao());
			statement.executeUpdate();

			statement.close();
			conn.close();
		} catch (SQLException e) {
			if(e instanceof SQLIntegrityConstraintViolationException) {
        		if (e.getMessage().contains("email"))
        			throw new RuntimeException("Já existe uma loja cadastrada com o email inserido.", e);
        		if (e.getMessage().contains("cnpj"))
        			throw new RuntimeException("Já existe uma loja cadastrada com o CNPJ inserido.", e);
        	}
            throw new RuntimeException(e);
		}
	}

	public List<Loja> getAll() {

		List<Loja> listalojas = new ArrayList<>();

		String sql = "SELECT * from Loja";

		try {
			Connection conn = this.getConnection();
			Statement statement = conn.createStatement();

			ResultSet resultSet = statement.executeQuery(sql);
			while (resultSet.next()) {
				long id = resultSet.getLong("id");
				String cnpj = resultSet.getString("cnpj");
				String nome = resultSet.getString("nome");
				String email = resultSet.getString("email");
				String senha = resultSet.getString("senha");
				String descricao = resultSet.getString("descricao");
				Loja loja = new Loja(id, cnpj, nome, email, senha, descricao);
				listalojas.add(loja);
			}

			resultSet.close();
			statement.close();
			conn.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return listalojas;
	}

	public void delete(Loja loja) {
		String sql = "DELETE FROM Loja where id = ?";

		try {
			Connection conn = this.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);

			statement.setLong(1, loja.getId());
			statement.executeUpdate();

			statement.close();
			conn.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void update(Loja loja) {
		String sql = "UPDATE Loja SET cnpj = ?, nome = ?, email = ?, senha = ?, descricao = ? WHERE id = ?";

		try {
			Connection conn = this.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);

			statement.setString(1, loja.getCNPJ());
			statement.setString(2, loja.getNome());
			statement.setString(3, loja.getEmail());
			statement.setString(4, loja.getSenha());
			statement.setString(5, loja.getDescricao());
			statement.setLong(6, loja.getId());
			statement.executeUpdate();

			statement.close();
			conn.close();
		} catch (SQLException e) {
			if(e instanceof SQLIntegrityConstraintViolationException) {
        		if (e.getMessage().contains("email"))
        			throw new RuntimeException("Já existe uma loja cadastrada com o email inserido.", e);
        		if (e.getMessage().contains("cnpj"))
        			throw new RuntimeException("Já existe uma loja cadastrada com o CNPJ inserido.", e);
        	}
			throw new RuntimeException(e);
		}
	}

	public Loja getbyID(Long id) {
		Loja loja = null;

		String sql = "SELECT * from Loja WHERE id = ?";

		try {
			Connection conn = this.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);

			statement.setLong(1, id);
			ResultSet resultSet = statement.executeQuery();
			if (resultSet.next()) {
				String cnpj = resultSet.getString("cnpj");
				String nome = resultSet.getString("nome");
				String email = resultSet.getString("email");
				String senha = resultSet.getString("senha");
				String descricao = resultSet.getString("descricao");

				loja = new Loja(id, cnpj, nome, email, senha, descricao);
			}

			resultSet.close();
			statement.close();
			conn.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return loja;
	}

	public Loja getbyEmail(String email) {
		Loja loja = null;

		String sql = "SELECT * from Loja WHERE email = ?";

		try {
			Connection conn = this.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);

			statement.setString(1, email);
			ResultSet resultSet = statement.executeQuery();
			if (resultSet.next()) {
				Long id = resultSet.getLong("id");
				String cnpj = resultSet.getString("cnpj");
				String nome = resultSet.getString("nome");
				String senha = resultSet.getString("senha");
				String descricao = resultSet.getString("descricao");

				loja = new Loja(id, cnpj, nome, email, senha, descricao);
			}

			resultSet.close();
			statement.close();
			conn.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return loja;
	}

	public Loja getByCNPJ(String cnpj) {
		Loja loja = null;

		String sql = "SELECT * from Loja WHERE cnpj = ?";

		try {
			Connection conn = this.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);

			statement.setString(1, cnpj);
			ResultSet resultSet = statement.executeQuery();
			if (resultSet.next()) {
				Long id = resultSet.getLong("id");
				String email = resultSet.getString("email");
				String nome = resultSet.getString("nome");
				String senha = resultSet.getString("senha");
				String descricao = resultSet.getString("descricao");

				loja = new Loja(id, cnpj, nome, email, senha, descricao);
			}

			resultSet.close();
			statement.close();
			conn.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
		return loja;
	}
}