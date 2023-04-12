package mag.grig.service;

import mag.grig.entity.Car;

public interface CarService {

    void saveCar(String car);

    void saveCar(Car car);
//    Car findById(Car Id);

}
