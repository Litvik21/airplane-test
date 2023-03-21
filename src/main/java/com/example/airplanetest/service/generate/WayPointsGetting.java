package com.example.airplanetest.service.generate;

import com.example.airplanetest.model.WayPoint;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class WayPointsGetting {
    public List<WayPoint> getWayPoints() {
        WayPoint point1 = new WayPoint();
        point1.setSpeed(60D);
        point1.setLatitude(80D);
        point1.setLongitude(100D);
        point1.setSpanHeight(150D);

        WayPoint point2 = new WayPoint();
        point2.setSpeed(70D);
        point2.setLatitude(90D);
        point2.setLongitude(110D);
        point2.setSpanHeight(160D);

        WayPoint point3 = new WayPoint();
        point3.setSpeed(80D);
        point3.setLatitude(100D);
        point3.setLongitude(120D);
        point3.setSpanHeight(170D);
        return List.of(point1, point2, point3);
    }
}
