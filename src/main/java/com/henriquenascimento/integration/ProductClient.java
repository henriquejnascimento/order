package com.henriquenascimento.integration;

import com.henriquenascimento.dto.ProductResponseDTO;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@Path("/products/")
@RegisterRestClient(configKey = "products-api")
public interface ProductClient {

    @GET
    @Path("{id}")
    ProductResponseDTO findById(final String id);

}
