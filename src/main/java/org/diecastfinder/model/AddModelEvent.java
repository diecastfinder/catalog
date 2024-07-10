package org.diecastfinder.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.diecastfinder.catalog.web.model.FoundModelDto;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AddModelEvent {

    static final long serialVersionUID = -5226814208277322666L;
    private FoundModelDto foundModelDto;

}
