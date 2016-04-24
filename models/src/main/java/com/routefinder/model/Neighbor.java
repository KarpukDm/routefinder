package com.routefinder.model;

import org.springframework.data.domain.Persistable;

import javax.persistence.*;

/**
 * Created by karpukdm on 26.03.16.
 */
@Entity
@Table(name = "neighbor")
public class Neighbor implements Persistable<Integer> {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "neighbor_gen")
    @SequenceGenerator(name = "neighbor_gen", sequenceName = "neighbor_id_sec", allocationSize = 1)
    @Column(name = "id", unique = true, nullable = false)
    private Integer id;

    @Column(nullable = false)
    private Double distance;

    public Neighbor(){
        super();
    }

    public Neighbor(Point point, Double distance){
        super();
        this.distance = distance;
        this.point = point;
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

    public Integer getId() {
        return id;
    }

    public boolean isNew() {
        return false;
    }

    @ManyToOne(cascade = CascadeType.ALL)
    private Point point;

    public Point getPoint() {
        return point;
    }

    public void setPoint(Point point) {
        this.point = point;
    }
}
