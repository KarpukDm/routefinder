package com.routefinder.model;

import org.springframework.data.domain.Persistable;

import javax.persistence.*;
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

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "point")
    private List<Neighbor> neighbors;

    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "points")
    private List<Route> routes;

    @OneToOne(optional = false)
    @JoinColumn(name="coordinates_id", unique = true, nullable = false, updatable = false)
    private Coordinates coordinates;

    @Column
    private String name;

    public Point(){
        super();
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

    public List<Neighbor> getNeighbors() {
        return neighbors;
    }

    public void setNeighbors(List<Neighbor> neighbors) {
        this.neighbors = neighbors;
    }

    public List<Route> getRoutes() {
        return routes;
    }

    public void setRoutes(List<Route> routes) {
        this.routes = routes;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public Integer getId() {
        return null;
    }

    public boolean isNew() {
        return false;
    }
}
