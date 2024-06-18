package com.devstack.ecom.upscale.service;

import com.devstack.ecom.upscale.dto.response.ResponseProductImageDto;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.sql.SQLException;

public interface ProductImageService {
    public void create(MultipartFile file, String productId) throws SQLException, IOException;
    public ResponseProductImageDto findById(String id);
    public void delete(String id);
}
