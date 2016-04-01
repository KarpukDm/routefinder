package com.routefinder.bean;

import com.routefinder.model.Account;
import com.routefinder.model.Role;
import com.routefinder.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by karpukdm on 01.04.16.
 */
@ManagedBean
@SessionScoped
@Component
//@ManageProperty("#{accountService}")

//подключить el-resolver faces-config.
public class AccountBean implements Serializable {
    private static final long serialVersionUID = 1L;

    //@ManagedProperty("#{accountService}")
    @Autowired
    private AccountService accountService;

    private String repeatedPassword;
    private String login;
    private String password;


    public void signUp(){

        if(this.repeatedPassword.equals(password)){
            if(accountService.findOneAccountByLogin(login) == null){
                List<Role> roles = new LinkedList<Role>();
                roles.add(new Role("ROLE_USER"));

                Account newUser = new Account();
                newUser.setPassword(password);
                newUser.setLogin(login);
                newUser.setRoles(roles);

                accountService.save(newUser);
            }
        }
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
