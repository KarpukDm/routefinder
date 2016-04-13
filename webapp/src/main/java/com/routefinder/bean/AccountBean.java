package com.routefinder.bean;

import com.routefinder.model.Account;
import com.routefinder.model.Role;
import com.routefinder.model.Roles;
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

    public static String getUsername(){
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


}
