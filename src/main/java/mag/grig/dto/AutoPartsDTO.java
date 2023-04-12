package mag.grig.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * A DTO for the {@link mag.grig.entity.AutoParts} entity
 */
@Data
public class AutoPartsDTO implements Serializable {
    private static final long serialVersionUID = -4673831996188890822L;
    private final Long id;
    private final String name;
    private final String description;
    private final Long carId;
    private final String carName;
    private final String carNumber;
    private final String carBrand;
    private final Date carBirthday;
    private final Long carCarVINId;
    private final Long carVINId;
}