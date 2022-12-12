package com.example.web4.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Getter
@Setter
@AllArgsConstructor
public class PointRequest {
    @Max(4)
    @Min(-4)
    private double x;
    @Max(3)
    @Min(-3)
    private double y;
    @Max(4)
    @Min(1)
    private double r;
}