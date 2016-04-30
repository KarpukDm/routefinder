package com.routefinder.bean;

import com.routefinder.model.Schedule;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by offsp on 14.04.2016.
 */
@ManagedBean
@SessionScoped
public class ScheduleBean {

    private String monday;
    private String tuesday;
    private String wednesday;
    private String thursday;
    private String friday;
    private String saturday;
    private String sunday;

    private String monday2;
    private String tuesday2;
    private String wednesday2;
    private String thursday2;
    private String friday2;
    private String saturday2;
    private String sunday2;

    public List<Schedule> getScheduleList() {

        List<Schedule> schedules = new LinkedList<>();

        schedules.add(new Schedule("Monday", monday, monday2));
        schedules.add(new Schedule("Tuesday", tuesday, tuesday2));
        schedules.add(new Schedule("Wednesday", wednesday, wednesday2));
        schedules.add(new Schedule("Thursday", thursday, thursday2));
        schedules.add(new Schedule("Friday", friday, friday2));
        schedules.add(new Schedule("Saturday", saturday, saturday2));
        schedules.add(new Schedule("Sunday", sunday, sunday2));

        schedules = removeUnnecessary(schedules);

        return schedules;
    }

    private List<Schedule> removeUnnecessary(List<Schedule> schedules){

        for (int i = 0; i < schedules.size(); i++) {
            if ("".equals(schedules.get(i).getDepartureTime()) || "".equals(schedules.get(i).getArrivalTime())) {
                schedules.remove(i);
                i--;
                continue;
            }
            String[] array = schedules.get(i).getDepartureTime().split(":");
            if (array.length == 1){
                schedules.get(i).setDepartureTime(array[0] + ":00");
            }

            array = schedules.get(i).getArrivalTime().split(":");
            if (array.length == 1){
                schedules.get(i).setArrivalTime(array[0] + ":00");
            }
        }

        return schedules;
    }

    public String getTuesday() {
        return tuesday;
    }

    public void setTuesday(String tuesday) {
        this.tuesday = tuesday;
    }

    public String getMonday() {
        return monday;
    }

    public void setMonday(String monday) {
        this.monday = monday;
    }

    public String getWednesday() {
        return wednesday;
    }

    public void setWednesday(String wednesday) {
        this.wednesday = wednesday;
    }

    public String getThursday() {
        return thursday;
    }

    public void setThursday(String thursday) {
        this.thursday = thursday;
    }

    public String getFriday() {
        return friday;
    }

    public void setFriday(String friday) {
        this.friday = friday;
    }

    public String getSaturday() {
        return saturday;
    }

    public void setSaturday(String saturday) {
        this.saturday = saturday;
    }

    public String getSunday() {
        return sunday;
    }

    public void setSunday(String sunday) {
        this.sunday = sunday;
    }

    public String getMonday2() {
        return monday2;
    }

    public void setMonday2(String monday2) {
        this.monday2 = monday2;
    }

    public String getTuesday2() {
        return tuesday2;
    }

    public void setTuesday2(String tuesday2) {
        this.tuesday2 = tuesday2;
    }

    public String getWednesday2() {
        return wednesday2;
    }

    public void setWednesday2(String wednesday2) {
        this.wednesday2 = wednesday2;
    }

    public String getThursday2() {
        return thursday2;
    }

    public void setThursday2(String thursday2) {
        this.thursday2 = thursday2;
    }

    public String getFriday2() {
        return friday2;
    }

    public void setFriday2(String friday2) {
        this.friday2 = friday2;
    }

    public String getSaturday2() {
        return saturday2;
    }

    public void setSaturday2(String saturday2) {
        this.saturday2 = saturday2;
    }

    public String getSunday2() {
        return sunday2;
    }

    public void setSunday2(String sunday2) {
        this.sunday2 = sunday2;
    }
}
