/*
 * Copyright (c) 2023. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package mag.grig.classes;

import lombok.extern.log4j.Log4j2;
import mag.grig.entity.Order;
import mag.grig.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

//@NoArgsConstructor
@Log4j2
public class OrderObject implements Runnable {
    private final KafkaProperties.Listener listener;
    Long ID;
    @Autowired
    OrderService orderService;
    private ScheduledExecutorService executorService;

    public OrderObject(ScheduledExecutorService executorService, KafkaProperties.Listener listener) {
        this.executorService = executorService;
        this.listener = listener;
    }

    public OrderObject() {
        log.info("create Order");
        listener = new KafkaProperties.Listener();
    }
//    private final Log logger;

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    /**
     * When an object implementing interface {@code Runnable} is used
     * to create a thread, starting the thread causes the object's
     * {@code run} method to be called in that separately executing
     * thread.
     * <p>
     * The general contract of the method {@code run} is that it may
     * take any action whatsoever.
     *
     * @see Thread#run()
     */
    @Override
    public void run() {

        Order order = orderService.getById(1L);
        OrderObject result = new OrderObject(executorService, listener);
        this.executorService.schedule(result, 0, TimeUnit.MINUTES);

    }
}
