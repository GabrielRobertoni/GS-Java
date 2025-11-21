package br.com.fiap.bo;

import br.com.fiap.dao.FeedbackDAO;
import br.com.fiap.to.FeedbackTO;
import java.util.ArrayList;

public class FeedbackBO {

    private FeedbackDAO dao = new FeedbackDAO();

    public ArrayList<FeedbackTO> findAll() { return dao.findAll(); }
    public FeedbackTO findById(Long id) { return dao.findById(id); }
    public FeedbackTO save(FeedbackTO f) { return dao.save(f); }
    public FeedbackTO update(FeedbackTO f) { return dao.update(f); }
    public boolean delete(Long id) { return dao.delete(id); }
}
