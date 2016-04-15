package com.routefinder.model;

import org.springframework.data.domain.Persistable;

import javax.persistence.*;

/**
 * Created by offsp on 15.04.2016.
 */
@Entity
@Table(name = "route_config")
public class RouteConfig implements Persistable<Integer> {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "rating_gen")
    @SequenceGenerator(name = "rating_gen", sequenceName = "rating_id_sec", allocationSize = 1)
    @Column(name = "id", unique = true, nullable = false)
    private Integer id;

    @Column
    private String duration;
    @Column
    private String lats;
    @Column
    private String lngs;
    @Column
    private String zoomLat;
    @Column
    private String zoomLng;
    @Column
    private String zoomLevel;
    @Column
    private String pointNames;

    public RouteConfig(){
        super();
    }

    public RouteConfig(String duration, String lats, String lngs, String zoomLat, String zoomLng, String zoomLevel, String pointNames){
        this.duration = duration;
        this.lats = lats;
        this.lngs = lngs;
        this.zoomLat = zoomLat;
        this.zoomLng = zoomLng;
        this.zoomLevel = zoomLevel;
        this.pointNames = pointNames;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getLats() {
        return lats;
    }

    public void setLats(String lats) {
        this.lats = lats;
    }

    public String getLngs() {
        return lngs;
    }

    public void setLngs(String lngs) {
        this.lngs = lngs;
    }

    public String getZoomLat() {
        return zoomLat;
    }

    public void setZoomLat(String zoomLat) {
        this.zoomLat = zoomLat;
    }

    public String getZoomLng() {
        return zoomLng;
    }

    public void setZoomLng(String zoomLng) {
        this.zoomLng = zoomLng;
    }

    public String getZoomLevel() {
        return zoomLevel;
    }

    public void setZoomLevel(String zoomLevel) {
        this.zoomLevel = zoomLevel;
    }

    public String getPointNames() {
        return pointNames;
    }

    public void setPointNames(String pointNames) {
        this.pointNames = pointNames;
    }

    public Integer getId() {
        return id;
    }

    public boolean isNew() {
        return false;
    }
}
