package com.example.airplanetest.service.generate;

import com.example.airplanetest.model.AirplaneCharacteristics;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class AirplaneCharacteristicsGetting {
    public List<AirplaneCharacteristics> getAirplaneCharacteristics() {
        AirplaneCharacteristics characteristics1 = new AirplaneCharacteristics();
        characteristics1.setMaxSpeed(10D);
        characteristics1.setMaxAcceleration(5D);
        characteristics1.setVerticalSpeed(9D);
        characteristics1.setChangeTrajectorySpeed(8D);

        AirplaneCharacteristics characteristics2 = new AirplaneCharacteristics();
        characteristics2.setMaxSpeed(12D);
        characteristics2.setMaxAcceleration(4D);
        characteristics2.setVerticalSpeed(9D);
        characteristics2.setChangeTrajectorySpeed(6D);

        AirplaneCharacteristics characteristics3 = new AirplaneCharacteristics();
        characteristics3.setMaxSpeed(20D);
        characteristics3.setMaxAcceleration(5D);
        characteristics3.setVerticalSpeed(10D);
        characteristics3.setChangeTrajectorySpeed(12D);
        return List.of(characteristics1, characteristics2, characteristics3);
    }
}
