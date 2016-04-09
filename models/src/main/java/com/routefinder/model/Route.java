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

    @Column
    private String dataJson;

    public Route(){
        super();
    }

    public Route(Double distance){
        super();
        this.distance = distance;
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

    public void setInfo(String info) {
        this.info = info;
    }

    public Integer getId() {
        return null;
    }

    public boolean isNew() {
        return false;
    }

    @Column
    private String mapData;

    public String getMapData() {
        return mapData;
    }

    public void setMapData(String mapData) {
        this.mapData = mapData;
    }

    @OneToMany(mappedBy = "route",cascade=CascadeType.ALL)
    private List<Rating> ratings;

    public List<Rating> getRatings() {
        return ratings;
    }

    public void setRatings(List<Rating> ratings) {
        this.ratings = ratings;
    }

    @OneToMany(mappedBy = "route",cascade=CascadeType.ALL)
    private List<Comment> comments;

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    @ManyToMany(cascade=CascadeType.ALL)
    private List<Point> points;

    public List<Point> getPoints() {
        return points;
    }

    public void setPoints(List<Point> points) {
        this.points = points;
    }

    @OneToMany(mappedBy = "route",cascade=CascadeType.ALL)
    private List<Schedule> shcedules;

    public List<Schedule> getShcedules() {
        return shcedules;
    }

    public void setShcedules(List<Schedule> shcedules) {
        this.shcedules = shcedules;
    }

    @OneToMany(mappedBy = "route",cascade=CascadeType.ALL)
    private List<Statistics> statistics;

    public List<Statistics> getStatistics() {
        return statistics;
    }

    public void setStatistics(List<Statistics> statistics) {
        this.statistics = statistics;
    }

    @OneToOne(cascade=CascadeType.ALL)
    private MyRoute myRoute;

    public MyRoute getMyRoute() {
        return myRoute;
    }

    public void setMyRoute(MyRoute myRoute) {
        this.myRoute = myRoute;
    }

    public String getDataJson() {
        return dataJson;
    }

    public void setDataJson(String dataJson) {
        this.dataJson = dataJson;
    }
}
