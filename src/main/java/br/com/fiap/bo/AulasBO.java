package br.com.fiap.bo;

import br.com.fiap.dao.AulasDAO;
import br.com.fiap.to.AulasTO;

import java.util.ArrayList;

public class AulasBO {
    private AulasDAO aulasDAO;

    public ArrayList<AulasTO> findByIdCurso(Long idCurso){
        aulasDAO = new AulasDAO();
        return aulasDAO.findByIdCurso(idCurso);
    }

   public AulasTO findById(Long id){
        aulasDAO = new AulasDAO();
        return aulasDAO.findById(id);
   }
}
