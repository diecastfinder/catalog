package org.diecastfinder.catalog.service;

import java.util.List;
import java.util.Objects;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.diecastfinder.catalog.repositories.CatalogModelRepository;
import org.diecastfinder.catalog.repositories.domain.CatalogModel;
import org.diecastfinder.catalog.web.mappers.CatalogModelMapper;
import org.diecastfinder.catalog.web.mappers.FoundModelDtoMapper;
import org.diecastfinder.catalog.web.model.CatalogModelDto;
import org.diecastfinder.model.FoundModelDto;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class CatalogServiceImpl implements CatalogService {

    private final CatalogModelRepository repository;
    private final CatalogModelMapper catalogModelMapper;
    private final FoundModelDtoMapper foundModelDtoMapper;

    @Override
    public List<CatalogModelDto> getAllFoundModels(Boolean isOnlyActive) {

        List<CatalogModel> models;

        if (Objects.isNull(isOnlyActive) || isOnlyActive) {
            models = repository.findByIsActiveTrue();
        } else {
            models = repository.findAll();
        }

        return models.stream()
            .map(catalogModelMapper::catalogModelToCatalogModelDto)
            .toList();
    }

    @Override
    public CatalogModelDto saveNewModel(FoundModelDto foundModel) {
        CatalogModel model = foundModelDtoMapper.foundModelDtoToCatalogModel(foundModel);
        model.setIsActive(true);
        repository.save(model);

        CatalogModelDto modelDto = catalogModelMapper.catalogModelToCatalogModelDto(model);
        return modelDto;
    }
}
