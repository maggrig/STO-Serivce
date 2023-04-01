/*
 * Copyright (c) 2022. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package mag.grig.classes.enums;

public enum StatusEnum {
    READY(0), // готов к выполнению работ
    WAIT(1), // в ожидании
    COORDINATION(2), // в согласование
    PAUSE(2); // пауза
    private  int value;

    StatusEnum(int value) {
        this.value = value;
    }


}
