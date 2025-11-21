package br.com.fiap.bo;

import br.com.fiap.dao.ClienteDAO;
import br.com.fiap.to.ClienteTO;
import java.util.ArrayList;

public class ClienteBO {

    private ClienteDAO dao = new ClienteDAO();

    public ArrayList<ClienteTO> findAll() {
        return dao.findAll();
    }

    public ClienteTO findById(Long id) {
        return dao.findById(id);
    }

    public ClienteTO save(ClienteTO cliente) {
        // regras de negócio podem ser inseridas aqui (ex: validar duplicidade de CPF)
        return dao.save(cliente);
    }

    public ClienteTO update(ClienteTO cliente) {
        return dao.update(cliente);
    }

    public boolean delete(Long id) {
        return dao.delete(id);
    }
}
