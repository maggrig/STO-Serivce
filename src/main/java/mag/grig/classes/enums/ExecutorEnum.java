/*
 * Copyright (c) 2022. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package mag.grig.classes.enums;

public enum ExecutorEnum {
        MECHANIC(0),//Механик
        ELECTRIC(1),//Электрик
        BREAKDOWN(2),// Развал
        CARWASH(3); //Мойка
        private  int value;
    ExecutorEnum(int value) {
            this.value = value;
        }
    }
