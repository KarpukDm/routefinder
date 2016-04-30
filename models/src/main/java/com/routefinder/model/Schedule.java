package com.routefinder.model;

import org.springframework.data.domain.Persistable;

import javax.persistence.*;

/**
 * Created by karpukdm on 26.03.16.
 */
@Entity
@Table(name = "schedule")
public class Schedule implements Persistable<Integer> {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "schedule_gen")
    @SequenceGenerator(name = "schedule_gen", sequenceName = "schedule_id_sec", allocationSize = 1)
    @Column(name = "id", unique = true, nullable = false)
    private Integer id;

    @Column(nullable = false)
    private String day;

    @Column(nullable = false)
    private String departureTime;

    @Column(nullable = false)
    private String arrivalTime;

    public Schedule(){
        super();
    }

    public Schedule(String day, String departureTime, String arrivalTime){
        super();
        this.day = day;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    public String getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(String arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public Integer getId() {
        return id;
    }

    public boolean isNew() {
        return false;
    }

}
