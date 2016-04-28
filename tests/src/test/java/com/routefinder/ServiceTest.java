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
        AddressServiceTest.class,
        MyRouteServiceTest.class,
        NeighborServiceTest.class,
        SearchResultServiceTest.class,
        PointServiceTest.class,
        RatingServiceTest.class,
        RoleServiceTest.class,
        RouteServiceTest.class,
        ScheduleServiceTest.class,
        StatisticsServiceTest.class
})

public class ServiceTest {

}
