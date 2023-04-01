package mag.grig.entity;

import jakarta.persistence.*;
import lombok.Data;



@Entity
@Data
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    String name;

}
