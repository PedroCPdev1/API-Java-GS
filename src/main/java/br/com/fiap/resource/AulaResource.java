package br.com.fiap.resource;


import br.com.fiap.bo.AulasBO;
import br.com.fiap.to.AulasTO;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.ArrayList;

@Path("/aula")
public class AulaResource {
    private AulasBO aulasBO = new AulasBO();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/buscaPorCurso/{idCurso}")
    public Response findByIdCurso(Long idCurso) {
        ArrayList<AulasTO> resultado = aulasBO.findByIdCurso(idCurso);
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
    @Path("/buscaPorAula/{idAula}")
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
