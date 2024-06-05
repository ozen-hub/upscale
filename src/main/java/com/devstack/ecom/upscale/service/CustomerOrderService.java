package com.devstack.ecom.upscale.service;

import com.devstack.ecom.upscale.dto.request.RequestCustomerDto;
import com.devstack.ecom.upscale.dto.request.RequestCustomerOrderDto;
import com.devstack.ecom.upscale.dto.response.ResponseCustomerDto;
import com.devstack.ecom.upscale.dto.response.ResponseCustomerOrderDto;
import com.devstack.ecom.upscale.dto.response.paginate.CustomerOrderPaginateDto;
import com.devstack.ecom.upscale.dto.response.paginate.CustomerPaginateDto;

public interface CustomerOrderService {
    public void create(RequestCustomerOrderDto dto);
    public ResponseCustomerOrderDto findById(String id);
    public void update(String id,RequestCustomerOrderDto dto);
    public CustomerOrderPaginateDto findAll(String customerId, int page, int size);
    public void delete(String id);
}
