package mag.grig.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;

import java.util.Objects;

/**
 * Запчасти.
 */
@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Table(name = "Auto_Parts")
public class AutoParts {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private String name;
    private String description;
    @ManyToOne
    @JoinColumn(name = "car_id")
    private Car car; //ссылка на car (entity/Car) (многие к одному)

    /**
     * VIN машины
     */
    private Long carVINId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        AutoParts autoParts = (AutoParts) o;
        return getId() != null && Objects.equals(getId(), autoParts.getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
