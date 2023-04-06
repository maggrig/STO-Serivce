package mag.grig.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;


@Entity
@Data
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @NotEmpty(message = "Name should not be empty")
    @Size(min = 4, max = 30, message = "Name should be between 4 and 30 characters")
    @Column(nullable = false)
    private String name;

    @NotEmpty(message = "Email should not be empty")
    @Email
    @Column(name = "email", nullable = false, unique = true)
    private String email;

    //    @Column(nullable=false)
    private String password;

    private Long car_id;

}
