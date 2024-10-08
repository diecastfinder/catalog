package org.diecastfinder.catalog.web.mappers;

import org.diecastfinder.catalog.repositories.domain.CatalogModel;
import org.diecastfinder.catalog.web.model.CatalogModelDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CatalogModelMapper {
    CatalogModelDto catalogModelToCatalogModelDto(CatalogModel catalogModel);

}
