package com.devstack.ecom.upscale.api;

import com.devstack.ecom.upscale.dto.request.RequestCustomerDto;
import com.devstack.ecom.upscale.service.CustomerService;
import com.devstack.ecom.upscale.util.StandardResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/customers")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @PostMapping
    public ResponseEntity<StandardResponse> create(@RequestBody RequestCustomerDto dto) {// data save // http://localhost:8001/api/v1/customers [POST]
        customerService.create(dto);
        return new ResponseEntity<>(
                new StandardResponse(201,"Customer was created!..",null),
                HttpStatus.CREATED
        );
    }

    @GetMapping("/{id}")
    public String get(@PathVariable String id) {// find data // http://localhost:8001/api/v1/customers/1234 [GET]
        return "get()";
    }

    @PutMapping
    public String update(@RequestBody RequestCustomerDto dto) {// update data // http://localhost:8001/api/v1/customers [PUT]
        return "update()";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable String id) {// remove data // http://localhost:8001/api/v1/customers [DELETE]
        return "delete()";
    }

    @GetMapping("/list")
    public String getAll(
            @RequestParam String searchText,
            @RequestParam int page,
            @RequestParam int size
    ) {// find data // http://localhost:8001/api/v1/customers/list [GET]
        return "getAll()";
    }
}
