package com.share.market.equity.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "Equity")
@Getter
@Setter

public class Equity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String equityName;
    private int quantities;
    private Double price;

}
