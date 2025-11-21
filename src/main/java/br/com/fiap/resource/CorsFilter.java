package br.com.fiap.resource;

import jakarta.ws.rs.HttpMethod;
import jakarta.ws.rs.container.ContainerRequestContext;
import jakarta.ws.rs.container.ContainerRequestFilter;
import jakarta.ws.rs.container.ContainerResponseContext;
import jakarta.ws.rs.container.ContainerResponseFilter;
import jakarta.ws.rs.container.PreMatching;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.Provider;

import java.io.IOException;

@Provider
@PreMatching
public class CorsFilter implements ContainerRequestFilter, ContainerResponseFilter {

    @Override
    public void filter(ContainerRequestContext request) throws IOException {
        // Trata requisições OPTIONS (preflight)
        if (HttpMethod.OPTIONS.equals(request.getMethod())) {
            String origin = request.getHeaderString("Origin");

            Response.ResponseBuilder builder = Response.ok();

            if (origin != null) {
                builder.header("Access-Control-Allow-Origin", origin);
                builder.header("Access-Control-Allow-Credentials", "true");
                builder.header("Vary", "Origin");
            } else {
                builder.header("Access-Control-Allow-Origin", "*");
            }

            builder.header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization");
            builder.header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD");
            builder.header("Access-Control-Max-Age", "86400");

            request.abortWith(builder.build());
        }
    }

    @Override
    public void filter(ContainerRequestContext request, ContainerResponseContext response) throws IOException {
        String origin = request.getHeaderString("Origin");

        if (origin != null) {
            response.getHeaders().putSingle("Access-Control-Allow-Origin", origin);
            response.getHeaders().putSingle("Access-Control-Allow-Credentials", "true");
            response.getHeaders().putSingle("Vary", "Origin");
        } else {
            response.getHeaders().putSingle("Access-Control-Allow-Origin", "*");
        }

        response.getHeaders().putSingle("Access-Control-Allow-Headers", "origin, content-type, accept, authorization");
        response.getHeaders().putSingle("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD");
        response.getHeaders().putSingle("Access-Control-Max-Age", "86400");
    }
}