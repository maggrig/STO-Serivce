/*
 * Copyright (c) 2023. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package mag.grig.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import mag.grig.entity.Order;

/**
 * A DTO for the {@link Order} entity
 */
@Data
@AllArgsConstructor
public class OrderDTO {
    private Long id;
    private String car;
    private String post;
    private String client;
    private String acceptor;
    private String executor;
    private String startDate;
    private String endDate;
    private boolean finished;
    private boolean warning;
    private boolean error;

    public OrderDTO() {
    }
    // геттеры и сеттеры для всех полей
}
