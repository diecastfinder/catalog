package org.diecastfinder.catalog.service;

import java.util.List;
import org.diecastfinder.catalog.web.model.CatalogModelDto;
import org.diecastfinder.catalog.web.model.FoundModelDto;

public interface CatalogService {
    List<CatalogModelDto> getAllFoundModels();

    CatalogModelDto saveNewModel(FoundModelDto foundModel);

}
