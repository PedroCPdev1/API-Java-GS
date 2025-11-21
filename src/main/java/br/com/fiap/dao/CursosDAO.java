package br.com.fiap.dao;

import br.com.fiap.to.CursosTO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CursosDAO {

    public ArrayList<CursosTO> buscaTodosCursos() {
        ArrayList<CursosTO> cursos = new ArrayList<CursosTO>();
        String sql = "select id_curso, titulo, situacao_conclusao, data_conclusao from cursos";
        try(PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(sql))
        {
            ResultSet rs = ps.executeQuery();
            if (rs != null){
                while (rs.next()){
                    CursosTO curso = new CursosTO();
                    curso.setId_curso(rs.getLong("id_curso"));
                    curso.setTitulo(rs.getString("titulo"));
                    curso.setSituacao_conclusao(rs.getString("situacao_conclusao"));
                    if (rs.getDate("data_conclusao") != null)
                        curso.setData_conclusao(rs.getDate("data_conclusao").toLocalDate());
                    cursos.add(curso);
                }
            } else {
                return null;
            }
        } catch (SQLException e){
            System.out.println("Erro na consulta: " + e.getMessage());
        } finally {
            ConnectionFactory.closeConnection();
        }
        return cursos;
    }
}
