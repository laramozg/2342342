package com.example.web4.service;

import com.example.web4.exceptions.InvalidParameterException;
import com.example.web4.model.PointRequest;
import org.springframework.stereotype.Service;

@Service
public class Validate {
    public void validatePoint(PointRequest point) {
        byte MAX_Y = 5;
        byte MIN_Y = -5;

        if (!(point.getY() > MIN_Y && point.getY() < MAX_Y)) {
            throw new InvalidParameterException("Значение Y не попадает в нужный интервал!");
        }

        if (point.getR() <= 0) {
            throw new InvalidParameterException("Значение R не может быть неположительным!");
        }
    }
}
