package com.routefinder.repository;

import com.routefinder.common.GenericServiceTest;
import com.routefinder.model.Account;
import com.routefinder.model.Role;
import com.routefinder.service.AccountService;
import com.routefinder.service.common.GenericService;
import com.routefinder.service.impl.AccountServiceImpl;
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
 * Created by karpukdm on 27.03.16.
 */
@DirtiesContext
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:database-config/database-context.xml")
public class AccountServiceTest extends GenericServiceTest {

    @Autowired
    private AccountService accountService;

    @Before
    public void before(){
        accountService.deleteAll();
    }

    @Test
    public void addAccount(){
        Account account = new Account("KarpukDM", "1111");
        List<Role> roles = new LinkedList<>();
        roles.add(new Role("ROLE_ADMIN"));
        account.setRoles(roles);

        accountService.save(account);
    }

    @Test
    public void findByLogin(){
        Account user = accountService.findOneAccountByLogin("KarpukDM");
        if(user != null) {
            System.out.println(user.toString());
        }
    }

    @Test
    public void counter(){
        System.out.println(accountService.count());
    }

}
