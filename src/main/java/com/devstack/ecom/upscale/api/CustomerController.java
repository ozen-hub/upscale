package com.devstack.ecom.upscale.api;

import com.devstack.ecom.upscale.dto.request.RequestCustomerDto;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {

    @PostMapping
    public String create(@RequestBody RequestCustomerDto dto){// data save // http://localhost:8001/api/v1/customers [POST]
        return "create()";
    }

    @GetMapping("/{id}")
    public String get(@PathVariable String id){// find data // http://localhost:8001/api/v1/customers/1234 [GET]
        return "get()";
    }

    @PutMapping
    public String update(@RequestBody RequestCustomerDto dto){// update data // http://localhost:8001/api/v1/customers [PUT]
        return "update()";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable String id){// remove data // http://localhost:8001/api/v1/customers [DELETE]
        return "delete()";
    }

    @GetMapping("/list")
    public String getAll(
            @RequestParam String searchText,
            @RequestParam int page,
            @RequestParam int size
    ){// find data // http://localhost:8001/api/v1/customers/list [GET]
        return "getAll()";
    }
}
