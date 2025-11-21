package br.com.fiap.dao;

import br.com.fiap.to.ContratadoTO;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ContratadoDAO {

    public List<ContratadoTO> findAll() {
        List<ContratadoTO> contratados = new ArrayList<>();
        String sql = "SELECT * FROM DDD_CONTRATADO ORDER BY CD_CONTRATADO";

        try (PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ContratadoTO c = new ContratadoTO();
                c.setCdContratado(rs.getLong("CD_CONTRATADO"));
                c.setNmCnpj(rs.getString("NM_CNPJ"));
                c.setDsNome(rs.getString("DS_NOME"));
                c.setNmTelefone(rs.getString("NM_TELEFONE"));
                c.setDsRegiao(rs.getString("DS_REGIAO"));
                c.setDsCidade(rs.getString("DS_CIDADE"));
                c.setDsEspecialidade(rs.getString("DS_ESPECIALIDADE"));
                // CORREÇÃO: converte para double
                c.setDsEstrelas(rs.getDouble("DS_ESTRELAS"));
                contratados.add(c);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao listar contratados: " + e.getMessage());
        } finally {
            ConnectionFactory.closeConnection();
        }
        return contratados;
    }

    public ContratadoTO findById(Long id) {
        ContratadoTO c = null;
        String sql = "SELECT * FROM DDD_CONTRATADO WHERE CD_CONTRATADO = ?";

        try (PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(sql)) {
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                c = new ContratadoTO();
                c.setCdContratado(rs.getLong("CD_CONTRATADO"));
                c.setNmCnpj(rs.getString("NM_CNPJ"));
                c.setDsNome(rs.getString("DS_NOME"));
                c.setNmTelefone(rs.getString("NM_TELEFONE"));
                c.setDsRegiao(rs.getString("DS_REGIAO"));
                c.setDsCidade(rs.getString("DS_CIDADE"));
                c.setDsEspecialidade(rs.getString("DS_ESPECIALIDADE"));
                c.setDsEstrelas(rs.getDouble("DS_ESTRELAS"));
            }
        } catch (SQLException e) {
            System.out.println("Erro ao buscar contratado: " + e.getMessage());
        } finally {
            ConnectionFactory.closeConnection();
        }
        return c;
    }

    public ContratadoTO save(ContratadoTO contratado) {
        String sql = "INSERT INTO DDD_CONTRATADO (NM_CNPJ, DS_NOME, NM_TELEFONE, DS_REGIAO, DS_CIDADE, DS_ESPECIALIDADE, DS_ESTRELAS) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(sql, new String[]{"CD_CONTRATADO"})) {
            ps.setString(1, contratado.getNmCnpj());
            ps.setString(2, contratado.getDsNome());
            ps.setString(3, contratado.getNmTelefone());
            ps.setString(4, contratado.getDsRegiao());
            ps.setString(5, contratado.getDsCidade());
            ps.setString(6, contratado.getDsEspecialidade());
            // CORREÇÃO: usa Double
            ps.setDouble(7, contratado.getDsEstrelas());
            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                contratado.setCdContratado(rs.getLong(1));
            }
            return contratado;

        } catch (SQLException e) {
            System.out.println("Erro ao salvar contratado: " + e.getMessage());
        } finally {
            ConnectionFactory.closeConnection();
        }
        return null;
    }

    public ContratadoTO update(ContratadoTO contratado) {
        String sql = "UPDATE DDD_CONTRATADO SET NM_CNPJ=?, DS_NOME=?, NM_TELEFONE=?, DS_REGIAO=?, DS_CIDADE=?, DS_ESPECIALIDADE=?, DS_ESTRELAS=? WHERE CD_CONTRATADO=?";
        try (PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(sql)) {
            ps.setString(1, contratado.getNmCnpj());
            ps.setString(2, contratado.getDsNome());
            ps.setString(3, contratado.getNmTelefone());
            ps.setString(4, contratado.getDsRegiao());
            ps.setString(5, contratado.getDsCidade());
            ps.setString(6, contratado.getDsEspecialidade());
            ps.setDouble(7, contratado.getDsEstrelas());
            ps.setLong(8, contratado.getCdContratado());

            if (ps.executeUpdate() > 0) {
                return contratado;
            }

        } catch (SQLException e) {
            System.out.println("Erro ao atualizar contratado: " + e.getMessage());
        } finally {
            ConnectionFactory.closeConnection();
        }
        return null;
    }

    public boolean delete(Long id) {
        String sql = "DELETE FROM DDD_CONTRATADO WHERE CD_CONTRATADO=?";
        try (PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(sql)) {
            ps.setLong(1, id);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Erro ao excluir contratado: " + e.getMessage());
        } finally {
            ConnectionFactory.closeConnection();
        }
        return false;
    }
}
