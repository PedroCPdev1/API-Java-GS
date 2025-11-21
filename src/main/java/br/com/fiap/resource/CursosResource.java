package br.com.fiap.resource;


import br.com.fiap.bo.AulasBO;
import br.com.fiap.bo.CursosBO;
import br.com.fiap.to.AulasTO;
import br.com.fiap.to.CursosTO;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.ArrayList;

@Path("/cursos")
public class CursosResource {
    private AulasBO aulasBO = new AulasBO();
    private CursosBO cursosBO = new CursosBO();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/buscaCursos")
    public Response buscaTodosCursos() {
        ArrayList<CursosTO> resultado = cursosBO.buscaTodosCursos();
        Response.ResponseBuilder response = null;

        if (resultado != null){
            response = Response.ok();
        } else {
            response = Response.status(404);
        }
        response.entity(resultado);
        return  response.build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/buscaAulaPorCurso/{idCurso}")
    public Response findByIdCurso(Long idCurso) {
        ArrayList<AulasTO> resultado = aulasBO.findAulaByIdCurso(idCurso);
        Response.ResponseBuilder response = null;

        if (resultado != null){
            response = Response.ok();
        } else {
            response = Response.status(404);
        }
        response.entity(resultado);
        return  response.build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/buscaAula/{idAula}")
    public Response findById(@PathParam("idAula")Long idAula) {
        AulasTO resultado = aulasBO.findById(idAula);
        Response.ResponseBuilder response = null;

        if (resultado != null){
            response = Response.ok();
        } else {
            response = Response.status(404);
        }
        response.entity(resultado);
        return  response.build();
    }

}
