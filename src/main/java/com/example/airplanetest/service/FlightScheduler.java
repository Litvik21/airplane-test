package com.example.airplanetest.service;

import com.example.airplanetest.model.Airplane;
import com.example.airplanetest.model.AirplaneCharacteristics;
import com.example.airplanetest.model.Flight;
import com.example.airplanetest.model.TemporaryPoint;
import com.example.airplanetest.model.WayPoint;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.springframework.stereotype.Service;

@Service
public class FlightScheduler {
    private static final int TIME_INTERVAL = 1;
    private final AirplaneService service;
    private final PlaneCalculation planeCalculation;
    private final PrintInfoService printService;
    private final ExecutorService executor = Executors.newSingleThreadExecutor();

    public FlightScheduler(AirplaneService service, PlaneCalculation planeCalculation,
                           PrintInfoService printService) {
        this.service = service;
        this.planeCalculation = planeCalculation;
        this.printService = printService;
    }

    public void startFlights(List<AirplaneCharacteristics> characteristics,
                             List<WayPoint> wayPoints) {
        for (int i = 0; i < characteristics.size(); i++) {
            AirplaneCharacteristics characteristic = characteristics.get(i);

            FlightTask task = new FlightTask(characteristic, wayPoints);
            executor.execute(task);
        }
        executor.shutdown();
    }

    private class FlightTask implements Runnable {
        private final AirplaneCharacteristics characteristic;
        private final List<WayPoint> points;

        public FlightTask(AirplaneCharacteristics characteristic, List<WayPoint> points) {
            this.characteristic = characteristic;
            this.points = points;
        }

        @Override
        public void run() {
            List<TemporaryPoint> temporaryPoints =
                    planeCalculation.calculateRoute(characteristic, points);
            Flight flight = new Flight();
            flight.setNumber(Thread.currentThread().getId());
            flight.setWayPoints(points);
            flight.setPassedPoints(temporaryPoints);

            Airplane airplane = new Airplane();
            airplane.setAirplaneCharacteristics(characteristic);
            airplane.setFlights(List.of(flight));
            airplane.setPosition(temporaryPoints.get(temporaryPoints.size() - 1));

            service.save(airplane);
            printService.printTemporaryPoints(temporaryPoints);
            printService.printElapsedTime(temporaryPoints.size(), TIME_INTERVAL);
        }
    }
}
