package org.diecastfinder.catalog.web.model;

import java.sql.Timestamp;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Accessors(chain = true)
@ToString
public class CatalogModelDto {
    private String uri;
    private String nameRequested;
    private String lotTitle;
    private String producer;
    private Integer price;
    private String currency;
    private Timestamp firstFoundDate;
    private Boolean isFavourite;
    private Boolean isActive;
}
