package com.example.web4.service;

import com.example.web4.exceptions.InvalidParameterException;
import com.example.web4.model.PointRequest;
import org.springframework.stereotype.Service;

@Service
public class Validate {
    public void validatePoint(PointRequest point) {
        if ((point.getY() > 3 || point.getY() < -3)) {
            throw new InvalidParameterException("Значение Y не попадает в нужный интервал!");
        }
        if ((point.getX() > 4 || point.getX() < -4)) {
            throw new InvalidParameterException("Значение X не попадает в нужный интервал!");
        }
        if (point.getR() > 5 || point.getR() < 1) {
            throw new InvalidParameterException("Значение R не попадает в нужный интервал!");
        }
    }
}
