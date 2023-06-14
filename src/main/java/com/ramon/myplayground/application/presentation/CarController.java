package com.ramon.myplayground.application.presentation;

import com.ramon.myplayground.application.dtos.CarRequest;
import com.ramon.myplayground.application.mappers.CarMapper;
import com.ramon.myplayground.application.services.CarService;
import com.ramon.myplayground.domain.models.Car;
import com.ramon.myplayground.domain.models.CarEntity;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class CarController {

    private final CarService carService;

    @PostMapping("/car")
    public ResponseEntity<Car> saveCar(@RequestBody @Valid CarRequest carRequest) {
        CarEntity carEntity = carService.save(carRequest);
        Car newCar = CarMapper.fromCarEntity(carEntity);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(newCar);
    }

    @GetMapping("/car")
    public ResponseEntity<List<Car>> getAllCars() {
        List<Car> carList = carService.findAll().stream()
                .map(CarMapper::fromCarEntity)
                .collect(Collectors.toList());
        return ResponseEntity.ok(carList);
    }

    @GetMapping("/car/{id}")
    public ResponseEntity<Car> getOneCar(@PathVariable(value = "id") UUID id) {
        CarEntity carEntity = carService.findById(id);
        return ResponseEntity.ok(CarMapper.fromCarEntity(carEntity));
    }

    @PutMapping("/car/{id}")
    public ResponseEntity<Car> updateCar(@PathVariable(value = "id") UUID id,
                                               @RequestBody @Valid CarRequest carRequest) {
        CarEntity carEntity = carService.update(id, carRequest);
        return ResponseEntity.ok(CarMapper.fromCarEntity(carEntity));
    }

    @DeleteMapping("/car/{id}")
    public ResponseEntity<String> deleteCar(@PathVariable(value = "id")UUID id) {
        carService.delete(id);
        return ResponseEntity.ok("Product deleted successfully!");
    }
}
