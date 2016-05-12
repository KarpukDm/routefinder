package com.routefinder.model;

import org.springframework.data.domain.Persistable;

import javax.persistence.*;

/**
 * Created by offsp on 12.05.2016.
 */
@Entity
@Table(name = "point_info")
public class PointInfo implements Persistable<Integer> {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "point_gen")
    @SequenceGenerator(name = "point_gen", sequenceName = "point_id_sec", allocationSize = 1)
    @Column(name = "id", unique = true, nullable = false)
    private Integer id;

    @Column(nullable = false)
    private String averageTemperature;

    @Column(nullable = false)
    private String leisure;

    @Column(nullable = false)
    private String region;

    public Integer getId() {
        return id;
    }

    public boolean isNew() {
        return false;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAverageTemperature() {
        return averageTemperature;
    }

    public void setAverageTemperature(String averageTemperature) {
        this.averageTemperature = averageTemperature;
    }

    public String getLeisure() {
        return leisure;
    }

    public void setLeisure(String leisure) {
        this.leisure = leisure;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }
}
