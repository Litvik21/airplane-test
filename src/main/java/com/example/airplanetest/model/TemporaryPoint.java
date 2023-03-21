package com.example.airplanetest.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class TemporaryPoint {
    private Double latitude;
    private Double longitude;
    private Double spanHeight;
    private Double speed;
    private Double courseDegrees;

    @Override
    public String toString() {
        return "TemporaryPoint{"
                + "latitude=" + latitude
                + ", longitude=" + longitude
                + ", spanHeight=" + spanHeight
                + ", speed=" + speed
                + ", courseDegrees=" + courseDegrees
                + '}';
    }
}
