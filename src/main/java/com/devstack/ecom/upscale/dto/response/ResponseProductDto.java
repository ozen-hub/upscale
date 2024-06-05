package com.devstack.ecom.upscale.dto.response;



import java.util.List;


public class ResponseProductDto {
    private String propertyId;
    private Long qty;
    private Double unitPrice;
    private String description;
    List<ResponseProductImageDto> productImages;
}
