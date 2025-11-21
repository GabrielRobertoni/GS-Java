package br.com.fiap.bo;

import br.com.fiap.dao.ServicoDAO;
import br.com.fiap.to.ServicoTO;
import java.util.List;

public class ServicoBO {

    private ServicoDAO dao = new ServicoDAO();

    public List<ServicoTO> findAll() {
        return dao.findAll();
    }

    public ServicoTO findById(Long id) {
        return dao.findById(id);
    }

    public ServicoTO save(ServicoTO servico) {
        return dao.save(servico);
    }

    public ServicoTO update(ServicoTO servico) {
        return dao.update(servico);
    }

    public boolean delete(Long id) {
        return dao.delete(id);
    }
}
