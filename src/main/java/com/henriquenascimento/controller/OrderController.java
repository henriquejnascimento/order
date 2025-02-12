package com.henriquenascimento.controller;

import com.henriquenascimento.dto.OrderRequestDTO;
import com.henriquenascimento.dto.OrderResponseDTO;
import com.henriquenascimento.service.OrderService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.UriInfo;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.jboss.resteasy.reactive.RestResponse;

@Path("/orders")
@ApplicationScoped
//@RequiredArgsConstructor
public class OrderController {

    private OrderService orderService;

    OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GET
    @Path("/{id}")
    public RestResponse<OrderResponseDTO> findById(final Long id) {
        orderService.findById(id);
        return RestResponse.ok();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public RestResponse<OrderResponseDTO> save(final OrderRequestDTO orderRequestDTO,
                                               @Context UriInfo uriInfo) {
        this.orderService.save(orderRequestDTO);
        return RestResponse.created(uriInfo.getAbsolutePath());
    }

//    @PUT
//    @Transactional
//    public RestResponse<Void> update(final OrderRequestDTO orderRequestDTO) {
//        orderService.update(orderRequestDTO);
//        return RestResponse.ok();
//    }

    @DELETE
    @Path("{id}")
    @Transactional
    public RestResponse<Void> delete(final Long id) {
        orderService.delete(id);
        return RestResponse.ok();
    }
}
