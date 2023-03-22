package com.example.airplanetest.service.impl;

import com.example.airplanetest.model.AirplaneCharacteristics;
import com.example.airplanetest.model.TemporaryPoint;
import com.example.airplanetest.model.WayPoint;
import com.example.airplanetest.service.PlaneCalculation;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class PlaneCalculationImpl implements PlaneCalculation {
    private static final int TIME_INTERVAL = 1;

    @Override
    public List<TemporaryPoint> calculateRoute(AirplaneCharacteristics characteristics,
                                               List<WayPoint> wayPoints) {

        List<TemporaryPoint> points = new ArrayList<>();
        points.add(setStartingPosition());

        for (WayPoint nextPoint : wayPoints) {
            WayPoint startWayPoint = new WayPoint();
            startWayPoint.setLatitude(points.get(points.size() - 1).getLatitude());
            startWayPoint.setLongitude(points.get(points.size() - 1).getLongitude());
            startWayPoint.setSpeed(points.get(points.size() - 1).getSpeed());
            startWayPoint.setSpanHeight(points.get(points.size() - 1).getSpanHeight());

            double distance = calculateDistance(startWayPoint, nextPoint);
            int numPoints = (int) (distance / (characteristics.getMaxSpeed() * TIME_INTERVAL));

            for (int j = 0; j < numPoints; j++) {
                points.add(calculateNextPoint(points.get(j), characteristics));
            }
        }

        return points;
    }

    private TemporaryPoint calculateNextPoint(TemporaryPoint start,
                                              AirplaneCharacteristics characteristics) {
        double currentSpeed = start.getSpeed()
                + characteristics.getChangeTrajectorySpeed() * TIME_INTERVAL;
        double latitude = start.getLatitude()
                + (currentSpeed * Math.cos(start.getCourseDegrees()) * TIME_INTERVAL);
        double longitude = start.getLongitude()
                + (currentSpeed * Math.sin(start.getCourseDegrees() * TIME_INTERVAL))
                / Math.cos(latitude);
        double spanHeight = start.getSpanHeight()
                + characteristics.getVerticalSpeed() * TIME_INTERVAL;
        double courseDegrees = calculateCourseDegrees(start.getLatitude(),
                latitude, start.getLongitude(), longitude);
        TemporaryPoint nextPoint = new TemporaryPoint();
        nextPoint.setLatitude(latitude);
        nextPoint.setLongitude(longitude);
        nextPoint.setSpeed(currentSpeed);
        nextPoint.setSpanHeight(spanHeight);
        nextPoint.setCourseDegrees(courseDegrees);
        return nextPoint;
    }

    private double calculateCourseDegrees(double startLatitude, double endLatitude,
                                          double startLongitude, double endLongitude) {
        double longitudeDifference = (endLongitude - startLongitude) * (Math.PI / 180);
        return Math.atan2(Math.sin(longitudeDifference) * Math.cos(endLatitude),
                Math.cos(startLatitude) * Math.sin(endLatitude) - Math.sin(startLatitude)
                        * Math.cos(endLatitude) * Math.cos(longitudeDifference));
    }

    private double calculateDistance(WayPoint start, WayPoint end) {
        return Math.sqrt(Math.pow(end.getLatitude() - start.getLatitude(), 2)
                + Math.pow(end.getLongitude() - start.getLongitude(), 2)
                + Math.pow(end.getSpanHeight() - start.getSpanHeight(), 2));
    }

    private TemporaryPoint setStartingPosition() {
        TemporaryPoint startPoint = new TemporaryPoint();
        startPoint.setLatitude(0.0);
        startPoint.setLongitude(0.0);
        startPoint.setSpeed(0.0);
        startPoint.setSpanHeight(0.0);
        startPoint.setCourseDegrees(0.0);
        return startPoint;
    }
}
