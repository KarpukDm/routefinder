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

    @Column(nullable = false)
    private String name;

    public Point(){
        super();
    }

    public Point(String name){
        super();
        this.name = name;
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
        return null;
    }

    public boolean isNew() {
        return false;
    }

    @OneToOne(mappedBy = "point",cascade=CascadeType.ALL)
    private Coordinates coordinates;

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    @OneToMany(mappedBy = "point",cascade=CascadeType.ALL)
    private List<Neighbor> neighbor;

    public List<Neighbor> getNeighbor() {
        return neighbor;
    }

    public void setNeighbor(List<Neighbor> neighbor) {
        this.neighbor = neighbor;
    }

    @ManyToMany(cascade=CascadeType.ALL)
    private List<Route> routes;

    public List<Route> getRoutes() {
        return routes;
    }

    public void setRoutes(List<Route> routes) {
        this.routes = routes;
    }
}
