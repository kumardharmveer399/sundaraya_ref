package com.glamora.ref.service;

import com.glamora.ref.dtos.CategoryDTO;
import com.glamora.ref.dtos.ServiceDTO;
import com.glamora.ref.mapper.ServiceMapper;
import com.glamora.ref.models.Category;
import com.glamora.ref.models.ServiceEntity;
import com.glamora.ref.repositories.CategoryRepository;
import com.glamora.ref.repositories.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ServiceRepository serviceRepository;

    @Autowired
    private ServiceMapper serviceMapper;

    @Override
    public Page<CategoryDTO> getAllCategory(Pageable pageable) {
        return categoryRepository.findAll(pageable)
                .map(serviceMapper::toDto);
    }

    @Override
    public CategoryDTO getCategoryById(Long id) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Category not found with id " + id));
        return serviceMapper.toDto(category);
    }

    @Override
    public CategoryDTO getCategoryByCode(String code) {
        Category category = categoryRepository.findByCode(code)
                .orElseThrow(() -> new IllegalArgumentException("Category not found with code " + code));
        return serviceMapper.toDto(category);
    }


    @Override
    public Page<ServiceDTO> getAllService(Pageable pageable) {
        return serviceRepository.findAll(pageable)
                .map(serviceMapper::toDto);

    }

    @Override
    public ServiceDTO getServiceById(Long id) {
        ServiceEntity service = serviceRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Service not found with id " + id));
        return serviceMapper.toDto(service);
    }

    @Override
    public ServiceDTO getServiceByCode(String code) {
        ServiceEntity service = serviceRepository.findByCode(code)
                .orElseThrow(() -> new IllegalArgumentException("Service not found with code " + code));
        return serviceMapper.toDto(service);
    }
}
