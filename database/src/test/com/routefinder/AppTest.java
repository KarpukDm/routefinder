package com.routefinder;

import com.routefinder.repository.*;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses( {

        AccountServiceTest.class,
        CommentServiceTest.class,
        CommentServiceTest.class,
        FavoriteRouteServiceTest.class,
        FeedbackServiceTest.class,
        MyRouteServiceTest.class,
        NeighborServiceTest.class,
        PlannerServiceTest.class,
        PointServiceTest.class,
        RatingServiceTest.class,
        RoleServiceTest.class,
        RouteInfoServiceTest.class,
        RouteServiceTest.class,
        ScheduleServiceTest.class,
        StatisticsServiceTest.class
})

public class AppTest {

}