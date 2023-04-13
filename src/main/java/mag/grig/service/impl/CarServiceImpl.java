package mag.grig.service.impl;

import mag.grig.entity.Car;
import mag.grig.repository.CarRepository;
import mag.grig.service.CarService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CarServiceImpl implements CarService {
    private final CarRepository carRepository;

    public CarServiceImpl(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    /**
     * @param car
     */
    @Override
    public void saveCar(String car) {

    }

    /**
     * @param car
     */
    @Override
    public void saveCar(Car car) {
        carRepository.save(car);
    }

    /**
     * @param id
     * @return
     */
    @Override
    public Car getCarById(Long id) {
        return carRepository.findById(id).orElse(null);
    }

    /**
     * @param id
     * @return
     */
    @Override
    public Optional<Car> findCarById(Long id) {
        return carRepository.findById(id);
    }

    public Optional<Car> findById(Long Id) {
        return carRepository.findById(Id);
    }

}
