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

    public Account(){
        super();
    }

    public Account(String password, String login){
        super();
        this.login = login;
        this.password = password;
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

    public Integer getId() {
        return id;
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

    public void addRatind(Rating rating){

        ratings.add(rating);
    }

    @ManyToMany(cascade = CascadeType.ALL)
    private List<Role> roles;

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<FavoriteRoute> favoritesRoutes;

    public List<FavoriteRoute> getFavoritesRoutes() {
        return favoritesRoutes;
    }

    public void setFavoritesRoutes(List<FavoriteRoute> favoritesRoutes) {
        this.favoritesRoutes = favoritesRoutes;
    }

    @OneToMany(cascade = CascadeType.ALL)
    private List<Address> addresses;

    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "account")
    private List<Rating> ratings;

    public List<Rating> getRatings() {
        return ratings;
    }

    public void setRatings(List<Rating> ratings) {
        this.ratings = ratings;
    }

    @OneToMany(mappedBy = "account", cascade = CascadeType.ALL)
    private List<Route> routes;

    public List<Route> getRoutes() {
        return routes;
    }

    public void setRoutes(List<Route> routes) {
        this.routes = routes;
    }

    public void addRoute(Route route) {
        this.routes.add(route);
    }
}
