package com.routefinder.model;

import org.springframework.data.domain.Persistable;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by karpukdm on 26.03.16.
 */
@Entity
@Table(name = "point")
public class Point implements Persistable<Integer> {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "point_gen")
    @SequenceGenerator(name = "point_gen", sequenceName = "point_id_sec", allocationSize = 1)
    @Column(name = "id", unique = true, nullable = false)
    private Integer id;

    @Column(nullable = false)
    private String name;

    public Point(){
        super();
    }

    public Point(String name){
        super();
        this.name = name;
    }

    public Point(String name, Coordinates a){
        super();
        this.name = name;
        this.coordinates = a;
    }

    public void addRoute(Route route){
        if(routes == null){
            routes = new LinkedList<Route>();
        }
        routes.add(route);
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public boolean isNew() {
        return false;
    }

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Route> routes;

    public List<Route> getRoutes() {
        return routes;
    }

    public void setRoutes(List<Route> routes) {
        this.routes = routes;
    }

    @OneToOne(mappedBy = "point", cascade = CascadeType.ALL)
    private Coordinates coordinates;

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Neighbor> neighbors;

    public List<Neighbor> getNeighbors() {
        return neighbors;
    }

    public void setNeighbors(List<Neighbor> neighbors) {
        this.neighbors = neighbors;
    }

    public void addNeighbors(List<Neighbor> neighbors){
        if(this.neighbors == null){
            this.neighbors = new LinkedList<Neighbor>();
        }

        this.neighbors.addAll(neighbors);
    }
}
