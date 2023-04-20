package mag.grig.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;
import org.springframework.transaction.annotation.Transactional;

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
@Transactional
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private Long car; //ссылка на car (entity/Car) (многие к одному)
    private Long post; //ссылка на post (entity/Post) (многие к одному)
    private Long client; //ссылка на client(entity/Client) (многие к одному)
    private Long acceptor;//-ссылка на (entity/security/User) Приёмщик (многие к одному)
    private Long executor;// ссылка на (entity/security/User) Исполнитель работ (многие к одному)

    @Temporal(TemporalType.DATE)
    private Date startDate;
    @Temporal(TemporalType.DATE)
    private Date endDate;

    private boolean finished;
    private boolean warning;
    private boolean error;


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
