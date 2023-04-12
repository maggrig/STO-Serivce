package mag.grig.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

/**
 * A DTO for the {@link mag.grig.entity.Client} entity
 */
@Data
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