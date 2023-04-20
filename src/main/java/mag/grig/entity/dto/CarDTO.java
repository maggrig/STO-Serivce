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
import mag.grig.entity.Car;

/**
 * A DTO for the {@link Car} entity
 */
@Data
@AllArgsConstructor
public class CarDTO {
    private Long id;
    private String name;
    private String number;
    private String brand;
    private String birthday;
    private Long carVINId;
    private Long client;
}