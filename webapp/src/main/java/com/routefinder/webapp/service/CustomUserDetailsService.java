package com.routefinder.webapp.service;

import com.routefinder.model.Account;
import com.routefinder.model.Role;
import com.routefinder.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by karpukdm on 01.04.16.
 */
@Service
@Transactional
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private AccountService accountService;

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        Account account = accountService.findOneAccountByLogin(login);

        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();

        for (Role role : account.getRoles()) {
            authorities.add(new SimpleGrantedAuthority(role.getName()));
        }

        return new User(account.getLogin(), account.getPassword(), true, true, true, true, authorities);
    }
}
