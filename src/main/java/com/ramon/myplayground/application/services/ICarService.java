package com.ramon.myplayground.application.services;

import com.ramon.myplayground.application.presentation.dtos.CarRequest;
import com.ramon.myplayground.infrastructure.repositories.models.CarEntity;

import java.util.List;
import java.util.UUID;

public interface ICarService {

    CarEntity save(CarRequest carRequest);

    List<CarEntity> findAll();

    CarEntity findById(UUID id);

    CarEntity update(UUID id, CarRequest carRequest);

    void delete(UUID id);
}
