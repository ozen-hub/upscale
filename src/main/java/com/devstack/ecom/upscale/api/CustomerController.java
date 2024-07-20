package com.devstack.ecom.upscale.api;

import com.devstack.ecom.upscale.dto.request.RequestCustomerDto;
import com.devstack.ecom.upscale.service.CustomerService;
import com.devstack.ecom.upscale.util.StandardResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/customers")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @PostMapping
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    public ResponseEntity<StandardResponse> create(@RequestBody RequestCustomerDto dto) {// data save // http://localhost:8001/api/v1/customers [POST]
        customerService.create(dto);
        return new ResponseEntity<>(
                new StandardResponse(201,"Customer was created!..",null),
                HttpStatus.CREATED
        );
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    public ResponseEntity<StandardResponse> get(@PathVariable String id) {// find data // http://localhost:8001/api/v1/customers/1234 [GET]
        return new ResponseEntity<>(
                new StandardResponse(200,"Customer data!..",customerService.findById(id)),
                HttpStatus.OK
        );
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    public ResponseEntity<StandardResponse> update(@PathVariable String id,
                         @RequestBody RequestCustomerDto dto) {// update data // http://localhost:8001/api/v1/customers [PUT]
        customerService.update(id,dto);
        return new ResponseEntity<>(
                new StandardResponse(201,"Customer was updated!..",null),
                HttpStatus.CREATED
        );
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    public ResponseEntity<StandardResponse> delete(@PathVariable String id) {// remove data // http://localhost:8001/api/v1/customers [DELETE]
       customerService.delete(id);
        return new ResponseEntity<>(
                new StandardResponse(204,"Customer was deleted!..",null),
                HttpStatus.NO_CONTENT
        );
    }

    @GetMapping("/list")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_USER')")
    public ResponseEntity<StandardResponse> getAll(
            @RequestParam String searchText,
            @RequestParam int page,
            @RequestParam int size
    ) {// find data // http://localhost:8001/api/v1/customers/list [GET]

        return new ResponseEntity<>(
                new StandardResponse(200,"Customer list!..",
                        customerService.findAll(searchText, page, size)),
                HttpStatus.OK
        );
    }
}
