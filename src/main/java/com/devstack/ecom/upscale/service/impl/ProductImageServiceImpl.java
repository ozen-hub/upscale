package com.devstack.ecom.upscale.service.impl;

import com.devstack.ecom.upscale.dto.request.RequestProductImageDto;
import com.devstack.ecom.upscale.dto.response.ResponseProductImageDto;
import com.devstack.ecom.upscale.entity.Product;
import com.devstack.ecom.upscale.entity.ProductImage;
import com.devstack.ecom.upscale.exception.EntryNotFoundException;
import com.devstack.ecom.upscale.repo.ProductImageRepo;
import com.devstack.ecom.upscale.repo.ProductRepo;
import com.devstack.ecom.upscale.service.FileService;
import com.devstack.ecom.upscale.service.ProductImageService;
import com.devstack.ecom.upscale.util.CommonFileSavedBinaryDataDTO;
import com.devstack.ecom.upscale.util.FileDataExtractor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class ProductImageServiceImpl implements ProductImageService {
    @Value("${aws.bucket_name}")
    private String bucketName;
    private final ProductImageRepo productImageRepo;
    private final ProductRepo productRepo;
    private final FileService fileService;
    private final FileDataExtractor dataExtractor;

    @Override
    public void create(RequestProductImageDto dto, String productId) {
        Optional<Product> selectedProduct = productRepo.findById(productId);
        if (selectedProduct.isEmpty()) {
            throw new EntryNotFoundException("the product was not found...");
        }

        CommonFileSavedBinaryDataDTO resource = fileService.createResource(dto.getImage(), "upscale/product_images/", bucketName);

        ProductImage productImage = ProductImage.
                builder()
                .propertyId(UUID.randomUUID().toString())
                .hash(dataExtractor.)
                .directory()
                .fileName()
                .resourceUrl().build();

    }

    @Override
    public ResponseProductImageDto findById(String id) {
        return null;
    }

    @Override
    public void delete(String id) {

    }
}
