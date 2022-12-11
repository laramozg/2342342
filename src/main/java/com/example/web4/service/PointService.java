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
import java.util.List;

@Service
@RequiredArgsConstructor
public class PointService {
    private final PointRepository pointRepository;
    private final CheckArea checkArea;

    public ResponseEntity<?> getPoints(){
        return new ResponseEntity<>(pointRepository.getPointByUser(SecurityContextHolder.getContext().getAuthentication().getName()),HttpStatus.OK);
    }

    public ResponseEntity<?> addPoint(PointRequest pointDTO) {
        Point point = Point.builder()
                .x(pointDTO.getX())
                .y(pointDTO.getY())
                .r(pointDTO.getR())
                .result(checkArea.isHit(pointDTO))
                .time(LocalDateTime.now())
                .user(SecurityContextHolder.getContext().getAuthentication().getName())
                .build();
//        point.setUser(SecurityContextHolder.getContext().getAuthentication().getName());
        System.out.println(point.getResult());
        pointRepository.save(point);
        return new ResponseEntity<>(point, HttpStatus.OK);
    }
    public ResponseEntity<?> deletePoints() {
        pointRepository.deleteAllByUser(SecurityContextHolder.getContext().getAuthentication().getName());
        return new ResponseEntity<>(HttpStatus.OK);
    }




}
