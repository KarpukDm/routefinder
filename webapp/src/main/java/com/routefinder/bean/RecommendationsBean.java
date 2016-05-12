package com.routefinder.bean;

import com.routefinder.model.Route;
import org.springframework.stereotype.Component;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;
import java.util.List;

/**
 * Created by offsp on 12.05.2016.
 */
@ManagedBean
@SessionScoped
@Component
public class RecommendationsBean implements Serializable {
    private static final long serialVersionUID = 1L;

    public List<Route> getRoutes(){

        return null;
    }
}
