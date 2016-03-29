package com.routefinder;

import com.routefinder.repository.*;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses( {

        AccountRepositoryTestTest.class,
        CommentRepositoryTestTest.class,
        CommentRepositoryTestTest.class,
        FavoriteRouteRepositoryTestTest.class,
        FeedbackRepositoryTestTest.class,
        MyRouteRepositoryTestTest.class,
        NeighborRepositoryTestTest.class,
        PlannerRepositoryTestTest.class,
        PointRepositoryTestTest.class,
        RatingRepositoryTestTest.class,
        RoleRepositoryTestTest.class,
        RouteInfoRepositoryTestTest.class,
        RouteRepositoryTestTest.class,
        ScheduleRepositoryTestTest.class,
        StatisticsRepositoryTestTest.class
})

public class AppTest {

}
