package mag.grig.dto;

import lombok.Data;
import mag.grig.entity.Order;

/**
 * A DTO for the {@link Order} entity
 */
@Data
public class OrderDTO {
    private Long id;
    private Long carId;
    private Long postId;
    private Long clientId;
    private Long acceptorId;
    private Long executorId;
    private String startDate;
    private String endDate;
    private boolean finished;
    private boolean warning;
    private boolean error;

    // геттеры и сеттеры для всех полей
}
