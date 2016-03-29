package com.routefinder;

import com.routefinder.repository.*;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses( {

        AccountRepositoryTest.class,
        CommentRepositoryTest.class,
        CommentRepositoryTest.class,
        FavoriteRouteRepositoryTest.class,
        FeedbackRepositoryTest.class,
        MyRouteRepositoryTest.class,
        NeighborRepositoryTest.class,
        PlannerRepositoryTest.class,
        PointRepositoryTest.class,
        RatingRepositoryTest.class,
        RoleRepositoryTest.class,
        RouteInfoRepositoryTest.class,
        RouteRepositoryTest.class,
        ScheduleRepositoryTest.class,
        StatisticsRepositoryTest.class
})

public class AppTest {

}
