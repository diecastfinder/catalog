package org.diecastfinder.catalog.service;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;
import java.util.Objects;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.diecastfinder.catalog.repositories.CatalogModelRepository;
import org.diecastfinder.catalog.repositories.domain.CatalogModel;
import org.diecastfinder.catalog.web.mappers.CatalogModelMapper;
import org.diecastfinder.catalog.web.model.CatalogModelDto;
import org.diecastfinder.catalog.web.model.FoundModelDto;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class CatalogServiceImpl implements CatalogService {

    private final CatalogModelRepository repository;
    private final CatalogModelMapper mapper;

    @Override
    public List<CatalogModelDto> getAllFoundModels(Boolean isOnlyActive) {

        List<CatalogModel> models;

        if (Objects.isNull(isOnlyActive) || isOnlyActive) {
            models = repository.findByIsActiveTrue();
        } else {
            models = repository.findAll();
        }

        return models.stream()
            .map(mapper::catalogModelToCatalogModelDto)
            .toList();
    }

    @Override
    public CatalogModelDto saveNewModel(FoundModelDto foundModel) {
        //Todo update to real insert to DB
        log.debug("Saving model...");
        return CatalogModelDto.builder()
            .uri(foundModel.getUri())
            .nameRequested(foundModel.getNameRequested())
            .producer(foundModel.getProducer())
            .price(foundModel.getPrice())
            .currency(foundModel.getCurrency())
            .firstFoundDate(Timestamp.from(Instant.now()))
            .isActive(true)
            .isFavourite(false)
            .lotTitle(foundModel.getLotTitle())
            .build();
    }

}
