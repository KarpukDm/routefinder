package com.routefinder.model;

import org.springframework.data.domain.Persistable;

import javax.persistence.*;
import java.util.List;

/**
 * Created by karpukdm on 26.03.16.
 */
@Entity
@Table(name = "way_point")
public class WayPoint implements Persistable<Integer> {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "way_point_gen")
    @SequenceGenerator(name = "way_point_gen", sequenceName = "way_point_id_sec", allocationSize = 1)
    @Column(name = "id", unique = true, nullable = false)
    private Integer id;

    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "wayPoints")
    private List<Route> routes;

    public WayPoint(){
        super();
    }

    public List<Route> getRoutes() {
        return routes;
    }

    public void setRoutes(List<Route> routes) {
        this.routes = routes;
    }

    public Integer getId() {
        return null;
    }

    public boolean isNew() {
        return false;
    }
}
