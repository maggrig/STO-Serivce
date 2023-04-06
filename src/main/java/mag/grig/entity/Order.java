package mag.grig.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

/**
 * Order. - Заказ
 */
@Entity
@Data
@Table(name = "Orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private Long client_Id;
    private Long VIN_Id;//VIN ID машины
    private Date start_Date;
    private Date end_Date;
    private Long acceptor_Id;//-user_id Приёмщик
    private Long executor_Id;// -user_id Исполнитель работ

}
