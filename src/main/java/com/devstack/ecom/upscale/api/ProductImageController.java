package com.devstack.ecom.upscale.api;

import com.devstack.ecom.upscale.dto.request.RequestProductDto;
import com.devstack.ecom.upscale.service.ProductImageService;
import com.devstack.ecom.upscale.service.ProductService;
import com.devstack.ecom.upscale.util.StandardResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.sql.SQLException;

@RestController
@RequestMapping("/api/v1/product-images")
@RequiredArgsConstructor
public class ProductImageController {

    private final ProductImageService productImageService;

    @PostMapping("/{product}")
    public ResponseEntity<StandardResponse>
    create(@RequestParam("productImage") MultipartFile file,
                                                   @PathVariable String product) throws SQLException, IOException {
        productImageService.create(file,product);
        return new ResponseEntity<>(
                new StandardResponse(201,"Product Image was created!..",null),
                HttpStatus.CREATED
        );
    }
}
