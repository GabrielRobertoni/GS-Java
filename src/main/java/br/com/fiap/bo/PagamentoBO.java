package br.com.fiap.bo;

import br.com.fiap.dao.PagamentoDAO;
import br.com.fiap.to.PagamentoTO;
import java.util.List;

public class PagamentoBO {

    private PagamentoDAO dao = new PagamentoDAO();

    public List<PagamentoTO> findAll() {
        return dao.findAll();
    }

    public PagamentoTO findById(Long id) {
        return dao.findById(id);
    }

    public PagamentoTO save(PagamentoTO pagamento) {
        return dao.save(pagamento);
    }

    public PagamentoTO update(PagamentoTO pagamento) {
        return dao.update(pagamento);
    }

    public boolean delete(Long id) {
        return dao.delete(id);
    }
}
