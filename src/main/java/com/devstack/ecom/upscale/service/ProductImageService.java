package com.devstack.ecom.upscale.service;

import com.devstack.ecom.upscale.dto.request.RequestCustomerDto;
import com.devstack.ecom.upscale.dto.request.RequestProductImageDto;
import com.devstack.ecom.upscale.dto.response.ResponseCustomerDto;
import com.devstack.ecom.upscale.dto.response.ResponseProductImageDto;
import com.devstack.ecom.upscale.dto.response.paginate.CustomerPaginateDto;

import java.io.IOException;
import java.sql.SQLException;

public interface ProductImageService {
    public void create(RequestProductImageDto dto, String productId) throws SQLException, IOException;
    public ResponseProductImageDto findById(String id);
    public void delete(String id);
}
