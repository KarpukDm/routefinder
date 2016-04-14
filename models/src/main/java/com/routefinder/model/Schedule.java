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
    private String time;

    public Schedule(){
        super();
    }

    public Schedule(String day, String time){
        super();
        this.day = day;
        this.time = time;
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

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Integer getId() {
        return id;
    }

    public boolean isNew() {
        return false;
    }

}
