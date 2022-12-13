package com.example.web4.service;


import com.example.web4.model.PointRequest;
import org.springframework.stereotype.Service;

import static java.lang.Math.pow;

@Service
public class CheckArea {
    public boolean isHit(PointRequest point) {
        return isRectangleHit(point) || isCircleHit(point) || isTriangleHit(point);
    }

    private boolean isRectangleHit(PointRequest point) {
        return point.getX() >= 0 && point.getX() <= point.getR() / 2
                && point.getY() <= 0 && point.getY() >= -point.getR();
    }

    private boolean isCircleHit(PointRequest point) {
        return point.getX() <= 0 && point.getY() >= 0
                && (pow(point.getX(), 2) + pow(point.getY(), 2)) <= pow(point.getR(), 2);
    }

    private boolean isTriangleHit(PointRequest point) {
        return point.getX() >= 0 && point.getY() >= 0
                && point.getY() <= -point.getX() + point.getR();
    }
}
