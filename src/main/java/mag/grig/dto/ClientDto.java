package mag.grig.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.io.Serializable;

/**
 * A DTO for the {@link mag.grig.entity.Client} entity
 */
@Data
public class ClientDto implements Serializable {
    private static final long serialVersionUID = -9155561912709595408L;
    private final Long id;
    @NotNull(message = "Name should not be empty")
    @Size(min = 4, max = 30, message = "Name should be between 4 and 30 characters")
    private final String name;
    @NotNull(message = "Email should not be empty")
    @Email
    private final String email;
    private final String password;
    private final Long carId;
}