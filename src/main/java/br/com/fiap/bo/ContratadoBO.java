package br.com.fiap.bo;

import br.com.fiap.dao.ContratadoDAO;
import br.com.fiap.to.ContratadoTO;
import java.util.List;

public class ContratadoBO {

    private ContratadoDAO dao = new ContratadoDAO();

    public List<ContratadoTO> findAll() {
        return dao.findAll();
    }

    public ContratadoTO findById(Long id) {
        return dao.findById(id);
    }

    public ContratadoTO save(ContratadoTO contratado) {
        return dao.save(contratado);
    }

    public ContratadoTO update(ContratadoTO contratado) {
        return dao.update(contratado);
    }

    public boolean delete(Long id) {
        return dao.delete(id);
    }
}
