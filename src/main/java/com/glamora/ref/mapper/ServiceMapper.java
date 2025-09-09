package com.glamora.ref.mapper;



import com.glamora.ref.dtos.CategoryDTO;
import com.glamora.ref.dtos.ServiceDTO;
import com.glamora.ref.models.Category;
import com.glamora.ref.models.ServiceEntity;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface ServiceMapper {

    @Mapping(source = "category.code", target = "categoryCode")
    ServiceDTO toDto(ServiceEntity entity);

    @Mapping(source = "categoryCode", target = "category.code")
    ServiceEntity toEntity(ServiceDTO dto);

    CategoryDTO toDto(Category entity);

    Category toEntity(CategoryDTO dto);
}

