/*
 * Copyright (c) 2023. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package mag.grig.entity.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * A DTO for the {@link mag.grig.entity.Client} entity
 */
@Data
@AllArgsConstructor
public class ClientDTO {
    private Long id;
    @NotNull(message = "Name should not be empty")
    @Size(min = 4, max = 30, message = "Name should be between 4 and 30 characters")
    private String name;
    @NotNull(message = "Email should not be empty")
    @Email
    private String email;
    private String password;
    private Long carId;
}