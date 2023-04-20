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

/**
 * A DTO for the {@link mag.grig.entity.Post} entity
 */
@Data
@AllArgsConstructor
public class PostDTO {
    private Long id;
    private Long userId;
    private String name;
//    private  boolean enabled;
}