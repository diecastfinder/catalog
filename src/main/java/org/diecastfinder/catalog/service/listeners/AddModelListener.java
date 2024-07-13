package org.diecastfinder.catalog.service.listeners;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.diecastfinder.catalog.config.JmsConfig;
import org.diecastfinder.catalog.service.CatalogService;
import org.diecastfinder.model.AddModelEvent;
import org.diecastfinder.model.FoundModelDto;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
@Slf4j
public class AddModelListener {

    private final CatalogService catalogService;

    @Transactional
    @JmsListener(destination = JmsConfig.ADD_MODEL_QUEUE)
    public void listen(AddModelEvent addModelEvent) {
        FoundModelDto foundModelDto = addModelEvent.getFoundModelDto();
        catalogService.saveNewModel(foundModelDto);
        log.debug(String.format("Model %s was added to catalog", foundModelDto.getLotTitle()));
    }
}
