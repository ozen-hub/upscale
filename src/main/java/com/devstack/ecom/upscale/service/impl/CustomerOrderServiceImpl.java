package com.devstack.ecom.upscale.service.impl;

import com.devstack.ecom.upscale.dto.request.RequestCustomerOrderDto;
import com.devstack.ecom.upscale.dto.response.ResponseCustomerOrderDto;
import com.devstack.ecom.upscale.dto.response.paginate.CustomerOrderPaginateDto;
import com.devstack.ecom.upscale.dto.response.paginate.CustomerPaginateDto;
import com.devstack.ecom.upscale.entity.Customer;
import com.devstack.ecom.upscale.entity.CustomerOrder;
import com.devstack.ecom.upscale.entity.Product;
import com.devstack.ecom.upscale.exception.EntryNotFoundException;
import com.devstack.ecom.upscale.repo.CustomerOrderRepo;
import com.devstack.ecom.upscale.repo.CustomerRepo;
import com.devstack.ecom.upscale.repo.ProductRepo;
import com.devstack.ecom.upscale.service.CustomerOrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class CustomerOrderServiceImpl implements CustomerOrderService {
    private CustomerOrderRepo customerOrderRepo;
    private CustomerRepo customerRepo;
    private ProductRepo productRepo;

    @Override
    public void create(RequestCustomerOrderDto dto) {

        Optional<Customer> selectedCustomer = customerRepo.findById(dto.getCustomer());
        if (selectedCustomer.isEmpty()){
            throw new EntryNotFoundException("Customer Not Found");
        }

        Optional<Product> selectedProduct = productRepo.findById(dto.getProduct());
        if (selectedProduct.isEmpty()) {
            throw new EntryNotFoundException("Product not found");
        }

        CustomerOrder customerOrder = CustomerOrder.builder()
                .propertyId(UUID.randomUUID().toString())
                .customer(selectedCustomer.get())
                .createdDate(dto.getCreatedDate())
                .product(selectedProduct.get())
                .total(dto.getTotal())
                .qty(dto.getQty())
                .build();
        customerOrderRepo.save(customerOrder);
    }

    @Override
    public ResponseCustomerOrderDto findById(String id) {
        Optional<CustomerOrder> selectedOrder = customerOrderRepo.findById(id);
        if (selectedOrder.isEmpty()) {
            throw new EntryNotFoundException("Order not found");
        }
        return createCustomerOrderDto(selectedOrder.get());
    }

    @Override
    public void update(String id, RequestCustomerOrderDto dto) {
    // not necessary.....
    }

    @Override
    public CustomerOrderPaginateDto findAll(String customerId, int page, int size) {
        return CustomerOrderPaginateDto.builder()
                .dataList(customerOrderRepo.findAllWithSearchText(customerId, PageRequest.of(page, size))
                        .stream().map(this::createCustomerOrderDto).toList())
                .count(
                        customerOrderRepo.countAllWithSearchText(customerId)
                )
                .build();
    }

    @Override
    public void delete(String id) {
        customerOrderRepo.deleteById(id);
    }

    private ResponseCustomerOrderDto createCustomerOrderDto(CustomerOrder o){
        return ResponseCustomerOrderDto.builder()
                .propertyId(o.getPropertyId())
                .createdDate(o.getCreatedDate())
                .customer(o.getCustomer().getName())
                .total(o.getTotal())
                .product(o.getProduct().getDescription())
                .qty(o.getQty())
                .build();
    }
}
