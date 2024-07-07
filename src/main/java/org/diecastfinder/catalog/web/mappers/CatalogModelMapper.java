package org.diecastfinder.catalog.web.mappers;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import org.diecastfinder.catalog.repositories.domain.CatalogModel;
import org.diecastfinder.catalog.web.model.CatalogModelDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = Timestamp.class)
public interface CatalogModelMapper {
    CatalogModelDto catalogModelToCatalogModelDto(CatalogModel catalogModel);

    CatalogModel catalogModelDtoToCatalogModel(CatalogModelDto catalogModelDto);
}
