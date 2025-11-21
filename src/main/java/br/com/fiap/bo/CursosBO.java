package br.com.fiap.bo;

import br.com.fiap.dao.CursosDAO;
import br.com.fiap.to.CursosTO;

import java.util.ArrayList;

public class CursosBO {
    private CursosDAO cursosDAO;

    public ArrayList<CursosTO> buscaTodosCursos(){
        cursosDAO = new CursosDAO();
        return cursosDAO.buscaTodosCursos();
    }
}
