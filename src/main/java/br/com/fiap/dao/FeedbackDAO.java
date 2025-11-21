package br.com.fiap.dao;

import br.com.fiap.to.FeedbackTO;
import java.sql.*;
import java.util.ArrayList;

public class FeedbackDAO {

    public ArrayList<FeedbackTO> findAll() {
        ArrayList<FeedbackTO> lista = new ArrayList<>();
        String sql = "SELECT * FROM DDD_FEEDBACK ORDER BY CD_FEEDBACK";
        try (PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                FeedbackTO f = new FeedbackTO(
                        rs.getLong("CD_FEEDBACK"),
                        rs.getString("DS_FEEDBACK"),
                        rs.getString("DS_COMENTARIO"),
                        rs.getDate("DT_ENVIO").toLocalDate(),
                        rs.getLong("CD_SERVICO")
                );
                lista.add(f);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao listar feedbacks: " + e.getMessage());
        } finally {
            ConnectionFactory.closeConnection();
        }
        return lista;
    }

    public FeedbackTO findById(Long id) {
        FeedbackTO f = null;
        String sql = "SELECT * FROM DDD_FEEDBACK WHERE CD_FEEDBACK = ?";
        try (PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(sql)) {
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                f = new FeedbackTO(
                        rs.getLong("CD_FEEDBACK"),
                        rs.getString("DS_FEEDBACK"),
                        rs.getString("DS_COMENTARIO"),
                        rs.getDate("DT_ENVIO").toLocalDate(),
                        rs.getLong("CD_SERVICO")
                );
            }
        } catch (SQLException e) {
            System.out.println("Erro ao buscar feedback: " + e.getMessage());
        } finally {
            ConnectionFactory.closeConnection();
        }
        return f;
    }

    public FeedbackTO save(FeedbackTO f) {
        String sql = "INSERT INTO DDD_FEEDBACK (DS_FEEDBACK, DS_COMENTARIO, DT_ENVIO, CD_SERVICO) VALUES (?, ?, ?, ?)";
        try (PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(sql, new String[]{"CD_FEEDBACK"})) {
            ps.setString(1, f.getDsFeedback());
            ps.setString(2, f.getDsComentario());
            ps.setDate(3, Date.valueOf(f.getDtEnvio()));
            ps.setLong(4, f.getCdServico());
            ps.executeUpdate();
            return f;
        } catch (SQLException e) {
            System.out.println("Erro ao salvar feedback: " + e.getMessage());
        } finally {
            ConnectionFactory.closeConnection();
        }
        return null;
    }

    public FeedbackTO update(FeedbackTO f) {
        String sql = "UPDATE DDD_FEEDBACK SET DS_FEEDBACK=?, DS_COMENTARIO=?, DT_ENVIO=?, CD_SERVICO=? WHERE CD_FEEDBACK=?";
        try (PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(sql)) {
            ps.setString(1, f.getDsFeedback());
            ps.setString(2, f.getDsComentario());
            ps.setDate(3, Date.valueOf(f.getDtEnvio()));
            ps.setLong(4, f.getCdServico());
            ps.setLong(5, f.getCdFeedback());
            ps.executeUpdate();
            return f;
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar feedback: " + e.getMessage());
        } finally {
            ConnectionFactory.closeConnection();
        }
        return null;
    }

    public boolean delete(Long id) {
        String sql = "DELETE FROM DDD_FEEDBACK WHERE CD_FEEDBACK = ?";
        try (PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(sql)) {
            ps.setLong(1, id);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Erro ao excluir feedback: " + e.getMessage());
        } finally {
            ConnectionFactory.closeConnection();
        }
        return false;
    }
}
