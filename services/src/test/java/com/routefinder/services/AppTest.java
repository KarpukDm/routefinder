package com.routefinder.services;

import com.routefinder.model.Account;
import com.routefinder.model.Role;
import com.routefinder.repository.AccountRepository;
import com.routefinder.service.AccountService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by karpukdm on 30.03.16.
 */

@DirtiesContext
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:database-config/database-config.xml")
public class AppTest {

    @Autowired
    public AccountService accountService;

    @Before
    public void before(){
        accountService.deleteAll();
    }

    @Test
    public void test2(){
        Account account = new Account("admin", "KarpukDM");
        List<Role> roles = new LinkedList<>();
        roles.add(new Role("ROLE_ADMIN"));
        account.setRoles(roles);

        accountService.save(account);
    }
}
