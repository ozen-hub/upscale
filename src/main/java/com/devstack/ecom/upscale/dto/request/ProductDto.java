package com.devstack.ecom.upscale.dto.request;

import com.devstack.ecom.upscale.entity.CustomerOrder;
import com.devstack.ecom.upscale.entity.ProductImage;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductDto {
    private Long qty;
    private Double unitPrice;
    private String description;
}
