package mag.grig.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import mag.grig.entity.security.User;
import org.hibernate.Hibernate;

import java.util.Date;
import java.util.Objects;

/**
 * Order. - Заказы
 */
@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Table(name = "Orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "car_id")
    private Car car; //ссылка на car (entity/Car) (многие к одному)
    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post; //ссылка на post (entity/Post) (многие к одному)
    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client; //ссылка на client(entity/Client) (многие к одному)
    @ManyToOne
    @JoinColumn(name = "acceptor_id")
    private User acceptor;//-ссылка на (entity/security/User) Приёмщик (многие к одному)
    @ManyToOne
    @JoinColumn(name = "executor_id")
    private User executor;// ссылка на (entity/security/User) Исполнитель работ (многие к одному)

    @Temporal(TemporalType.DATE)
    private Date startDate;
    @Temporal(TemporalType.DATE)
    private Date endDate;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Order order = (Order) o;
        return getId() != null && Objects.equals(getId(), order.getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
