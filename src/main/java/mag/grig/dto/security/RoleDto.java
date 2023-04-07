package mag.grig.dto.security;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RoleDto {
    private Long id;
    @NotEmpty(message = "Role should not be empty")
    private String role;

//    public List<Role> findAll() {
//        return null;
//    }
}
