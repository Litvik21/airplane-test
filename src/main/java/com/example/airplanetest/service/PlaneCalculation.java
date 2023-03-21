package com.example.airplanetest.service;

import com.example.airplanetest.model.AirplaneCharacteristics;
import com.example.airplanetest.model.TemporaryPoint;
import com.example.airplanetest.model.WayPoint;
import java.util.List;

public interface PlaneCalculation {
    List<TemporaryPoint> calculateRoute(AirplaneCharacteristics characteristics,
                                        List<WayPoint> wayPoints);
}
