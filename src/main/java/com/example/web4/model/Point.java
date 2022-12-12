package com.example.web4.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.time.LocalDateTime;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "points")
public class Point {
    @Id
    @GeneratedValue
    private Integer id;
    @Max(4)
    @Min(-4)
    private double x;
    @Max(3)
    @Min(-3)
    private double y;
    @Max(4)
    @Min(1)
    private double r;
    private boolean result;
    private LocalDateTime time;

    @JoinColumn
    private String owner;
}

