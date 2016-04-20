package com.routefinder.bean;

import com.routefinder.model.Account;
import com.routefinder.model.Comment;
import com.routefinder.model.Route;
import com.routefinder.service.AccountService;
import com.routefinder.service.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.convert.IntegerConverter;
import java.io.Serializable;
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

    private String message;

    public void addComment() {
        if (message != null) {

            Comment comment = new Comment(message);

            String username = AccountBean.getUsername();
            Account account = accountService.findOneAccountByLogin(username);
            if (account != null) {
                account.addComment(comment);
                accountService.save(account);
            }

            Map<String, String> params =
                    FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
            String routeId = params.get("routeId");

            Route route = routeService.findOneRouteById(Integer.valueOf(routeId));

            route.addComment(comment);
            routeService.save(route);
        }
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
