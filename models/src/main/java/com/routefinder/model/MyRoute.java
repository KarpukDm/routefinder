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

    @Column(nullable = false)
    private Integer route_id;

    public MyRoute(){
        super();
    }
    
    public MyRoute(Integer route_id){
        super();
        this.route_id = route_id;
    }

    public Integer getRoute_id() {
        return route_id;
    }

    public void setRoute_id(Integer route_id) {
        this.route_id = route_id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return null;
    }

    public boolean isNew() {
        return false;
    }

}
