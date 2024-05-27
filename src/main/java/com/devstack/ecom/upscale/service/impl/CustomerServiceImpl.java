package com.devstack.ecom.upscale.service.impl;

import com.devstack.ecom.upscale.dto.request.RequestCustomerDto;
import com.devstack.ecom.upscale.entity.Customer;
import com.devstack.ecom.upscale.repo.CustomerRepo;
import com.devstack.ecom.upscale.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepo customerRepo;

    @Override
    public void create(RequestCustomerDto dto) {
        Customer customer = Customer.builder()
                .propertyId(UUID.randomUUID().toString())
                .name(dto.getName())
                .address(dto.getAddress())
                .email(dto.getEmail())
                .phone(dto.getPhone())
                .isActive(dto.isActive())
                .build();
        customerRepo.save(customer);
    }
}
