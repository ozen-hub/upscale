package com.devstack.ecom.upscale.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity(name = "product")
public class Product {
    @Id
    @Column(name="property_id")
    private String propertyId;
    private Long qty;
    private Double unitPrice;
    private String description;
    @OneToMany(mappedBy = "product", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private HashSet<ProductImage> images = new HashSet<>();

}
