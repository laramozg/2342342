package com.example.web4.repositories;

import com.example.web4.model.Point;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PointRepository extends CrudRepository<Point,Integer> {
    List<Point> getPointByOwner(String users);
    void deleteAllByOwner(String users);
}
