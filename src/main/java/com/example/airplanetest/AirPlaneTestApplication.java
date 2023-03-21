package com.example.airplanetest;

import com.example.airplanetest.service.FlightScheduler;
import com.example.airplanetest.service.generate.AirplaneCharacteristicsGetting;
import com.example.airplanetest.service.generate.WayPointsGetting;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AirPlaneTestApplication {
    private final FlightScheduler flightScheduler;
    private final AirplaneCharacteristicsGetting characteristicsGetting;
    private final WayPointsGetting pointsGetting;

    public AirPlaneTestApplication(FlightScheduler flightScheduler,
                                   AirplaneCharacteristicsGetting characteristicsGetting,
                                   WayPointsGetting pointsGetting) {
        this.flightScheduler = flightScheduler;
        this.characteristicsGetting = characteristicsGetting;
        this.pointsGetting = pointsGetting;
    }

    public static void main(String[] args) {
        SpringApplication.run(AirPlaneTestApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunnerBean() {
        return (args) -> {
            flightScheduler.startFlights(characteristicsGetting.getAirplaneCharacteristics(),
                    pointsGetting.getWayPoints());
        };
    }

}
