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

    @Column(nullable = false)
    private Double distance;

    @Column
    private String info;

    @Column(nullable = false)
    private Integer counter;

    @Column(nullable = false)
    private Double price;

    public Route(){
        super();
    }

    public Route(Double distance){
        super();
        this.distance = distance;
    }

    public String getRating(){
        int x = 0;
        for(Rating rating : ratings){
            x += rating.getValue();
        }

        return String.valueOf(x);
    }

    public void addComment(Comment comment){
        comments.add(comment);
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

    public String getInfo() {
        return info;
    }

    public String getShortInfo() {

        if(info.length() > 255){
            return info.substring(0, 255);
        }

        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public Integer getId() {
        return id;
    }

    public boolean isNew() {
        return false;
    }

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Rating> ratings;

    public List<Rating> getRatings() {
        return ratings;
    }

    public void setRatings(List<Rating> ratings) {
        this.ratings = ratings;
    }

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Comment> comments;

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    @OneToMany(cascade = CascadeType.ALL)
    private List<Statistics> statistics;

    public List<Statistics> getStatistics() {
        return statistics;
    }

    public void setStatistics(List<Statistics> statistics) {
        this.statistics = statistics;
    }

    @ManyToMany(cascade = CascadeType.ALL)
    private List<Point> points;

    public List<Point> getPoints() {
        return points;
    }

    public void setPoints(List<Point> points) {
        this.points = points;
    }

    public Integer getCounter() {
        return counter;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setCounter(Integer counter) {
        this.counter = counter;
    }

    @OneToMany(cascade = CascadeType.ALL)
    private List<Schedule> schedules;

    public List<Schedule> getSchedules() {
        return schedules;
    }

    public void setSchedules(List<Schedule> schedules) {
        this.schedules = schedules;
    }


    @OneToOne(cascade = CascadeType.ALL)
    private RouteConfig routeConfig;

    public RouteConfig getRouteConfig() {
        return routeConfig;
    }

    public void setRouteConfig(RouteConfig routeConfig) {
        this.routeConfig = routeConfig;
    }
}
