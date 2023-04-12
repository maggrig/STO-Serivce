package mag.grig.dto;

import lombok.Data;

/**
 * A DTO for the {@link mag.grig.entity.Post} entity
 */
@Data
public class PostDTO {
    private Long id;
    private Long userId;
    private String name;
//    private  boolean enabled;
}