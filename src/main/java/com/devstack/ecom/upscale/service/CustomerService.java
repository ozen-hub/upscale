package com.devstack.ecom.upscale.service;

import com.devstack.ecom.upscale.dto.request.RequestCustomerDto;
import com.devstack.ecom.upscale.dto.response.ResponseCustomerDto;

public interface CustomerService {
    public void create(RequestCustomerDto dto);
    public ResponseCustomerDto findById(String id);
}
