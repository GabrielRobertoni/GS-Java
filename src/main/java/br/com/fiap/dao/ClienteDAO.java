package br.com.fiap.dao;

import br.com.fiap.to.ClienteTO;
import java.sql.*;
import java.util.ArrayList;

public class ClienteDAO {

    public ArrayList<ClienteTO> findAll() {
        ArrayList<ClienteTO> lista = new ArrayList<>();
        String sql = "SELECT * FROM DDD_CLIENTE ORDER BY CD_CLIENTE";
        try (PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                ClienteTO c = new ClienteTO(
                        rs.getLong("CD_CLIENTE"),
                        rs.getString("NM_CPF"),
                        rs.getString("DS_NOME"),
                        rs.getString("DS_ENDERECO"),
                        rs.getString("NM_CEP"),
                        rs.getString("NM_TELEFONE")
                );
                lista.add(c);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao listar clientes: " + e.getMessage());
        } finally {
            ConnectionFactory.closeConnection();
        }
        return lista;
    }

    public ClienteTO findById(Long id) {
        ClienteTO c = null;
        String sql = "SELECT * FROM DDD_CLIENTE WHERE CD_CLIENTE = ?";
        try (PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(sql)) {
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                c = new ClienteTO(
                        rs.getLong("CD_CLIENTE"),
                        rs.getString("NM_CPF"),
                        rs.getString("DS_NOME"),
                        rs.getString("DS_ENDERECO"),
                        rs.getString("NM_CEP"),
                        rs.getString("NM_TELEFONE")
                );
            }
            rs.close();
        } catch (SQLException e) {
            System.out.println("Erro ao buscar cliente: " + e.getMessage());
        } finally {
            ConnectionFactory.closeConnection();
        }
        return c;
    }

    public ClienteTO save(ClienteTO c) {
        String sql = "INSERT INTO DDD_CLIENTE (NM_CPF, DS_NOME, DS_ENDERECO, NM_CEP, NM_TELEFONE) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(sql, new String[]{"CD_CLIENTE"})) {
            ps.setString(1, c.getNmCpf());
            ps.setString(2, c.getDsNome());
            ps.setString(3, c.getDsEndereco());
            ps.setString(4, c.getNmCep());
            ps.setString(5, c.getNmTelefone());
            int affected = ps.executeUpdate();
            if (affected > 0) {
                // opcional: recuperar chave gerada
                try (ResultSet keys = ps.getGeneratedKeys()) {
                    if (keys.next()) {
                        c.setCdCliente(keys.getLong(1));
                    }
                }
                return c;
            }
        } catch (SQLException e) {
            System.out.println("Erro ao salvar cliente: " + e.getMessage());
        } finally {
            ConnectionFactory.closeConnection();
        }
        return null;
    }

    public ClienteTO update(ClienteTO c) {
        String sql = "UPDATE DDD_CLIENTE SET NM_CPF=?, DS_NOME=?, DS_ENDERECO=?, NM_CEP=?, NM_TELEFONE=? WHERE CD_CLIENTE=?";
        try (PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(sql)) {
            ps.setString(1, c.getNmCpf());
            ps.setString(2, c.getDsNome());
            ps.setString(3, c.getDsEndereco());
            ps.setString(4, c.getNmCep());
            ps.setString(5, c.getNmTelefone());
            ps.setLong(6, c.getCdCliente());
            int affected = ps.executeUpdate();
            if (affected > 0) return c;
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar cliente: " + e.getMessage());
        } finally {
            ConnectionFactory.closeConnection();
        }
        return null;
    }

    public boolean delete(Long id) {
        String sql = "DELETE FROM DDD_CLIENTE WHERE CD_CLIENTE = ?";
        try (PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(sql)) {
            ps.setLong(1, id);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Erro ao excluir cliente: " + e.getMessage());
        } finally {
            ConnectionFactory.closeConnection();
        }
        return false;
    }
}
