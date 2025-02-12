package com.henriquenascimento.service;

import com.henriquenascimento.domain.Order;
import com.henriquenascimento.dto.OrderRequestDTO;
import com.henriquenascimento.dto.OrderResponseDTO;
import com.henriquenascimento.dto.ProductResponseDTO;
import com.henriquenascimento.integration.ProductClient;
import com.henriquenascimento.mapper.OrderRequestMapper;
import com.henriquenascimento.mapper.OrderResponseMapper;
import com.henriquenascimento.repository.OrderRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ObjectUtils;
import org.eclipse.microprofile.rest.client.inject.RestClient;

@ApplicationScoped
@RequiredArgsConstructor
@Slf4j
public class OrderService {

    @RestClient
    private ProductClient productClient;
//    private final OrderRequestMapper orderRequestMapper;
//    private final OrderResponseMapper orderResponseMapper;
    @Inject
    OrderRepository orderRepository;

    public OrderResponseDTO findById(final Long id) {
        Order order = orderRepository.findById(id);
        if (ObjectUtils.isEmpty(order)) {
            throw new IllegalArgumentException("Order not found");
        }
        return OrderResponseMapper.MAPPER.toDTO(order);
    }

    public OrderResponseDTO save(final OrderRequestDTO orderRequestDTO) {

        //Order order = new Order();
        //order.setNote(orderRequestDTO.getNote());

        Order order = OrderRequestMapper.MAPPER.toEntity(orderRequestDTO);
        orderRepository.persist(order);
        return OrderResponseMapper.MAPPER.toDTO(order);
    }
//
//    public Response update(final Long id,
//                           final OrderRequestDTO orderRequestDTO) {
//        findById(id);
//        //        Order
////        orderRepository.update(order);
//    }

    public void delete(final Long id) {
        //log.info("Order with id {} deleting...", id);
        orderRepository.deleteById(id);
        //log.info("Order deleted");
    }



    public ProductResponseDTO productFindById(final String id) {
        ProductResponseDTO productResponseDTO = productClient.findById(id);
        if (ObjectUtils.isEmpty(productResponseDTO)) {
            throw new IllegalArgumentException("Product not found");
        }
        return productResponseDTO;
    }
}
