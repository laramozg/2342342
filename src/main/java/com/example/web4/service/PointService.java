package com.example.web4.service;


import com.example.web4.model.Point;
import com.example.web4.model.PointRequest;
import com.example.web4.repositories.PointRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class PointService {
    private final PointRepository pointRepository;
    private final CheckArea checkArea;
    private final Validate validate;
    public ResponseEntity<?> getPoints(){
        return new ResponseEntity<>(pointRepository.getPointByOwner(SecurityContextHolder.getContext().getAuthentication().getName()),HttpStatus.OK);
    }

    public ResponseEntity<?> addPoint(PointRequest pointRequest) {
        validate.validatePoint(pointRequest);
        Point point = Point.builder()
                .x(pointRequest.getX())
                .y(pointRequest.getY())
                .r(pointRequest.getR())
                .result(checkArea.isHit(pointRequest))
                .time(LocalDateTime.now())
                .owner(SecurityContextHolder.getContext().getAuthentication().getName())
                .build();

        pointRepository.save(point);
        return new ResponseEntity<>(point, HttpStatus.OK);
    }
    public ResponseEntity<?> deletePoints() {
        pointRepository.deleteAllByOwner(SecurityContextHolder.getContext().getAuthentication().getName());
        return new ResponseEntity<>(HttpStatus.OK);
    }




}
