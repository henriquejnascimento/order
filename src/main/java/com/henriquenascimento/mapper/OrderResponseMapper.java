package com.henriquenascimento.mapper;

import com.henriquenascimento.domain.Order;
import com.henriquenascimento.dto.OrderResponseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;


@Mapper(uses = OrderResponseMapper.class)
public interface OrderResponseMapper {

//    OrderResponseMapper INSTANCE = Mappers.getMapper(OrderResponseMapper.class);
    OrderResponseMapper MAPPER = Mappers.getMapper(OrderResponseMapper.class);

    OrderResponseDTO toDTO(final Order entity);

    List<OrderResponseDTO> toListDTO(final List<Order> entity);

    Order toEntity(final OrderResponseDTO dto);

    List<Order> toListEntity(final List<OrderResponseDTO> dto);

}
