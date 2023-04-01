/*
 * Copyright (c) 2022. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package mag.grig.classes.enums;

public enum ControlEnum {
    SUPERVISOR(0), //Супервайзер
    RECEIVER(1),//Приёмщик
    SHIFTSUPERVISOR(2),//Начальник смены
    CUSTOMER(3);//Заказчик (опция)
    private  int value;

    ControlEnum(int value) {
        this.value = value;
    }
}
