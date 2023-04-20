package mag.grig.service;

import mag.grig.entity.Car;
import mag.grig.entity.dto.CarDTO;

import java.util.List;

public interface CarService {

    void saveCar(CarDTO carDTO);

    void deleteById(Long id);

    List<Car> findAll();

    Car findById(Long id);
//    Car findById(Car Id);

}
