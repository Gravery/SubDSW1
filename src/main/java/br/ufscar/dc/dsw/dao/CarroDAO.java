package br.ufscar.dc.dsw.dao;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import br.ufscar.dc.dsw.domain.Carro;

public class CarroDAO extends GenericDAO {
	
	public void insert(Carro carro) {

		String sql = "INSERT INTO Carro(idLoja, cnpj, placa, modelo, chassi, ano, quilometragem, valor, descricao) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

		try {
			Connection conn = this.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);;

			statement = conn.prepareStatement(sql);
			statement.setLong(1, carro.getIdLoja());
			statement.setString(2, carro.getCNPJ());
			statement.setString(3, carro.getPlaca());
			statement.setString(4, carro.getModelo());
			statement.setString(5, carro.getChassi());
			statement.setInt(6, carro.getAno());
			statement.setFloat(7, carro.getQuilometragem());
			statement.setBigDecimal(8, carro.getValor());
			statement.setString(9, carro.getDescricao());
			statement.executeUpdate();

			statement.close();
			conn.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	/*public List<Carro> getAllValid() {
		List<Carro> listaCarros = this.getAll();
		Date hoje = Date.from(Instant.now());
		listaCarros = listaCarros.stream().filter(x -> x.getModelo().after(hoje)).collect(Collectors.toList());

		return listaCarros;
	}*/

	public List<Carro> getAll() {

		List<Carro> listaCarros = new ArrayList<>();

		String sql = "SELECT * from Carro";

		try {
			Connection conn = this.getConnection();
			Statement statement = conn.createStatement();

			ResultSet resultSet = statement.executeQuery(sql);
			while (resultSet.next()) {
				Long id = resultSet.getLong("id");
				Long idLoja = resultSet.getLong("idLoja");
				String cnpj = resultSet.getString("cnpj");
				String placa = resultSet.getString("placa");
				String modelo = resultSet.getString("modelo");
				String chassi = resultSet.getString("chassi");
				Integer ano = resultSet.getInt("ano");
				Float quilometragem = resultSet.getFloat("quilometragem");
				BigDecimal valor = resultSet.getBigDecimal("valor");
				String descricao = resultSet.getString("descricao");
				Carro carro = new Carro(id, idLoja, cnpj, placa, modelo, chassi, ano, quilometragem, valor, descricao);
				listaCarros.add(carro);
			}

			resultSet.close();
			statement.close();
			conn.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return listaCarros;
	}

	public void delete(Long id) throws SQLException {
		String sql = "DELETE FROM Carro where id = ?";

		try {
			Connection conn = this.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);

			statement.setLong(1, id);
			statement.executeUpdate();

			statement.close();
			conn.close();
		} catch (SQLException e) {
			throw e;
		}
	}

	public void update(Carro carro) {
		String sql = "UPDATE Carro SET idLoja = ?, cnpj = ?, placa = ?, modelo = ?, chassi = ?, ano = ?, quilometragem = ?, valor = ?, descricao = ? WHERE id = ?";

		try {
			Connection conn = this.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);

			statement.setLong(1, carro.getIdLoja());
			statement.setString(2, carro.getCNPJ());
			statement.setString(3, carro.getPlaca());
			statement.setString(4, carro.getModelo());
			statement.setString(5, carro.getChassi());
			statement.setInt(6, carro.getAno());
			statement.setFloat(7, carro.getQuilometragem());
			statement.setBigDecimal(8, carro.getValor());
			statement.setString(9, carro.getDescricao());
			statement.setLong(10, carro.getId());
			statement.executeUpdate();

			statement.close();
			conn.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public Carro getbyID(Long id) {
		Carro carro = null;

		String sql = "SELECT * from Carro WHERE id = ?";

		try {
			Connection conn = this.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);

			statement.setLong(1, id);
			ResultSet resultSet = statement.executeQuery();
			if (resultSet.next()) {
				Long idLoja = resultSet.getLong("idLoja");
				String cnpj = resultSet.getString("CNPJ");
				String placa = resultSet.getString("placa");
				String modelo = resultSet.getString("modelo");
				String chassi = resultSet.getString("chassi");
				Integer ano = resultSet.getInt("ano");
				Float quilometragem = resultSet.getFloat("quilometragem");
				BigDecimal valor = resultSet.getBigDecimal("valor");
				String descricao = resultSet.getString("descricao");

				carro = new Carro(id, idLoja, cnpj, placa, modelo, chassi, ano, quilometragem, valor, descricao);
			}

			resultSet.close();
			statement.close();
			conn.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return carro;
	}

	public List<Carro> getAllbyIDLoja(Long idLoja) {

		List<Carro> listaCarrosLoja = new ArrayList<>();

		String sql = "SELECT * from Carro";

		try {
			Connection conn = this.getConnection();
			Statement statement = conn.createStatement();

			ResultSet resultSet = statement.executeQuery(sql);
			while (resultSet.next()) {
				Long idLoja_db = resultSet.getLong("idLoja");
				if (idLoja == idLoja_db) {
					// System.out.println(idLoja_db);
					Long id = resultSet.getLong("id");
					String cnpj = resultSet.getString("cnpj");
					String placa = resultSet.getString("placa");
					String modelo = resultSet.getString("modelo");
					String chassi = resultSet.getString("chassi");
					Integer ano = resultSet.getInt("ano");
					Float quilometragem = resultSet.getFloat("quilometragem");
					BigDecimal valor = resultSet.getBigDecimal("valor");
					String descricao = resultSet.getString("descricao");
					Carro carro = new Carro(id, idLoja_db, cnpj, placa, modelo, chassi, ano, quilometragem, valor, descricao);
					listaCarrosLoja.add(carro);
				}
				
			}
			resultSet.close();
			statement.close();
			conn.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return listaCarrosLoja;
	}

	/*public List<Carro> getAllbyIDLojaValid(Long idLoja) {
		List<Carro> listaCarros = this.getAllbyIDLoja(idLoja);
		Date hoje = Date.from(Instant.now());
		listaCarros = listaCarros.stream().filter(x -> x.getAno().after(hoje)).collect(Collectors.toList());
		return listaCarros;
	}*/
	
	public List<Carro> getAllModelo(String modelo) {

		List<Carro> carros = getAll();
		
		carros = carros.stream().filter(x -> x.getPlaca() == modelo).filter(x -> x.getModelo() == modelo).filter(x -> x.getChassi() == modelo).collect(Collectors.toList());
		return carros;
	}

	public List<Carro> getAllLoja(String cnpj) {

		List<Carro> carros = getAll();
		
		carros = carros.stream().filter(x -> x.getCNPJ() == cnpj).collect(Collectors.toList());
		return carros;
	}

	public List<Carro> getAllAno(Integer ano) {

		List<Carro> carros = getAll();
		
		carros = carros.stream().filter(x -> x.getAno() == ano).collect(Collectors.toList());
		return carros;
	}

	public List<Carro> getApplyFilters(String modelo, String cnpj, String ano, String validoStr) {
		List<Carro> carros = this.getAll();

		Boolean valido = validoStr.equals("on") ? true : false;

		if (!ano.isEmpty())
			carros = carros.stream().filter(x -> x.getAno().toString().equals(ano)).collect(Collectors.toList());
		if (cnpj != "")
			carros = carros.stream().filter(x -> x.getCNPJ().equals(cnpj)).collect(Collectors.toList());
		if (modelo != "")
			carros = carros.stream().filter(x -> x.getPlaca().equals(modelo) || x.getModelo().equals(modelo) || x.getChassi().equals(modelo)).collect(Collectors.toList());
		return carros;
	}
	
}