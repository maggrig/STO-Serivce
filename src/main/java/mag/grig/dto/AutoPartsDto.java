package mag.grig.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * A DTO for the {@link mag.grig.entity.AutoParts} entity
 */
@Data
public class AutoPartsDto implements Serializable {
    private final Long id;
    private final String name;
    private final String description;
    private final CarDto car;
    private final Long carVINId;
}