package org.diecastfinder.catalog.repositories.bootstrap;

import java.sql.Timestamp;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import org.diecastfinder.catalog.repositories.CatalogModelRepository;
import org.diecastfinder.catalog.repositories.domain.CatalogModel;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final CatalogModelRepository repository;

    public BootStrapData(CatalogModelRepository repository) {
        this.repository = repository;
    }

    @Override
    public void run(String... args) {
        if (repository.count() < 1) {
            CatalogModel cm1 = CatalogModel.builder()
                .uri("www.olxx.com")
                .nameRequested("McLaren P1")
                .lotTitle("McLaren P1 Autoart 699 okazia!!!")
                .producer("Autoart")
                .price(699)
                .currency("zl")
                .firstFoundDate(Timestamp.from(Instant.now().minus(2, ChronoUnit.DAYS)))
                .isFavourite(true)
                .isActive(true)
                .build();

            repository.save(cm1);

            CatalogModel cm2 = CatalogModel.builder()
                .uri("www.olxx.com")
                .nameRequested("McLaren P1")
                .lotTitle("McLaren P1 GT3 Autoart RABAT!!!")
                .producer("Autoart")
                .price(800)
                .currency("zl")
                .firstFoundDate(Timestamp.from(Instant.now().minus(200, ChronoUnit.DAYS)))
                .isFavourite(false)
                .isActive(false)
                .build();

            repository.save(cm2);
        }

        System.out.println("Started in bootstrap");
        System.out.println("Number of models: " + repository.count());
    }
}
