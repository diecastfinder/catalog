package org.diecastfinder.catalog.service;

import java.util.List;
import org.diecastfinder.catalog.web.model.CatalogModelDto;
import org.diecastfinder.model.FoundModelDto;

public interface CatalogService {
    List<CatalogModelDto> getAllFoundModels(Boolean isOnlyActive);

    CatalogModelDto saveNewModel(FoundModelDto foundModel);

}
