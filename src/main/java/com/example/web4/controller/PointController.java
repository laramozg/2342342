package com.example.web4.controller;


import com.example.web4.model.Point;
import com.example.web4.model.PointDTO;
import com.example.web4.service.PointService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class PointController {
    private final PointService pointService;

    @GetMapping
    public List<Point> getPoints() {
        return pointService.getPoints();
    }
    @PostMapping
    public Point addPoint(@RequestBody PointDTO pointDTO) {
        return pointService.addPoint(pointDTO);
    }
    @DeleteMapping
    public HttpStatus deleteFromDB() {
        return pointService.deletePoints();
    }
}
