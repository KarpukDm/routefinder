package com.routefinder;

import com.routefinder.model.*;
import com.routefinder.repository.AccountRepository;
import com.routefinder.repository.RoleRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;


@DirtiesContext
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:database-config/database-context.xml")
public class AppTest {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Before
    public void setUp() {

        Account user = new Account();
        List<Role> userRole = new ArrayList<>();
        userRole.add(new Role("ROLE_ADMIN"));

        user.setLogin("dima");
        user.setPassword("qwerty");
        user.setRoles(userRole);

        accountRepository.save(user);


        System.out.print(user.toString());
    }

    @Test
    public void test(){

    }

    @After
    public void clean() {
        accountRepository.deleteAll();
        roleRepository.deleteAll();
    }
}
