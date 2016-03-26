package com.routefinder;

import com.routefinder.model.Account;
import com.routefinder.model.Feedback;
import com.routefinder.model.Role;
import com.routefinder.repository.AccountRepository;
import com.routefinder.repository.RoleRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value = "classpath*:spring-db-context.xml")
@Transactional
public class AppTest {
    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Before
    @Rollback(false)
    public void setUp() {
        Account user = new Account("dima", "qwerty");
        List<Role> userRoles = new ArrayList<Role>();
        userRoles.add(new Role("ROLE_USER"));
        user.setRoles(userRoles);

        List<Feedback> feedbacks = new ArrayList<Feedback>();
        feedbacks.add(new Feedback("offspace@yandex.ru"));
        user.setFeedbacks(feedbacks);

        accountRepository.save(user);
    }

    @Test
    public void test1() throws Exception {
       System.out.print("dfgdfgh");
    }

    @After
    public void clean() {
        accountRepository.deleteAll();
    }
}