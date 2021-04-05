package com.hit.open.api.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@Data
@EqualsAndHashCode
@Entity
@Table(name = "laptop_info")
public class Laptop {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "company", nullable = false)
    private String company;
    @Column(name = "price", nullable = false)
    private Integer price;
    @Column(name = "ram", nullable = false)
    private Integer ram;
}
