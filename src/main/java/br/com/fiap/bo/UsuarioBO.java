package br.com.fiap.bo;

import br.com.fiap.dao.UsuarioDAO;
import br.com.fiap.to.AulasTO;
import br.com.fiap.to.LoginUsuarioTO;
import br.com.fiap.to.PerfilTO;
import jakarta.validation.Valid;

public class UsuarioBO {
    private UsuarioDAO usuarioDAO;

    public LoginUsuarioTO criaLogin(LoginUsuarioTO login){
        usuarioDAO = new UsuarioDAO();
        return usuarioDAO.criaLogin(login);
    }

    public PerfilTO criaPerfil(PerfilTO perfil) {
        usuarioDAO = new UsuarioDAO();
        return usuarioDAO.criaPerfil(perfil);
    }

    public boolean deletaPerfil(Long id){
        usuarioDAO = new UsuarioDAO();
        return usuarioDAO.delete(id);
    }

    public PerfilTO editaPerfil(PerfilTO perfilAtualizado){
        usuarioDAO = new UsuarioDAO();
        return usuarioDAO.editaPerfil(perfilAtualizado);
    }

    public LoginUsuarioTO buscaLogin(LoginUsuarioTO login) {
        usuarioDAO = new UsuarioDAO();
        return usuarioDAO.buscaLogin(login);
    }
}
