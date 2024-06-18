package com.devstack.ecom.upscale.api;

import com.devstack.ecom.upscale.dto.request.RequestCustomerDto;
import com.devstack.ecom.upscale.dto.request.RequestCustomerOrderDto;
import com.devstack.ecom.upscale.service.CustomerOrderService;
import com.devstack.ecom.upscale.service.CustomerService;
import com.devstack.ecom.upscale.util.StandardResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/customer_orders")
@RequiredArgsConstructor
public class CustomerOrderController {

    private final CustomerOrderService customerOrderService;

    @PostMapping
    public ResponseEntity<StandardResponse> create(@RequestBody RequestCustomerOrderDto dto) {
        customerOrderService.create(dto);
        return new ResponseEntity<>(
                new StandardResponse(201,"Customer Order was created!..",null),
                HttpStatus.CREATED
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<StandardResponse> get(@PathVariable String id) {
        return new ResponseEntity<>(
                new StandardResponse(200,"Customer Order data!..",customerOrderService.findById(id)),
                HttpStatus.OK
        );
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<StandardResponse> delete(@PathVariable String id) {
       customerOrderService.delete(id);
        return new ResponseEntity<>(
                new StandardResponse(204,"Customer Order was deleted!..",null),
                HttpStatus.NO_CONTENT
        );
    }

    @GetMapping("/list")
    public ResponseEntity<StandardResponse> getAll(
            @RequestParam String customerId,
            @RequestParam int page,
            @RequestParam int size
    ) {

        return new ResponseEntity<>(
                new StandardResponse(200,"Customer Order list!..",
                        customerOrderService.findAll(customerId, page, size)),
                HttpStatus.OK
        );
    }
}
