package org.diecastfinder.catalog.web.mappers;

import org.diecastfinder.catalog.repositories.domain.CatalogModel;
import org.diecastfinder.catalog.web.model.FoundModelDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface FoundModelDtoMapper {

    CatalogModel foundModelDtoToCatalogModel(FoundModelDto foundModelDto);

}
