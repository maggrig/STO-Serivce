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

    public Optional<Car> findById(Long Id) {
        return (Optional<Car>) carRepository.findById(Id);
    }

}
