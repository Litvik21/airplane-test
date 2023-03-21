package com.example.airplanetest.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class AirplaneCharacteristics {
    private Double maxSpeed;
    private Double maxAcceleration;
    private Double verticalSpeed;
    private Double changeTrajectorySpeed;
}
