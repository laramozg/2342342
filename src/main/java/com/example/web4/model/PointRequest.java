package com.example.web4.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class PointRequest {
    private double x;
    private double y;
    private double r;
}