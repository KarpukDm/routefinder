package com.routefinder.model;

import org.springframework.data.domain.Persistable;

import javax.persistence.*;

/**
 * Created by karpukdm on 26.03.16.
 */
@Entity
@Table(name = "statistics")
public class Statistics implements Persistable<Integer> {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "statistics_gen")
    @SequenceGenerator(name = "statistics_gen", sequenceName = "statistics_id_sec", allocationSize = 1)
    @Column(name = "id", unique = true, nullable = false)
    private Integer id;

    @Column(nullable = false)
    private Integer counter;

    @Column(nullable = false)
    private String month;

    public Statistics(){
        super();
    }

    public Statistics(Integer counter, String month){
        super();
        this.counter = counter;
        this.month = month;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCounter() {
        return counter;
    }

    public void setCounter(Integer counter) {
        this.counter = counter;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public Integer getId() {
        return null;
    }

    public boolean isNew() {
        return false;
    }

}
