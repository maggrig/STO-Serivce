package mag.grig.service;

import mag.grig.entity.Car;

import java.util.Optional;

public interface CarService {

    void saveCar(String car);

    void saveCar(Car car);

    Car getCarById(Long id);

    Optional<Car> findCarById(Long id);
//    Car findById(Car Id);

}
