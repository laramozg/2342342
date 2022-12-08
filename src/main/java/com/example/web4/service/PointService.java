package com.example.web4.service;


import com.example.web4.model.Point;
import com.example.web4.model.PointDTO;
import com.example.web4.repositories.PointRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PointService {
    private final PointRepository pointRepository;
    private final CheckArea checkArea;

    public List<Point> getPoints(){
        return pointRepository.getResultsByUser(SecurityContextHolder.getContext().getAuthentication().getName());
    }

    public Point addPoint(PointDTO pointDTO) {
        Point point = Point.builder()
                .x(pointDTO.getX())
                .y(pointDTO.getY())
                .r(pointDTO.getR())
                .hit(checkArea.isHit(pointDTO))
                .time(LocalDateTime.now())
                .build();
        point.setUser(SecurityContextHolder.getContext().getAuthentication().getName());
        pointRepository.save(point);
        return point;
    }
    public HttpStatus deletePoints() {
        pointRepository.deleteAllByUser(SecurityContextHolder.getContext().getAuthentication().getName());
        return HttpStatus.OK;
    }




}
