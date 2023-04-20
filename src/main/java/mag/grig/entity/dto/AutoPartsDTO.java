/*
 * Copyright (c) 2023. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package mag.grig.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * A DTO for the {@link mag.grig.entity.AutoParts} entity
 */
@Data
@AllArgsConstructor
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