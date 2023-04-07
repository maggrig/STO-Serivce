package mag.grig.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * A DTO for the {@link mag.grig.entity.Car} entity
 */
@Data
public class CarDto implements Serializable {
    private final Long id;
    private final String name;
    private final String number;
    private final String brand;
    private final Date birthday;
    private final Long carVINId;
}