package com.routefinder.model;

import org.springframework.data.domain.Persistable;

import javax.persistence.*;

/**
 * Created by karpukdm on 26.03.16.
 */
@Entity
@Table(name = "my_route")
public class MyRoute implements Persistable<Integer> {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "my_route_gen")
    @SequenceGenerator(name = "my_route_gen", sequenceName = "my_route_id_sec", allocationSize = 1)
    @Column(name = "id", unique = true, nullable = false)
    private Integer id;

    public MyRoute(){
        super();
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public boolean isNew() {
        return false;
    }

    @OneToOne(cascade = CascadeType.ALL)
    private Route route;

    public Route getRoute() {
        return route;
    }

    public void setRoute(Route route) {
        this.route = route;
    }
}
