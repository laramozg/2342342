package com.example.web4.repositories;


import com.example.web4.model.Point;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PointRepository extends CrudRepository<Point,Long> {
    List<Point> getPointByUser(String user);
    void deleteAllByUser(String user);
}
