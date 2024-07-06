package org.diecastfinder.catalog.service;

import java.time.Instant;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.diecastfinder.catalog.web.model.CatalogModelDto;
import org.diecastfinder.catalog.web.model.FoundModelDto;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class CatalogServiceImpl implements CatalogService {

    @Override
    public List<CatalogModelDto> getAllFoundModels() {
        //Todo update to real fetch from DB
        log.debug("Showing models...");
        return List.of(CatalogModelDto.builder()
                .uri("www.olxx.com")
                .nameRequested("McLaren P1")
                .producer("Autoart")
                .price(699)
                .currency("zl")
                .firstFoundDate(Instant.now().toString())
                .isActive(true)
                .isFavourite(true)
                .lotTitle("McLaren P1 Autoart 699 okazia!!!")
                .build());
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
            .firstFoundDate(Instant.now().toString())
            .isActive(true)
            .isFavourite(false)
            .lotTitle(foundModel.getLotTitle())
            .build();
    }

}
