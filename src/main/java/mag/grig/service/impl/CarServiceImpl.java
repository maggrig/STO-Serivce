package mag.grig.service.impl;

import mag.grig.entity.Car;
import mag.grig.entity.dto.CarDTO;
import mag.grig.entity.repository.CarRepository;
import mag.grig.entity.repository.ClientRepository;
import mag.grig.service.CarService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

@Service
public class CarServiceImpl implements CarService {
    private final CarRepository carRepository;
    private final ClientRepository clientRepository;

    public CarServiceImpl(CarRepository carRepository,
                          ClientRepository clientRepository) {
        this.carRepository = carRepository;
        this.clientRepository = clientRepository;
    }

    /**
     * @param carDTO
     */
    @Override
    public void saveCar(CarDTO carDTO) {
        Car car = new Car();
        car.setCarVINId(carDTO.getCarVINId());
        car.setName(carDTO.getName());
        car.setBrand(carDTO.getBrand());
        car.setNumber(carDTO.getNumber());
        car.setClient(clientRepository.findById(carDTO.getClient()).orElse(null));
        DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
        LocalDateTime birthDate = LocalDateTime.parse(carDTO.getBirthday(), formatter);
        Date birth_Date = Date.from(birthDate.atZone(ZoneId.systemDefault()).toInstant());
        car.setBirthday(birth_Date);
        carRepository.save(car);
    }

    /**
     * @param id
     */
    @Override
    public void deleteById(Long id) {
        carRepository.deleteById(id);
    }

    /**
     * @return
     */
    @Override
    public List<Car> findAll() {
        return carRepository.findAll();
    }

    public Car findById(Long Id) {
        return carRepository.findById(Id).orElse(null);
    }

}
