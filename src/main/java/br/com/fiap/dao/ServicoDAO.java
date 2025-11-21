package br.com.fiap.dao;

import br.com.fiap.to.ServicoTO;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ServicoDAO {

    public List<ServicoTO> findAll() {
        List<ServicoTO> servicos = new ArrayList<>();
        String sql = "SELECT * FROM DDD_SERVICO ORDER BY CD_SERVICO";

        try (PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ServicoTO s = new ServicoTO();
                s.setCdServico(rs.getLong("CD_SERVICO"));
                s.setDsServico(rs.getString("DS_SERVICO"));
                s.setDsComentario(rs.getString("DS_COMENTARIO"));
                s.setDsGrauDificuldade(rs.getString("DS_GRAUDIFICULDADE"));
                s.setDsSegmento(rs.getString("DS_SEGMENTO"));
                s.setCdCliente(rs.getLong("CD_CLIENTE"));
                s.setCdContratado(rs.getLong("CD_CONTRATADO"));
                s.setCdPagamento(rs.getLong("CD_PAGAMENTO"));
                s.setCdFeedback(rs.getLong("CD_FEEDBACK"));
                s.setDtPrevisao(rs.getDate("DT_PREVISAO").toLocalDate());
                s.setDtConclusao(rs.getDate("DT_CONCLUSAO").toLocalDate());
                servicos.add(s);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao listar serviços: " + e.getMessage());
        } finally {
            ConnectionFactory.closeConnection();
        }
        return servicos;
    }

    public ServicoTO findById(Long cdServico) {
        ServicoTO s = null;
        String sql = "SELECT * FROM DDD_SERVICO WHERE CD_SERVICO = ?";

        try (PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(sql)) {
            ps.setLong(1, cdServico);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                s = new ServicoTO();
                s.setCdServico(rs.getLong("CD_SERVICO"));
                s.setDsServico(rs.getString("DS_SERVICO"));
                s.setDsComentario(rs.getString("DS_COMENTARIO"));
                s.setDsGrauDificuldade(rs.getString("DS_GRAUDIFICULDADE"));
                s.setDsSegmento(rs.getString("DS_SEGMENTO"));
                s.setCdCliente(rs.getLong("CD_CLIENTE"));
                s.setCdContratado(rs.getLong("CD_CONTRATADO"));
                s.setCdPagamento(rs.getLong("CD_PAGAMENTO"));
                s.setCdFeedback(rs.getLong("CD_FEEDBACK"));
                s.setDtPrevisao(rs.getDate("DT_PREVISAO").toLocalDate());
                s.setDtConclusao(rs.getDate("DT_CONCLUSAO").toLocalDate());
            }
        } catch (SQLException e) {
            System.out.println("Erro ao buscar serviço: " + e.getMessage());
        } finally {
            ConnectionFactory.closeConnection();
        }
        return s;
    }

    public ServicoTO save(ServicoTO servico) {
        String sql = "INSERT INTO DDD_SERVICO (DS_SERVICO, DS_COMENTARIO, DS_GRAUDIFICULDADE, DS_SEGMENTO, CD_CLIENTE, CD_CONTRATADO, CD_PAGAMENTO, CD_FEEDBACK, DT_PREVISAO, DT_CONCLUSAO) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(sql, new String[]{"CD_SERVICO"})) {
            ps.setString(1, servico.getDsServico());
            ps.setString(2, servico.getDsComentario());
            ps.setString(3, servico.getDsGrauDificuldade());
            ps.setString(4, servico.getDsSegmento());
            ps.setLong(5, servico.getCdCliente());
            ps.setLong(6, servico.getCdContratado());
            ps.setLong(7, servico.getCdPagamento());
            ps.setLong(8, servico.getCdFeedback());
            ps.setDate(9, Date.valueOf(servico.getDtPrevisao()));
            ps.setDate(10, Date.valueOf(servico.getDtConclusao()));
            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                servico.setCdServico(rs.getLong(1));
            }
            return servico;

        } catch (SQLException e) {
            System.out.println("Erro ao salvar serviço: " + e.getMessage());
        } finally {
            ConnectionFactory.closeConnection();
        }
        return null;
    }

    public ServicoTO update(ServicoTO servico) {
        String sql = "UPDATE DDD_SERVICO SET DS_SERVICO=?, DS_COMENTARIO=?, DS_GRAUDIFICULDADE=?, DS_SEGMENTO=?, CD_CLIENTE=?, CD_CONTRATADO=?, CD_PAGAMENTO=?, CD_FEEDBACK=?, DT_PREVISAO=?, DT_CONCLUSAO=? WHERE CD_SERVICO=?";

        try (PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(sql)) {
            ps.setString(1, servico.getDsServico());
            ps.setString(2, servico.getDsComentario());
            ps.setString(3, servico.getDsGrauDificuldade());
            ps.setString(4, servico.getDsSegmento());
            ps.setLong(5, servico.getCdCliente());
            ps.setLong(6, servico.getCdContratado());
            ps.setLong(7, servico.getCdPagamento());
            ps.setLong(8, servico.getCdFeedback());
            ps.setDate(9, Date.valueOf(servico.getDtPrevisao()));
            ps.setDate(10, Date.valueOf(servico.getDtConclusao()));
            ps.setLong(11, servico.getCdServico());

            if (ps.executeUpdate() > 0) return servico;

        } catch (SQLException e) {
            System.out.println("Erro ao atualizar serviço: " + e.getMessage());
        } finally {
            ConnectionFactory.closeConnection();
        }
        return null;
    }

    public boolean delete(Long cdServico) {
        String sql = "DELETE FROM DDD_SERVICO WHERE CD_SERVICO=?";
        try (PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(sql)) {
            ps.setLong(1, cdServico);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Erro ao excluir serviço: " + e.getMessage());
        } finally {
            ConnectionFactory.closeConnection();
        }
        return false;
    }
}
