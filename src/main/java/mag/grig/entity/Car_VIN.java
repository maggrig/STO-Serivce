package mag.grig.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "Car_VIN")
public class Car_VIN {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private String VIN;
    private Long client_Id;
}
