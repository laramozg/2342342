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
//@NamedQuery(name = "points.findByUser", query = "from points where user = :user order by id asc")
public class Point {
    @Id
    @Column(nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Max(5)
    @Min(-5)
    @Column(nullable = false)
    private double x;
    @Max(5)
    @Min(-3)
    @Column(nullable = false)
    private double y;
    @Max(5)
    @Min(1)
    @Column(nullable = false)
    private double r;
    @Column(nullable = false)
    private boolean hit;
    @Column(nullable = false)
    private LocalDateTime time;
    @Column(nullable = false)
    private String user;

//    public LocalDateTime getCurrenttime() {
//        return currenttime;
//    }
//public boolean getResult(){
//        return result;
}
//    @ManyToOne
//    @OnDelete(action = OnDeleteAction.CASCADE)
//    @JoinColumn(name = "user_id", nullable = false)
//    private User user;
