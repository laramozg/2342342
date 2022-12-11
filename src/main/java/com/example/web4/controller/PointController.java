package com.example.web4.controller;


import com.example.web4.model.Point;
import com.example.web4.model.PointRequest;
import com.example.web4.service.PointService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/table")
public class PointController {
    private final PointService pointService;

    @GetMapping
    public ResponseEntity<?> getPoints() {
        return pointService.getPoints();
    }

    @PostMapping
    public ResponseEntity<?> addPoint(@RequestBody PointRequest pointDTO) {
        return pointService.addPoint(pointDTO);
    }

    @DeleteMapping
    public ResponseEntity<?> deleteFromDB() {
        return pointService.deletePoints();
    }
}
