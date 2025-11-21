package br.com.fiap.dao;

import br.com.fiap.to.SeguroTO;
import java.sql.*;
import java.util.ArrayList;

public class SeguroDAO {

    public ArrayList<SeguroTO> findAll() {
        ArrayList<SeguroTO> lista = new ArrayList<>();
        String sql = "SELECT * FROM DDD_SEGURO";
        try (PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                SeguroTO s = new SeguroTO(
                        rs.getLong("CD_APOLICE"),
                        rs.getString("DS_PLANO"),
                        rs.getDouble("VL_COBERTURA"),
                        rs.getString("DS_COBERTURA"),
                        rs.getString("DS_SITUACAO"),
                        rs.getLong("CD_SERVICO")
                );
                lista.add(s);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao listar seguros: " + e.getMessage());
        } finally {
            ConnectionFactory.closeConnection();
        }
        return lista;
    }

    public SeguroTO findById(Long id) {
        SeguroTO s = null;
        String sql = "SELECT * FROM DDD_SEGURO WHERE CD_APOLICE = ?";
        try (PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(sql)) {
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                s = new SeguroTO(
                        rs.getLong("CD_APOLICE"),
                        rs.getString("DS_PLANO"),
                        rs.getDouble("VL_COBERTURA"),
                        rs.getString("DS_COBERTURA"),
                        rs.getString("DS_SITUACAO"),
                        rs.getLong("CD_SERVICO")
                );
            }
        } catch (SQLException e) {
            System.out.println("Erro ao buscar seguro: " + e.getMessage());
        } finally {
            ConnectionFactory.closeConnection();
        }
        return s;
    }

    public SeguroTO save(SeguroTO s) {
        String sql = "INSERT INTO DDD_SEGURO (DS_PLANO, VL_COBERTURA, DS_COBERTURA, DS_SITUACAO, CD_SERVICO) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(sql, new String[]{"CD_APOLICE"})) {
            ps.setString(1, s.getDsPlano());
            ps.setDouble(2, s.getVlCobertura());
            ps.setString(3, s.getDsCobertura());
            ps.setString(4, s.getDsSituacao());
            ps.setLong(5, s.getCdServico());
            ps.executeUpdate();
            return s;
        } catch (SQLException e) {
            System.out.println("Erro ao salvar seguro: " + e.getMessage());
        } finally {
            ConnectionFactory.closeConnection();
        }
        return null;
    }

    public SeguroTO update(SeguroTO s) {
        String sql = "UPDATE DDD_SEGURO SET DS_PLANO=?, VL_COBERTURA=?, DS_COBERTURA=?, DS_SITUACAO=?, CD_SERVICO=? WHERE CD_APOLICE=?";
        try (PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(sql)) {
            ps.setString(1, s.getDsPlano());
            ps.setDouble(2, s.getVlCobertura());
            ps.setString(3, s.getDsCobertura());
            ps.setString(4, s.getDsSituacao());
            ps.setLong(5, s.getCdServico());
            ps.setLong(6, s.getCdApolice());
            ps.executeUpdate();
            return s;
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar seguro: " + e.getMessage());
        } finally {
            ConnectionFactory.closeConnection();
        }
        return null;
    }

    public boolean delete(Long id) {
        String sql = "DELETE FROM DDD_SEGURO WHERE CD_APOLICE = ?";
        try (PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(sql)) {
            ps.setLong(1, id);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Erro ao excluir seguro: " + e.getMessage());
        } finally {
            ConnectionFactory.closeConnection();
        }
        return false;
    }
}
