package org.diecastfinder.catalog.repositories;

import java.util.List;
import java.util.UUID;
import org.diecastfinder.catalog.repositories.domain.CatalogModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CatalogModelRepository extends JpaRepository<CatalogModel, UUID> {
    List<CatalogModel> findByIsActiveTrue();
}
