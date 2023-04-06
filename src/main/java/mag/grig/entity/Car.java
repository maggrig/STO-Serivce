/*
 * Copyright (c) 2022. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package mag.grig.entity;

import jakarta.persistence.*;
import lombok.Data;
import mag.grig.classes.interfaces.CarObject;

import java.util.Date;


@Entity
@Data
public class Car implements CarObject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private String name; // name of car
    private String number;// number of car
    private String brand;// brand of car
    private Date birthday;// birthday of car
    private Long car_VIN_Id; //VIN of car


}
