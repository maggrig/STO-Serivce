package mag.grig.dto;

import lombok.Data;
import mag.grig.entity.Car;

/**
 * A DTO for the {@link Car} entity
 */
@Data
public class CarDTO {
    private Long id;
    private String name;
    private String number;
    private String brand;
    private String birthday;
    private Long carVINId;
}