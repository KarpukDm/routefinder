package com.routefinder;

import com.routefinder.model.*;
import com.routefinder.repository.AccountRepository;
import com.routefinder.repository.RoleRepository;
import org.junit.After;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by karpukdm on 29.03.16.
 */
@DirtiesContext
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:database-config/database-context.xml")
public class BeforeMethod {
    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private RoleRepository roleRepository;

    @org.junit.Before
    public void setUp() {

        Route route = new Route();
        RouteInfo routeInfo = new RouteInfo();
        List<Statistics> statistics = new LinkedList<>();
        statistics.add(new Statistics(123, "March"));

        List<Schedule> schedules = new LinkedList<>();
        schedules.add(new Schedule("monday", "10:15"));

        routeInfo.setSchedules(schedules);
        routeInfo.setStatistics(statistics);

        route.setRouteInfo(routeInfo);

        Account user = new Account();
        List<Role> userRole = new LinkedList<>();
        userRole.add(new Role("ROLE_ADMIN"));

        user.setLogin("dima");
        user.setPassword("qwerty");
        user.setRoles(userRole);

        List<Feedback> feedbacks = new LinkedList<>();
        feedbacks.add(new Feedback("karpukdm@gmail.com"));
        user.setFeedbacks(feedbacks);
    }

    @After
    public void clean() {
        accountRepository.deleteAll();
        roleRepository.deleteAll();
    }
}
