package com.routefinder.model;

import org.springframework.data.domain.Persistable;

import javax.persistence.*;
import java.util.List;

/**
 * Created by karpukdm on 26.03.16.
 */
@Entity
@Table(name = "route")
public class Route implements Persistable<Integer> {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "route_gen")
    @SequenceGenerator(name = "route_gen", sequenceName = "route_id_sec", allocationSize = 1)
    @Column(name = "id", unique = true, nullable = false)
    private Integer id;

    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(name="route_point",
            joinColumns = @JoinColumn(name="route_id", referencedColumnName="id"),
            inverseJoinColumns = @JoinColumn(name="point_id", referencedColumnName="id")
    )
    private List<Point> points;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "route", fetch = FetchType.LAZY)
    private List<Comment> comments;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "route", fetch = FetchType.LAZY)
    private List<Rating> ratings;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "route", fetch = FetchType.LAZY)
    private List<Statistics> statistics;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "route", fetch = FetchType.LAZY)
    private List<Schedule> schedules;

    @Column(nullable = false)
    private Double distance;

    @Column
    private String info;

    public Route(){
        super();
    }

    public Route(Double distance){
        super();
        this.distance = distance;
    }

    public List<Statistics> getStatistics() {
        return statistics;
    }

    public void setStatistics(List<Statistics> statistics) {
        this.statistics = statistics;
    }

    public List<Schedule> getSchedules() {
        return schedules;
    }

    public void setSchedules(List<Schedule> schedules) {
        this.schedules = schedules;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getDistance() {
        return distance;
    }

    public void setDistance(Double distance) {
        this.distance = distance;
    }

    public List<Point> getPoints() {
        return points;
    }

    public void setPoints(List<Point> points) {
        this.points = points;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public List<Rating> getRatings() {
        return ratings;
    }

    public void setRatings(List<Rating> ratings) {
        this.ratings = ratings;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public Integer getId() {
        return null;
    }

    public boolean isNew() {
        return false;
    }
}
