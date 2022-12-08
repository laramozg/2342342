package com.example.web4.service;


import com.example.web4.model.PointDTO;
import org.springframework.stereotype.Service;

import static java.lang.Math.pow;

@Service
public class CheckArea {
    public boolean isHit(PointDTO point) {
        return isRectangleHit(point) || isCircleHit(point) || isTriangleHit(point);
    }

    private boolean isRectangleHit(PointDTO point) {
        return point.getX() >= 0 && point.getX() <= point.getR()
                && point.getY() <= 0 && point.getY() >= -point.getR();
    }

    private boolean isCircleHit(PointDTO point) {
        return point.getX() >= 0 && point.getY() >= 0
                && (pow(point.getX() /2, 2) + pow(point.getY() /2 , 2)) <= pow(point.getR() / 4, 2);
    }

    private boolean isTriangleHit(PointDTO point) {
        return point.getX() <= 0 && point.getY() <= 0
                && point.getX() <= point.getR() && point.getY()>= -point.getR() /2 ;
    }
}
