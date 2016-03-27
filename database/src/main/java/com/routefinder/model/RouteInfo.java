package com.routefinder.model;

import org.springframework.data.domain.Persistable;

import javax.persistence.*;
import java.util.List;

/**
 * Created by karpukdm on 26.03.16.
 */
@Entity
@Table(name = "route_info")
public class RouteInfo implements Persistable<Integer> {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "route_info_gen")
    @SequenceGenerator(name = "route_info_gen", sequenceName = "route_info_id_sec", allocationSize = 1)
    @Column(name = "id", unique = true, nullable = false)
    private Integer id;

    @OneToOne(optional = false, mappedBy="routeInfo")
    private Route route;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "routeInfo")
    private List<Statistics> statistics;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "routeInfo")
    private List<Schedule> schedules;

    public RouteInfo(){
        super();
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Route getRoute() {
        return route;
    }

    public void setRoute(Route route) {
        this.route = route;
    }

    public List<Statistics> getStatistics() {
        return statistics;
    }

    public void setStatistics(List<Statistics> statistics) {
        this.statistics = statistics;
    }

    public List<Schedule> getSchedules() {
        return schedules;
    }

    public void setSchedules(List<Schedule> schedules) {
        this.schedules = schedules;
    }

    public Integer getId() {
        return null;
    }

    public boolean isNew() {
        return false;
    }
}
