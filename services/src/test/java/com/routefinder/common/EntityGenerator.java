package com.routefinder.common;

import com.routefinder.model.*;
import com.routefinder.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by karpukdm on 31.03.16.
 */
@Component
@Transactional
public class EntityGenerator {

    @Autowired
    private AccountService accountService;

    @Autowired
    private CommentService commentService;

    @Autowired
    private CoordinatesService coordinatesService;

    @Autowired
    private FavoriteRouteService favoriteRouteService;

    @Autowired
    private FeedbackService feedbackService;

    @Autowired
    private MyRouteService myRouteService;

    @Autowired
    private NeighborService neighborService;

    @Autowired
    private PlannerService plannerService;

    @Autowired
    private PointService pointService;

    @Autowired
    private RatingService ratingService;

    @Autowired
    private  RoleService roleService;

    @Autowired
    private  RouteInfoService routeInfoService;

    @Autowired
    private RouteService routeService;

    @Autowired
    private  ScheduleService scheduleService;

    @Autowired
    private  StatisticsService statisticsService;

    public Account getAccountEntity(){
        Account account = new Account();
        account.setLogin("KarpukDMITRY");
        account.setPassword("admin");

        List<Role> roles = new LinkedList<>();
        roles.add(new Role("ROLE_ADMIN"));
        roles.add(new Role("ROLE_ADMIN"));
        account.setRoles(roles);

        List<Feedback> feedbacks = new LinkedList<>();
        feedbacks.add(new Feedback("email@email.com"));
        account.setFeedbacks(feedbacks);

        Route route = new Route();
        RouteInfo routeInfo = new RouteInfo();
        route.setRouteInfo(routeInfo);

        List<FavoriteRoute> favoriteRoutes = new LinkedList<>();
        favoriteRoutes.add(new FavoriteRoute(route.getId()));

        List<Comment> comments = new LinkedList<>();
        comments.add(new Comment("message"));

        route.setComments(comments);
        account.setComments(comments);
        return account;
    }

    public Comment getCommentEntity(){
        Comment comment = new Comment("message");
        comment.setAccount(accountService.findOneAccountByLogin("KarpukDM"));
        return new Comment("message");
    }

    public Coordinates getCoordinatesEntity(){
        return new Coordinates(12.2, 13.3);
    }

    public FavoriteRoute getFavoriteRouteEntity(){
        return new FavoriteRoute(1);
    }

    public Feedback getFeedbackEntity(){
        return new Feedback("email@email.com");
    }

    public MyRoute getMyRouteEntity(){
        return new MyRoute(1);
    }

    public Neighbor getNeighborEntity(){
        return new Neighbor(12.4);
    }

    public Planner getPlannerEntity(){
        return new Planner(1, "14:00", "notice");
    }

    public Point getPointEntity(){
        return new Point("name");
    }

    public Rating getRatingEntity(){
        return new Rating(12.2);
    }

    public Role getRoleEntity(){
        return new Role("ROLE_ADMIN");
    }

    public RouteInfo getRouteInfoEntity(){
        return new RouteInfo();
    }

    public Route getRouteEntity(){
        return new Route(12.2);
    }

    public Schedule getScheduleEntity(){
        return new Schedule("Monday", "15:22");
    }

    public Statistics getStatisticsEntity(){
        return new Statistics(31, "March");
    }
}
