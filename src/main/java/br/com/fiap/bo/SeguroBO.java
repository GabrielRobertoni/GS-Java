package br.com.fiap.bo;

import br.com.fiap.dao.SeguroDAO;
import br.com.fiap.to.SeguroTO;
import java.util.ArrayList;

public class SeguroBO {
    private SeguroDAO dao = new SeguroDAO();

    public ArrayList<SeguroTO> findAll() { return dao.findAll(); }
    public SeguroTO findById(Long id) { return dao.findById(id); }
    public SeguroTO save(SeguroTO s) { return dao.save(s); }
    public SeguroTO update(SeguroTO s) { return dao.update(s); }
    public boolean delete(Long id) { return dao.delete(id); }
}
