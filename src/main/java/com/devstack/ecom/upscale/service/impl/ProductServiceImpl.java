package com.devstack.ecom.upscale.service.impl;

import com.devstack.ecom.upscale.dto.request.RequestProductDto;
import com.devstack.ecom.upscale.dto.response.ResponseProductDto;
import com.devstack.ecom.upscale.dto.response.ResponseProductImageDto;
import com.devstack.ecom.upscale.dto.response.paginate.CustomerPaginateDto;
import com.devstack.ecom.upscale.dto.response.paginate.ProductPaginateDto;
import com.devstack.ecom.upscale.entity.Product;
import com.devstack.ecom.upscale.entity.ProductImage;
import com.devstack.ecom.upscale.exception.EntryNotFoundException;
import com.devstack.ecom.upscale.repo.ProductRepo;
import com.devstack.ecom.upscale.service.ProductService;
import com.devstack.ecom.upscale.util.FileDataExtractor;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.*;
@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepo productRepo;
    private final FileDataExtractor fileDataExtractor;

    @Override
    public void create(RequestProductDto dto) {
        System.out.println(dto.getQty());
        System.out.println(dto.getUnitPrice());
        System.out.println(dto.getDescription());
        Product product = Product.builder()
                .description(dto.getDescription())
                .qty(dto.getQty())
                .unitPrice(dto.getUnitPrice())
                .propertyId(UUID.randomUUID().toString())
                .build();
        productRepo.save(product);
    }

    @Override
    public ResponseProductDto findById(String id) {
        Optional<Product> selectedProduct = productRepo.findById(id);
        if (selectedProduct.isEmpty()) {
            throw new EntryNotFoundException("Product not found");
        }
        return createResponseProductDto(selectedProduct.get());
    }

    @Override
    public void update(String id, RequestProductDto dto) {
        Optional<Product> selectedProduct = productRepo.findById(id);
        if (selectedProduct.isEmpty()) {
            throw new EntryNotFoundException("Product not found");
        }

        Product product = Product.builder()
                .description(dto.getDescription())
                .qty(dto.getQty())
                .unitPrice(dto.getUnitPrice())
                .propertyId(id)
                .build();
        productRepo.save(product);

    }

    @Override
    public ProductPaginateDto findAll(String searchText, int page, int size) {
        return ProductPaginateDto.builder()
                .dataList(productRepo.findAllWithSearchText(searchText, PageRequest.of(page, size))
                        .stream().map(this::createResponseProductDto).toList())
                .count(
                        productRepo.countAllWithSearchText(searchText)
                )
                .build();
    }

    @Override
    public void delete(String id) {productRepo.deleteById(id);
    }

    private ResponseProductDto createResponseProductDto(Product product) {

        List<ResponseProductImageDto> images = product.getImages().stream().map(
                this::createResponseProductImage
        ).toList();

        return ResponseProductDto.builder()
                .propertyId(product.getPropertyId())
                .qty(product.getQty())
                .description(product.getDescription())
                .unitPrice(product.getUnitPrice())
                .productImages(images)
                .build();
    }

    private ResponseProductImageDto createResponseProductImage(ProductImage i) {
        return ResponseProductImageDto.builder()
                .hash(fileDataExtractor.byteArrayToString(i.getHash()))
                .directory(fileDataExtractor.byteArrayToString(i.getDirectory()))
                .resourceUrl(fileDataExtractor.byteArrayToString(i.getResourceUrl()))
                .fileName(fileDataExtractor.byteArrayToString(i.getFileName()))
                .propertyId(i.getPropertyId())
                .build();
    }
}
