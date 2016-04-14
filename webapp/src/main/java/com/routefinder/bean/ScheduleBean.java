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

    public List<Schedule> getScheduleList() {

        List<Schedule> schedules = new LinkedList<>();

        schedules.add(new Schedule("Monday", monday));
        schedules.add(new Schedule("Tuesday", tuesday));
        schedules.add(new Schedule("Wednesday", wednesday));
        schedules.add(new Schedule("Thursday", thursday));
        schedules.add(new Schedule("Friday", friday));
        schedules.add(new Schedule("Saturday", saturday));
        schedules.add(new Schedule("Sunday", sunday));

        schedules = removeUnnecessary(schedules);

        if(schedules.size() == 0){
            schedules.add(new Schedule("Invalid ", "route"));
        }

        return schedules;
    }

    private List<Schedule> removeUnnecessary(List<Schedule> schedules){

        for (int i = 0; i < schedules.size(); i++) {
            if ("".equals(schedules.get(i).getTime())) {
                schedules.remove(i);
                i--;
                continue;
            }
            String[] array = schedules.get(i).getTime().split(":");
            if (array.length == 1){
                schedules.get(i).setTime(array[0] + ":00");
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
}
