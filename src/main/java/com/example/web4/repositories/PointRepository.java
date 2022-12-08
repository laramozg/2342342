package com.example.web4.repositories;


import com.example.web4.model.Point;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PointRepository extends JpaRepository<Point,Long> {
    List<Point> getResultsByUser(String ownerUsername);
    void deleteAllByUser(String ownerUsername);
}
