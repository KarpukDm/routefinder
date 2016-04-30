package com.routefinder.bean;

import com.routefinder.model.Account;
import com.routefinder.model.Comment;
import com.routefinder.model.Route;
import com.routefinder.service.AccountService;
import com.routefinder.service.CommentService;
import com.routefinder.service.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * Created by offsp on 21.04.2016.
 */
@ManagedBean
@ViewScoped
@Component
public class CommentBean implements Serializable {
    private static final long serialVersionUID = 1L;

    @Autowired
    private RouteService routeService;

    @Autowired
    private AccountService accountService;

    @Autowired
    private CommentService commentService;

    private String message;

    private Route route;

    public void addComment() {

        if (message != null) {

            Comment comment = new Comment(message);

            String username = AccountBean.getUsername();
            Account account = accountService.findOneAccountByLogin(username);

            comment.setAccount(account);

            //route.addComment(comment);

            comment.setRoute(route);

            commentService.saveAndFlush(comment);

            //routeService.save(route);
        }

        message = "";
    }

    public List<Comment> getMyComments(){

        String username = AccountBean.getUsername();

        return commentService.findAllOrderByAccount_Login(username);

    }

    public List<Comment> getComments(){

        return commentService.findAllOrderByRouteId(route.getId());
        //return route.getComments();
    }

    private Route getRoute(Integer id){
        return routeService.findOneRouteById(id);
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Route getRoute() {
        return route;
    }

    public void setRoute(Route route) {
        this.route = route;
    }
}
