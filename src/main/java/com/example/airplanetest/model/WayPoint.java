package com.example.airplanetest.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class WayPoint {
    private Double latitude;
    private Double longitude;
    private Double spanHeight;
    private Double speed;
}
