package com.henriquenascimento.mapper;

import com.henriquenascimento.domain.Order;
import com.henriquenascimento.dto.OrderRequestDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;


@Mapper(uses = OrderRequestMapper.class)
public interface OrderRequestMapper {

//    OrderRequestMapper INSTANCE = Mappers.getMapper(OrderRequestMapper.class);
    OrderRequestMapper MAPPER = Mappers.getMapper(OrderRequestMapper.class);

    OrderRequestDTO toDTO(final Order entity);

    List<OrderRequestDTO> toListDTO(final List<Order> entity);

    Order toEntity(final OrderRequestDTO dto);

    List<Order> toListEntity(final List<OrderRequestDTO> dto);

}
