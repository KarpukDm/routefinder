package com.routefinder.model;
import org.springframework.data.domain.Persistable;

import javax.persistence.*;
import java.util.List;

/**
 * Created by karpukdm on 26.03.16.
 */
@Entity
@Table(name = "account",
    uniqueConstraints = {
            @UniqueConstraint(name = "account_login", columnNames = {"login"})
    })
public class Account implements Persistable<Integer> {
    private static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name = "account_seq", sequenceName = "account_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "account_seq")
    @Column(name = "id")
    private Integer id;

    @Column(name = "login", unique = true, nullable = false)
    private String login;

    @Column(name = "password", nullable = false)
    private String password;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "account")
    private List<Feedback> feedbacks;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name="account_role",
            joinColumns = @JoinColumn(name="account_id", referencedColumnName="id", updatable = false, nullable = false),
            inverseJoinColumns = @JoinColumn(name="role_id", referencedColumnName="id", updatable = false, nullable = false)
    )
    private List<Role> roles;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "account")
    private List<Rating> ratings;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "account")
    private List<Comment> comments;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "account")
    private List<MyRoute> myRoutes;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "account")
    private List<FavoriteRoute> favoriteRoutes;

    public Account(){
        super();
    }

    public Account(String password, String login){
        super();
        this.login = login;
        this.password = password;
    }

    public List<Feedback> getFeedbacks() {
        return feedbacks;
    }

    public void setFeedbacks(List<Feedback> feedbacks) {
        this.feedbacks = feedbacks;
    }

    public List<Rating> getRatings() {
        return ratings;
    }

    public void setRatings(List<Rating> ratings) {
        this.ratings = ratings;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public List<MyRoute> getMyRoutes() {
        return myRoutes;
    }

    public void setMyRoutes(List<MyRoute> myRoutes) {
        this.myRoutes = myRoutes;
    }

    public List<FavoriteRoute> getFavoriteRoutes() {
        return favoriteRoutes;
    }

    public void setFavoriteRoutes(List<FavoriteRoute> favoriteRoutes) {
        this.favoriteRoutes = favoriteRoutes;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public Integer getId() {
        return null;
    }

    public boolean isNew() {
        return false;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
