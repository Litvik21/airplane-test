package com.example.airplanetest.service.impl;

import com.example.airplanetest.model.TemporaryPoint;
import com.example.airplanetest.service.PrintInfoService;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class PrintInfoServiceImpl implements PrintInfoService {
    @Override
    public void printTemporaryPoints(List<TemporaryPoint> points) {
        for (int i = 0; i < points.size(); i++) {
            System.out.print(points.get(i) + " ");
            if ((i + 1) % 5 == 0) {
                System.out.println();
            }
        }
    }

    @Override
    public void printElapsedTime(int size, int timeBetweenPoints) {
        System.out.println("time: " + size / timeBetweenPoints);
    }
}
