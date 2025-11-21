package br.com.fiap.dao;

import br.com.fiap.to.PagamentoTO;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PagamentoDAO {

    public List<PagamentoTO> findAll() {
        List<PagamentoTO> lista = new ArrayList<>();
        String sql = "SELECT * FROM DDD_PAGAMENTO ORDER BY CD_PAGAMENTO";

        try (Connection con = ConnectionFactory.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                PagamentoTO p = new PagamentoTO(
                        rs.getLong("CD_PAGAMENTO"),
                        rs.getString("DS_FORMAPAG"),
                        rs.getDouble("VL_SERVICO1"),
                        rs.getDate("DT_PAGAMENTO").toLocalDate(),
                        rs.getString("DS_STATUSPAG")
                );
                lista.add(p);
            }

        } catch (SQLException e) {
            System.out.println("Erro ao listar pagamentos: " + e.getMessage());
        }

        return lista;
    }

    public PagamentoTO findById(Long id) {
        PagamentoTO p = null;
        String sql = "SELECT * FROM DDD_PAGAMENTO WHERE CD_PAGAMENTO = ?";

        try (Connection con = ConnectionFactory.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                p = new PagamentoTO(
                        rs.getLong("CD_PAGAMENTO"),
                        rs.getString("DS_FORMAPAG"),
                        rs.getDouble("VL_SERVICO1"),
                        rs.getDate("DT_PAGAMENTO").toLocalDate(),
                        rs.getString("DS_STATUSPAG")
                );
            }

        } catch (SQLException e) {
            System.out.println("Erro ao buscar pagamento: " + e.getMessage());
        }

        return p;
    }

    public PagamentoTO save(PagamentoTO p) {
        String sql = "INSERT INTO DDD_PAGAMENTO (DS_FORMAPAG, VL_SERVICO1, DT_PAGAMENTO, DS_STATUSPAG) VALUES (?, ?, ?, ?)";

        try (Connection con = ConnectionFactory.getConnection();
             PreparedStatement ps = con.prepareStatement(sql, new String[]{"CD_PAGAMENTO"})) {

            ps.setString(1, p.getDsFormaPag());
            ps.setDouble(2, p.getVlServico1());
            ps.setDate(3, Date.valueOf(p.getDtPagamento()));
            ps.setString(4, p.getDsStatusPag());

            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                p.setCdPagamento(rs.getLong(1));
            }

        } catch (SQLException e) {
            System.out.println("Erro ao salvar pagamento: " + e.getMessage());
        }

        return p;
    }

    public PagamentoTO update(PagamentoTO p) {
        String sql = "UPDATE DDD_PAGAMENTO SET DS_FORMAPAG = ?, VL_SERVICO1 = ?, DT_PAGAMENTO = ?, DS_STATUSPAG = ? WHERE CD_PAGAMENTO = ?";

        try (Connection con = ConnectionFactory.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, p.getDsFormaPag());
            ps.setDouble(2, p.getVlServico1());
            ps.setDate(3, Date.valueOf(p.getDtPagamento()));
            ps.setString(4, p.getDsStatusPag());
            ps.setLong(5, p.getCdPagamento());

            int rows = ps.executeUpdate();
            if (rows > 0) {
                return p;
            }

        } catch (SQLException e) {
            System.out.println("Erro ao atualizar pagamento: " + e.getMessage());
        }

        return null;
    }

    public boolean delete(Long id) {
        String sql = "DELETE FROM DDD_PAGAMENTO WHERE CD_PAGAMENTO = ?";
        try (Connection con = ConnectionFactory.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setLong(1, id);
            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("Erro ao deletar pagamento: " + e.getMessage());
        }
        return false;
    }
}
