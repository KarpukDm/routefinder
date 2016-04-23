package com.routefinder.bean;

import com.routefinder.model.*;
import com.routefinder.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * Created by karpukdm on 01.04.16.
 */
@ManagedBean
@SessionScoped
@Component
public class AccountBean implements Serializable {
    private static final long serialVersionUID = 1L;

    @Autowired
    private AccountService accountService;

    private String repeatedPassword;
    private String login;
    private String password;

    private String requestedRouteId;

    public boolean isOwnerOrAdmin(Route route){

        if(route == null) return false;

        Account account = accountService.findOneAccountByLogin(getUsername());

        List<Role> roles = account.getRoles();
        for (Role role : roles){
            if(role.getName().equals("ROLE_ADMIN")){
                return true;
            }
        }

        List<MyRoute> myRoutes = account.getMyRoutes();
        for(MyRoute myRoute : myRoutes){

            if(myRoute.getRoute() == null) continue;

            if(Objects.equals(myRoute.getRoute().getId(), route.getId())){
                return true;
            }
        }

        return false;
    }

    public boolean isExistLike(Route route){

        return isExistRating(route, 1);
    }

    public boolean isExistDislike(Route route){

        return isExistRating(route, -1);
    }

    private boolean isExistRating(Route route, int value){

        if(route == null) return false;

        Account account = accountService.findOneAccountByLogin(getUsername());

        for(Rating r : account.getRatings()){
            if(r.getValue() == value && Objects.equals(r.getRoute().getId(), route.getId())){
                return true;
            }
        }

        return false;
    }

    public ModelAndView signUp(){

        if(this.repeatedPassword.equals(password)){
            if(!isExist(login)){
                List<Role> roles = new LinkedList<>();
                roles.add(new Role(Roles.getRoleUser()));

                Account newUser = new Account();
                newUser.setPassword(password);
                newUser.setLogin(login);
                newUser.setRoles(roles);

                accountService.save(newUser);

                return new ModelAndView("redirect:/profile");
            }
        }
        return new ModelAndView("redirect:/main");
    }

    public String getUser(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            return authentication.getName();
        }
        return null;
    }

    static String getUsername(){
        FacesContext facesContext = FacesContext.getCurrentInstance();
        ExternalContext externalContext = facesContext.getExternalContext();
        Map<String, Object> sessionMap = externalContext.getSessionMap();
        SecurityContext springSessionContext = (SecurityContext) sessionMap.get("SPRING_SECURITY_CONTEXT");
        Authentication authentication = springSessionContext.getAuthentication();
        User user = (User) authentication.getPrincipal();

        return user.getUsername();
    }

    private boolean isExist(String login){
        return accountService.findOneAccountByLogin(login) != null;
    }

    public String getRepeatedPassword() {
        return repeatedPassword;
    }

    public void setRepeatedPassword(String repeatedPassword) {
        this.repeatedPassword = repeatedPassword;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRequestedRouteId() {
        return requestedRouteId;
    }

    public void setRequestedRouteId(String requestedRouteId) {
        this.requestedRouteId = requestedRouteId;
    }
}
