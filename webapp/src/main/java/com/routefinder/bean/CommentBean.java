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
            /*if (account != null) {
                account.addComment(comment);
                accountService.save(account);
            }*/

            comment.setAccount(account);

            Map<String, String> params =
                    FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
            String id = params.get("routeId");

            Route route = getRoute(Integer.valueOf(id));

           /* route.addComment(comment);
            routeService.saveAndFlush(route);*/

            comment.setRoute(route);

            commentService.save(comment);
        }
    }

    public List<Comment> getComments(){

        FacesContext facesContext = FacesContext.getCurrentInstance();
        ExternalContext externalContext = facesContext.getExternalContext();
        Map<String, Object> requestMap = externalContext.getRequestMap();
        String[] array = null;
        if(requestMap.containsKey("javax.servlet.forward.request_uri")) {
            String request = (String) requestMap.get("javax.servlet.forward.request_uri");
            array = request.split("/");
        }

        if(array == null){
            Map<String, String> params =
                    FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
            String routeId = params.get("routeId");

            return getRoute(Integer.valueOf(routeId)).getComments();
        }

        return getRoute(Integer.valueOf(array[array.length - 1])).getComments();
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
