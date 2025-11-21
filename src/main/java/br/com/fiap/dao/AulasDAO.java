package br.com.fiap.dao;

import br.com.fiap.to.AulasTO;
import java.sql.*;
import java.util.ArrayList;

public class AulasDAO {
    public ArrayList<AulasTO> findAulaByIdCurso(Long idCurso) {
        ArrayList<AulasTO> aulas = new ArrayList<AulasTO>();
        String sql = "select id_aula, titulo, duracao_min from aulas WHERE id_curso = ?";
        try(PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(sql))
        {
            ps.setLong(1, idCurso);
            ResultSet rs = ps.executeQuery();
            if (rs != null){
                while (rs.next()){
                    AulasTO aula = new AulasTO();
                    aula.setId_aula(rs.getLong("id_aula"));
                    aula.setTitulo(rs.getString("titulo"));
                    aula.setDuracao_min(rs.getLong("duracao_min"));
                    aulas.add(aula);
                }
            } else {
                return null;
            }
        } catch (SQLException e){
            System.out.println("Erro na consulta: " + e.getMessage());
        } finally {
            ConnectionFactory.closeConnection();
        }
        return aulas;
    }

    public AulasTO findById(Long id) {
        AulasTO aula = new AulasTO();
        String sql = "select titulo, duracao_min from aulas WHERE ID_aula = ?";
        try (PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(sql)) {
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    aula.setTitulo(rs.getString("titulo"));
                    aula.setDuracao_min(rs.getLong("duracao_min"));
                } else {
                    return null;
                }
        } catch (SQLException e) {
            System.out.println("Erro na consulta: " + e.getMessage());
        } finally {
            ConnectionFactory.closeConnection();
        }
        return aula;
    }
}
