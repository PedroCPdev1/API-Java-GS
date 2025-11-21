package br.com.fiap.resource;


import br.com.fiap.bo.UsuarioBO;
import br.com.fiap.to.*;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;


@Path("/usuario")
public class UsuarioResource {
    private UsuarioBO usuarioBO = new UsuarioBO();

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/criaLogin")
    public Response criaLogin(LoginUsuarioTO login) {
        LoginUsuarioTO resultado = usuarioBO.criaLogin(login);

        if (resultado != null) {
            return Response.created(null).entity(resultado).build();
        } else {
            String mensagemErro = "Não foi possível criar o usuário. Verifique os dados fornecidos.";
            return Response.status(Response.Status.BAD_REQUEST).entity(mensagemErro).build();
        }
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/criaPerfil")
    public Response criaPerfil(PerfilTO perfil) {
        PerfilTO resultado = usuarioBO.criaPerfil(perfil);

        if (resultado != null) {
            return Response.created(null).entity(resultado).build();
        } else {
            String mensagemErro = "Não foi possível criar o usuário. Verifique os dados fornecidos.";
            return Response.status(Response.Status.BAD_REQUEST).entity(mensagemErro).build();
        }
    }

    @DELETE
    @Path("/deletaPerfil/{id}")
    public Response deletaPerfil(@PathParam("id") Long id){
        Response.ResponseBuilder response = null;
        if (usuarioBO.deletaPerfil(id)){
            response = Response.status(204); // 204 - NO CONTENT
        } else {
            response = Response.status(404); // 404 - NOT FOUND
        }
        return response.build();
    }

    @PUT
    @Path("/editaPerfil/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response editaPerfil(@PathParam("id") Long id, @Valid PerfilTO perfilAtualizado){

        perfilAtualizado.setId_usuario(id);
        PerfilTO resultado = usuarioBO.editaPerfil(perfilAtualizado);

        if (resultado != null){
            return Response.ok(resultado).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/buscaLogin")
    public Response buscaLogin(@Valid LoginUsuarioTO login) {
        LoginUsuarioTO resultado = usuarioBO.buscaLogin(login);
        Response.ResponseBuilder response = null;

        if (resultado != null){
            response = Response.ok();
            response.entity(resultado); // Isso já retorna o objeto com id_usuario
        } else {
            response = Response.status(404);
        }
        return response.build();
    }
}


