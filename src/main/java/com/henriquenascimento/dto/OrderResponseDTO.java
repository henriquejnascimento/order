package com.henriquenascimento.dto;

//import com.henriquenascimento.demo.constant.GlobalConstant;
//import jakarta.validation.constraints.NotEmpty;
//import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderResponseDTO {

    private Long customerId;
    //private Timestamp createdAt;
    //private Timestamp updatedAt;
    private String note;
    //private Boolean deleted;
    //private OrderStatus orderStatus;

}
