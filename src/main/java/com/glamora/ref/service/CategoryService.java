package com.glamora.ref.service;

import com.glamora.ref.dtos.CategoryDTO;
import com.glamora.ref.dtos.ServiceDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CategoryService {
    Page<CategoryDTO> getAllCategory(Pageable pageable);

    CategoryDTO getCategoryById(Long id);

    CategoryDTO getCategoryByCode(String code);

    Page<ServiceDTO> getAllService(Pageable pageable);

    ServiceDTO getServiceById(Long id);

    ServiceDTO getServiceByCode(String code);
}
