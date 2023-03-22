package com.example.airplanetest.service;

import com.example.airplanetest.model.TemporaryPoint;
import java.util.List;

public interface PrintInfoService {
    void printTemporaryPoints(List<TemporaryPoint> points);

    void printElapsedTime(int size, int timeBetweenPoints);
}
