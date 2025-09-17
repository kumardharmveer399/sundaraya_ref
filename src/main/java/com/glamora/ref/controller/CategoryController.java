package com.glamora.ref.controller;


import com.glamora.ref.common.model.CommonUtils;
import com.glamora.ref.common.model.ResponseModel;
import com.glamora.ref.common.util.MessageCode;
import com.glamora.ref.dtos.CategoryDTO;
import com.glamora.ref.dtos.ServiceDTO;
import com.glamora.ref.service.CategoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;


@RestController
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private CommonUtils commonUtils;

    private static final Logger logger = LoggerFactory.getLogger(CategoryController.class);

    @GetMapping("/category")
    public Page<CategoryDTO> getAllCategory(Pageable pageable) {
        try {
            return categoryService.getAllCategory(pageable);
        } catch (Exception e) {
            return Page.empty();
        }
    }

    @GetMapping("/category/{id}")
    public ResponseEntity<ResponseModel> getCategoryById(@PathVariable Long id) {
        try {
            CategoryDTO category = categoryService.getCategoryById(id);
            return ResponseEntity.ok(
                    commonUtils.createResponseModel(
                            MessageCode.CATEGORY_FOUND_SUCCESS.getCode(),
                            MessageCode.CATEGORY_FOUND_SUCCESS.getMessage(),
                            category
                    )
            );
        } catch (IllegalArgumentException e) {
            logger.error("Category not found: {}", e.getMessage(), e);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    commonUtils.createResponseModel(
                            MessageCode.CATEGORY_NOT_FOUND.getCode(),
                            MessageCode.CATEGORY_NOT_FOUND.getMessage()
                    )
            );
        }
    }

    @GetMapping("/category/code/{code}")
    public ResponseEntity<ResponseModel> getCategoryByCode(@PathVariable String code) {
        try {
            CategoryDTO category = categoryService.getCategoryByCode(code);
            return ResponseEntity.ok(
                    commonUtils.createResponseModel(
                            MessageCode.CATEGORY_FOUND_SUCCESS.getCode(),
                            MessageCode.CATEGORY_FOUND_SUCCESS.getMessage(),
                            category
                    )
            );
        } catch (IllegalArgumentException e) {
            logger.error("Category not found: {}", e.getMessage(), e);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    commonUtils.createResponseModel(
                            MessageCode.CATEGORY_NOT_FOUND.getCode(),
                            MessageCode.CATEGORY_NOT_FOUND.getMessage()
                    )
            );
        }
    }

    @GetMapping("/category/services")
    public Page<ServiceDTO> getAllService(Pageable pageable) {
        try {
            return categoryService.getAllService(pageable);
        } catch (Exception e) {
            return Page.empty();
        }
    }

    @GetMapping("/category/services/{id}")
    public ResponseEntity<ResponseModel> getServiceById(@PathVariable Long id) {
        try {
            ServiceDTO service = categoryService.getServiceById(id);
            return ResponseEntity.ok(
                    commonUtils.createResponseModel(
                            MessageCode.SERVICE_FOUND_SUCCESS.getCode(),
                            MessageCode.SERVICE_FOUND_SUCCESS.getMessage(),
                            service
                    )
            );
        } catch (IllegalArgumentException e) {
            logger.error("Service not found: {}", e.getMessage(), e);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    commonUtils.createResponseModel(
                            MessageCode.SERVICE_NOT_FOUND.getCode(),
                            MessageCode.SERVICE_NOT_FOUND.getMessage()
                    )
            );
        }
    }

    @GetMapping("/category/services/code/{code}")
    public ResponseEntity<ResponseModel> getByServiceCode(@PathVariable String code) {
        try {
            ServiceDTO service = categoryService.getServiceByCode(code);
            return ResponseEntity.ok(
                    commonUtils.createResponseModel(
                            MessageCode.SERVICE_FOUND_SUCCESS.getCode(),
                            MessageCode.SERVICE_FOUND_SUCCESS.getMessage(),
                            service
                    )
            );
        } catch (IllegalArgumentException e) {
            logger.error("Service not found: {}", e.getMessage(), e);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    commonUtils.createResponseModel(
                            MessageCode.SERVICE_NOT_FOUND.getCode(),
                            MessageCode.SERVICE_NOT_FOUND.getMessage()
                    )
            );
        }
    }
}
