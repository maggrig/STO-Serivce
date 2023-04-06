package mag.grig.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "Auto_Parts")
public class AutoParts {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private String name;
    private String description;
    private Long car_VIN_Id;


}
