package br.ufscar.dc.dsw.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.ufscar.dc.dsw.domain.Usuario;

public class UsuarioDAO extends GenericDAO {

    public void insert(Usuario usuario) {

        String sql = "INSERT INTO Usuario(nome, email, cpf, senha, nascimento, papel, telefone, sexo) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);;

            statement = conn.prepareStatement(sql);
            statement.setString(1, usuario.getNome());
            statement.setString(2, usuario.getEmail());
            statement.setString(3, usuario.getCpf());
            statement.setString(4, usuario.getSenha());
            statement.setDate(5, usuario.getNascimento());
            statement.setString(6, usuario.getPapel());
            statement.setString(7, usuario.getTelefone());
            statement.setString(8, usuario.getSexo());
            statement.executeUpdate();

            statement.close();
            conn.close();
        } catch (SQLException e) {
        	if(e instanceof SQLIntegrityConstraintViolationException) {
        		if (e.getMessage().contains("email"))
        			throw new RuntimeException("Já existe um cadastro com o Email inserido.", e);
        		if (e.getMessage().contains("cpf"))
        			throw new RuntimeException("Já existe um cadastro com o CPF inserido.", e);
        	}
            throw new RuntimeException(e);
        }
    }

    public List<Usuario> getAll() {

        List<Usuario> listaUsuarios = new ArrayList<>();

        String sql = "SELECT * from Usuario";

        try {
            Connection conn = this.getConnection();
            Statement statement = conn.createStatement();

            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                long id = resultSet.getLong("id");
                String nome = resultSet.getString("nome");
                String email = resultSet.getString("email");
                String cpf = resultSet.getString("cpf");
                String sexo = resultSet.getString("sexo");
                Date nascimento = resultSet.getDate("nascimento");
                String telefone = resultSet.getString("telefone");
                String senha = resultSet.getString("senha");
                String papel = resultSet.getString("papel");
                Usuario usuario = new Usuario(id ,nome, email, cpf, sexo, nascimento, telefone, senha, papel);
                listaUsuarios.add(usuario);
            }

            resultSet.close();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listaUsuarios;
    }

    public void delete(Usuario usuario) {
        String sql = "DELETE FROM Usuario where id = ?";

        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);

            statement.setLong(1, usuario.getId());
            statement.executeUpdate();

            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void update(Usuario usuario) {
        String sql = "UPDATE Usuario SET nome = ?, email = ?, senha = ?, nascimento = ?, papel = ?, cpf = ?, telefone = ? WHERE id = ?";

        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);

            statement.setString(1, usuario.getNome());
            statement.setString(2, usuario.getEmail());
            statement.setString(3, usuario.getSenha());
            statement.setDate(4, usuario.getNascimento());
            statement.setString(5, usuario.getPapel());
            statement.setString(6,  usuario.getCpf());
            statement.setString(7,  usuario.getTelefone());
            statement.setLong(8,  usuario.getId());
            statement.executeUpdate();

            statement.close();
            conn.close();
        } catch (SQLException e) {
        	if(e instanceof SQLIntegrityConstraintViolationException) {
        		if (e.getMessage().contains("email"))
        			throw new RuntimeException("Já existe um cadastro com o email inserido.", e);
        		if (e.getMessage().contains("cpf"))
        			throw new RuntimeException("Já existe um cadastro com o cpf inserido.", e);
        	}
            throw new RuntimeException(e);
        }
    }

    public Usuario getbyID(Long id) {
        Usuario usuario = null;

        String sql = "SELECT * from Usuario WHERE id = ?";

        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);

            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                String nome = resultSet.getString("nome");
                String email = resultSet.getString("email");
                String cpf = resultSet.getString("cpf");
                String sexo = resultSet.getString("sexo");
                Date nascimento = resultSet.getDate("nascimento");
                String telefone = resultSet.getString("telefone");
                String senha = resultSet.getString("senha");
                String papel = resultSet.getString("papel");

                usuario = new Usuario(id, nome, email, cpf, sexo, nascimento, telefone, senha, papel);
            }

            resultSet.close();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return usuario;
    }
    
    public Usuario getbyEmail(String email) {
        Usuario usuario = null;

        String sql = "SELECT * from Usuario WHERE email = ?";

        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);

            statement.setString(1, email);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
            	Long id = resultSet.getLong("id");
            	String nome = resultSet.getString("nome");
                String cpf = resultSet.getString("cpf");
                String sexo = resultSet.getString("sexo");
                Date nascimento = resultSet.getDate("nascimento");
                String telefone = resultSet.getString("telefone");
                String senha = resultSet.getString("senha");
                String papel = resultSet.getString("papel");

                usuario = new Usuario(id, nome, email, cpf, sexo, nascimento, telefone, senha, papel);
            }

            resultSet.close();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return usuario;
    }
    
}