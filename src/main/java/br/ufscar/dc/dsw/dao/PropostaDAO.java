package br.ufscar.dc.dsw.dao;

import br.ufscar.dc.dsw.domain.Proposta;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class PropostaDAO extends GenericDAO{

    public void insert(Proposta proposta) {
        String sql = "INSERT INTO Proposta(idUsuario, idLoja, idCarro, dataProposta, valor, pagamento, statusProposta) VALUES (?, ?, ?, ?, ?, ?, ?)";
        
        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);;

            statement = conn.prepareStatement(sql);
            statement.setLong(1, proposta.getIdUsuario());
            statement.setLong(2, proposta.getIdLoja());
            statement.setLong(3, proposta.getIdCarro());
            statement.setDate(4, (java.sql.Date) proposta.getDataProposta());
            statement.setFloat(5, proposta.getValor());
            statement.setString(6, proposta.getPagamento());
            statement.setInt(7, proposta.getStatusProposta());
            statement.executeUpdate();

            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void update(Proposta proposta) {
        String sql = "UPDATE Proposta SET idUsuario = ?, idLoja = ?, idCarro = ?, dataProposta = ?, valor = ?, pagamento = ?, statusProposta = ? WHERE id = ?";

        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);

            statement.setLong(1, proposta.getIdUsuario());
            statement.setLong(2, proposta.getIdLoja());
            statement.setLong(3, proposta.getIdCarro());
            statement.setDate(4, (java.sql.Date) proposta.getDataProposta());
            statement.setFloat(5, proposta.getValor());
            statement.setString(6, proposta.getPagamento());
            statement.setInt(7, proposta.getStatusProposta());
            statement.executeUpdate();

            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void updateStatus(Proposta proposta, int statusProposta) {
        String sql = "UPDATE Proposta SET statusProposta = ? WHERE id = ?";

        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);

            statement.setInt(1, statusProposta);
            statement.setLong(2, proposta.getId());
            statement.executeUpdate();

            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public List<Proposta> getAll() {

        List<Proposta> listaPropostas = new ArrayList<>();

        String sql = "SELECT * from Proposta";

        try {
            Connection conn = this.getConnection();
            Statement statement = conn.createStatement();

            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                long id = resultSet.getLong("id");
                long idUsuario = resultSet.getLong("idUsuario");
                long idLoja = resultSet.getLong("idLoja");
                long idCarro = resultSet.getLong("idCarro");
                Date dataProposta = resultSet.getDate("dataProposta");
                Float valor = resultSet.getFloat("valor");
                String pagamento = resultSet.getString("pagamento");
                int statusProposta = resultSet.getInt("statusProposta");
                
                Proposta proposta = new Proposta(id, idUsuario, idLoja, idCarro, dataProposta, valor, pagamento, statusProposta);
                listaPropostas.add(proposta);
            }

            resultSet.close();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listaPropostas;
    }

    public void delete(Proposta proposta) throws SQLException {
        String sql = "DELETE FROM Proposta where id = ?";

        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);

            statement.setLong(1, proposta.getId());
            statement.executeUpdate();

            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw e;
        }
    }

    public Proposta getbyID(Long id) {
        Proposta proposta = null;

        String sql = "SELECT * from Proposta WHERE id = ?";

        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);

            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                long idUsuario = resultSet.getLong("idUsuario");
                long idLoja = resultSet.getLong("idLoja");
                long idCarro = resultSet.getLong("idCarro");
                Date dataProposta = resultSet.getDate("dataProposta");
                Float valor = resultSet.getFloat("valor");
                String pagamento = resultSet.getString("pagamento");
                int statusProposta = resultSet.getInt("statusProposta");

                proposta = new Proposta(id, idUsuario, idLoja, idCarro, dataProposta, valor, pagamento, statusProposta);
            }

            resultSet.close();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return proposta;
    }
        
    // LISTAR PROPOSTAS USUARIO
    public List<Proposta> getAllActivebyIDUsuario(Long idUsuario) {

        List<Proposta> listaPropostasUsuario = new ArrayList<>();

        String sql = "SELECT * from Proposta u";

        try {
            Connection conn = this.getConnection();
            Statement statement = conn.createStatement();

            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Long idUsuario_db = resultSet.getLong("idUsuario");
                if (idUsuario == idUsuario_db && resultSet.getInt("statusProposta") == 1) {
                    long id = resultSet.getLong("id");
                    long idLoja = resultSet.getLong("idLoja");
                    long idCarro = resultSet.getLong("idCarro");
                    Date dataProposta = resultSet.getDate("dataProposta");
                    Float valor = resultSet.getFloat("valor");
                    String pagamento = resultSet.getString("pagamento");
                    int statusProposta = resultSet.getInt("statusProposta");

                    Proposta proposta = new Proposta(id, idUsuario_db, idLoja, idCarro, dataProposta, valor, pagamento, statusProposta);
                    listaPropostasUsuario.add(proposta);
                }
                
            }
            resultSet.close();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listaPropostasUsuario;
    }

    public List<Proposta> getAllActivebyIDLoja(Long idLoja) {

        List<Proposta> listaPropostasUsuario = new ArrayList<>();

        String sql = "SELECT * from Proposta u";

        try {
            Connection conn = this.getConnection();
            Statement statement = conn.createStatement();

            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Long idLoja_db = resultSet.getLong("idLoja");
                if (idLoja == idLoja_db && resultSet.getInt("statusProposta") == 1) {
                    long id = resultSet.getLong("id");
                    long idUsuario = resultSet.getLong("idUsuario");
                    long idCarro = resultSet.getLong("idCarro");
                    Date dataProposta = resultSet.getDate("dataProposta");
                    Float valor = resultSet.getFloat("valor");
                    String pagamento = resultSet.getString("pagamento");
                    int statusProposta = resultSet.getInt("statusProposta");

                    Proposta proposta = new Proposta(id, idUsuario, idLoja_db, idCarro, dataProposta, valor, pagamento, statusProposta);
                    listaPropostasUsuario.add(proposta);
                }
                
            }
            resultSet.close();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listaPropostasUsuario;
    }

    public List<Proposta> getAllCancelledbyIDUsuario(Long idUsuario) {

        List<Proposta> listaPropostasUsuario = new ArrayList<>();

        String sql = "SELECT * from Proposta u";

        try {
            Connection conn = this.getConnection();
            Statement statement = conn.createStatement();

            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Long idUsuario_db = resultSet.getLong("idUsuario");
                if (idUsuario == idUsuario_db && resultSet.getInt("statusProposta") == 0) {
                    long id = resultSet.getLong("id");
                    long idLoja = resultSet.getLong("idLoja");
                    long idCarro = resultSet.getLong("idCarro");
                    Date dataProposta = resultSet.getDate("dataProposta");
                    Float valor = resultSet.getFloat("valor");
                    String pagamento = resultSet.getString("pagamento");
                    int statusProposta = resultSet.getInt("statusProposta");

                    Proposta proposta = new Proposta(id, idUsuario_db, idLoja, idCarro, dataProposta, valor, pagamento, statusProposta);
                    listaPropostasUsuario.add(proposta);
                }
                
            }
            resultSet.close();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listaPropostasUsuario;
    }

    public List<Proposta> getAllAceitas(Long idUsuario) {

        List<Proposta> listaPropostasUsuario = new ArrayList<>();

        String sql = "SELECT * from Proposta u";

        try {
            Connection conn = this.getConnection();
            Statement statement = conn.createStatement();

            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Long idUsuario_db = resultSet.getLong("idUsuario");
                if (idUsuario == idUsuario_db && resultSet.getInt("statusProposta") == 2) {
                    long id = resultSet.getLong("id");
                    long idLoja = resultSet.getLong("idLoja");
                    long idCarro = resultSet.getLong("idCarro");
                    Date dataProposta = resultSet.getDate("dataProposta");
                    Float valor = resultSet.getFloat("valor");
                    String pagamento = resultSet.getString("pagamento");
                    int statusProposta = resultSet.getInt("statusProposta");

                    Proposta proposta = new Proposta(id, idUsuario_db, idLoja, idCarro, dataProposta, valor, pagamento, statusProposta);
                    listaPropostasUsuario.add(proposta);
                }
                
            }
            resultSet.close();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listaPropostasUsuario;
    }

    public List<Proposta> getAllNaoAceitas(Long idUsuario) {

        List<Proposta> listaPropostasUsuario = new ArrayList<>();

        String sql = "SELECT * from Proposta u";

        try {
            Connection conn = this.getConnection();
            Statement statement = conn.createStatement();

            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Long idUsuario_db = resultSet.getLong("idUsuario");
                if (idUsuario == idUsuario_db && resultSet.getInt("statusProposta") == 0) {
                    long id = resultSet.getLong("id");
                    long idLoja = resultSet.getLong("idLoja");
                    long idCarro = resultSet.getLong("idCarro");
                    Date dataProposta = resultSet.getDate("dataProposta");
                    Float valor = resultSet.getFloat("valor");
                    String pagamento = resultSet.getString("pagamento");
                    int statusProposta = resultSet.getInt("statusProposta");

                    Proposta proposta = new Proposta(id, idUsuario_db, idLoja, idCarro, dataProposta, valor, pagamento, statusProposta);
                    listaPropostasUsuario.add(proposta);
                }
                
            }
            resultSet.close();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listaPropostasUsuario;
    }
    
    public List<Proposta> getAllbyIDCarro(Long idCarro) {

        List<Proposta> listaPropostasCarros = new ArrayList<>();

        String sql = "SELECT * from Proposta u";

        try {
            Connection conn = this.getConnection();
            Statement statement = conn.createStatement();

            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Long idCarro_db = resultSet.getLong("idCarro");
                if (idCarro == idCarro_db) {
                    Long id = resultSet.getLong("id");
                    long idLoja = resultSet.getLong("idLoja");
                    Long idUsuario = resultSet.getLong("idUsuario");
                    Date dataProposta = resultSet.getDate("dataProposta");
                    Float valor = resultSet.getFloat("valor");
                    String pagamento = resultSet.getString("pagamento");
                    int statusProposta = resultSet.getInt("statusProposta");
                    Proposta proposta = new Proposta(id, idUsuario, idLoja, idCarro_db, dataProposta, valor, pagamento, statusProposta);
                    listaPropostasCarros.add(proposta);
                }
                
            }
            resultSet.close();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listaPropostasCarros;
    }

    public boolean isAvailable(Long idCarro) {

        String sql = "SELECT * from Proposta u";
        
        try {
            Connection conn = this.getConnection();
            Statement statement = conn.createStatement();

            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Long idCarro_db = resultSet.getLong("idCarro");
                if (idCarro == idCarro_db) {
                    int statusProposta = resultSet.getInt("statusProposta");
                    
                    if (statusProposta != 0) {
                        return false;
                    }
                }
            }
            resultSet.close();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
            }
        return true;
    }

}
