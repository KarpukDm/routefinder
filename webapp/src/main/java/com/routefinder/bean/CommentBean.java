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
@SessionScoped
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

    public void addComment() {
        if (message != null) {

            Comment comment = new Comment(message);

            String username = AccountBean.getUsername();
            Account account = accountService.findOneAccountByLogin(username);

            comment.setAccount(account);

            Route route = getRoute(Integer.valueOf(getRouteId()));

            comment.setRoute(route);

            commentService.saveAndFlush(comment);
            routeService.flush();

            this.message = "";
        }
    }

    public List<Comment> getComments(String id){

        if(id == null || Objects.equals(id, "")) {
            Map<String, String> params =
                    FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
            id = params.get("routeId");
        }

        ExternalContext externalContext;
        if(id == null || Objects.equals(id, "")){
            externalContext = FacesContext.getCurrentInstance().getExternalContext();

            Map<String, Object> requestMap = externalContext.getRequestMap();
            if(requestMap.containsKey("javax.servlet.forward.request_uri")) {
                String url = (String) requestMap.get("javax.servlet.forward.request_uri");
                String[] array = url.split("/");
                id = array[array.length - 1];
            }
        }

        assert id != null;
        return commentService.findAllOrderByRouteId(Integer.valueOf(id));
    }

    private String getRouteId(){
        Map<String, String> params =
                FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        return params.get("routeId");
    }

    private Route getRoute(Integer id){
        return routeService.findOneRouteById(id);
    }

    public RouteService getRouteService() {
        return routeService;
    }

    public void setRouteService(RouteService routeService) {
        this.routeService = routeService;
    }

    public AccountService getAccountService() {
        return accountService;
    }

    public void setAccountService(AccountService accountService) {
        this.accountService = accountService;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
