package com.henriquenascimento.dto;

//import com.henriquenascimento.demo.constant.GlobalConstant;
//import jakarta.validation.constraints.NotEmpty;
//import jakarta.validation.constraints.Size;
import com.henriquenascimento.enumerator.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderRequestDTO {

    private Long customerId;
    //private Timestamp createdAt;
    //private Timestamp updatedAt;
    private String note;
    //private Boolean deleted;
    //private OrderStatus orderStatus;

}
