package com.henriquenascimento.domain;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "\"order\"")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String note;

}
