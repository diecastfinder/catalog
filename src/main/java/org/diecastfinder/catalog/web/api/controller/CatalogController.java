package org.diecastfinder.catalog.web.api.controller;

import java.util.List;
import org.diecastfinder.catalog.service.CatalogService;
import org.diecastfinder.catalog.web.model.CatalogModelDto;
import org.diecastfinder.catalog.web.model.FoundModelDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/v1/catalog")
@RestController
public class CatalogController {

    @Autowired
    CatalogService catalogService;

    @GetMapping
    public ResponseEntity<List<CatalogModelDto>> getAllFoundModels(@RequestParam(required = false) Boolean onlyActive) {
        return new ResponseEntity<>(catalogService.getAllFoundModels(onlyActive), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<List<CatalogModelDto>> saveModel(@RequestBody FoundModelDto foundModel) {
        CatalogModelDto savedModel = catalogService.saveNewModel(foundModel);
        HttpHeaders headers = new HttpHeaders();

        // todo update to real host name
        headers.add("Location", "http://localhost:8080/api/v1/catalog/" + savedModel.getUri());

        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }

}
