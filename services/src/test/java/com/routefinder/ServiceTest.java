package com.routefinder;

import com.routefinder.services.*;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * Created by karpukdm on 30.03.16.
 */

@RunWith(Suite.class)
@Suite.SuiteClasses( {
        AccountServiceTest.class,
        CommentServiceTest.class,
        CoordinatestServiceTest.class,
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

public class ServiceTest {

}
