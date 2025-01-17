package com.ramon.myplayground.car.model;

import com.ramon.myplayground.car.dto.Fuel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Entity
@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tb_engine")
public class EngineEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String description;
    private String transmission;
    private Integer horsePower;
    private Double kilometers;
    @Enumerated(EnumType.STRING)
    private List<Fuel> fuel;
}
