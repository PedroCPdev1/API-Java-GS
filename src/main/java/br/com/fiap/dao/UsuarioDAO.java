package br.com.fiap.dao;

import br.com.fiap.to.CursosTO;
import br.com.fiap.to.LoginUsuarioTO;
import br.com.fiap.to.PerfilTO;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class UsuarioDAO {
    public LoginUsuarioTO criaLogin(LoginUsuarioTO login){
        String sql = "insert into login_usuario( email, senha) values (?,?)";

        try (PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(sql))
        {
            ps.setString(1, login.getEmail());
            ps.setString(2, login.getSenha());
            if (ps.executeUpdate() > 0){
                return login;
            } else {
                return null;
            }
        } catch (SQLException e) {
            System.out.println("Erro ao salvar: " +  e.getMessage());
        } finally {
            ConnectionFactory.closeConnection();
        }
        return null;
    }

    public PerfilTO criaPerfil(PerfilTO perfil) {
        String sql = "insert into perfil( id_usuario, nome, profissao, data_criacao) values (?,?,?,?)";

        try (PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(sql))
        {
            ps.setLong(1, perfil.getId_usuario());
            ps.setString(2, perfil.getNome());
            ps.setString(3, perfil.getProfissao());
            SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            Date dataConvertida = formato.parse(perfil.getData_criacao());
            ps.setDate(4, new java.sql.Date(dataConvertida.getTime()));
            if (ps.executeUpdate() > 0){
                return perfil;
            } else {
                return null;
            }
        } catch (SQLException e) {
            System.out.println("Erro ao salvar: " +  e.getMessage());
        } catch (ParseException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectionFactory.closeConnection();
        }
        return null;
    }

    public boolean delete(Long id){
        String sql = "delete from perfil where id_usuario = ? ";
        try (PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(sql))
        {
            ps.setLong(1, id);
            return ps.executeUpdate() > 0;
        } catch (SQLException e ){
            System.out.println("Erro ao Excluir: " + e.getMessage());
        } finally {
            ConnectionFactory.closeConnection();
        }
        return false;
    }

    public PerfilTO editaPerfil(PerfilTO perfilAtualizado) {
        String sql = "update perfil set nome=?, profissao=? where id_usuario = ? ";
        try (PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(sql))
        {
            ps.setString(1, perfilAtualizado.getNome());
            ps.setString(2, perfilAtualizado.getProfissao());
            ps.setLong(3, perfilAtualizado.getId_usuario());

            if (ps.executeUpdate() > 0){
                return perfilAtualizado;
            } else {
                return null;
            }
        } catch (SQLException e){
            System.out.println("Erro ao atualizar: " + e.getMessage());
            return null;
        } finally {
            ConnectionFactory.closeConnection();
        }
    }

    public LoginUsuarioTO buscaLogin(LoginUsuarioTO login) {
        String sql = "select * from login_usuario where email = ? AND senha = ?";
        try (PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(sql))
        {
            ps.setString(1, login.getEmail());
            ps.setString(2, login.getSenha());

            ResultSet rs = ps.executeQuery();
            if (rs.next()){
                LoginUsuarioTO usuarioEncontrado = new LoginUsuarioTO();
                usuarioEncontrado.setId_usuario(rs.getLong("id_usuario")); // IMPORTANTE!
                usuarioEncontrado.setEmail(rs.getString("email"));
                return usuarioEncontrado;
            } else {
                return null;
            }
        } catch (SQLException e){
            System.out.println("Erro ao buscar login: " + e.getMessage());
            return null;
        } finally {
            ConnectionFactory.closeConnection();
        }
    }
}
