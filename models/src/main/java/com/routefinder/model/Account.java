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

    public void like(Integer id){
        ratings.add(new Rating(1, id));

        for(int i = 0; i < ratings.size(); i++){
            if(ratings.get(i).getValue() == -1 && ratings.get(i).getRouteId().equals(id)){
                ratings.remove(i);
                return;
            }
        }
    }

    public void dislike(Integer id){
        ratings.add(new Rating(-1, id));

        for(int i = 0; i < ratings.size(); i++){
            if(ratings.get(i).getValue() == 1 && ratings.get(i).getRouteId().equals(id)){
                ratings.remove(i);
                return;
            }
        }
    }

    public Account(String password, String login){
        super();
        this.login = login;
        this.password = password;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void addRoute(MyRoute myRoute){
        myRoutes.add(myRoute);
    }

    public void addComment(Comment comment){
        comments.add(comment);
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

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Rating> ratings;

    public List<Rating> getRatings() {
        return ratings;
    }

    public void setRatings(List<Rating> ratings) {
        this.ratings = ratings;
    }

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<MyRoute> myRoutes;

    public List<MyRoute> getMyRoutes() {
        return myRoutes;
    }

    public void setMyRoutes(List<MyRoute> myRoutes) {
        this.myRoutes = myRoutes;
    }

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Comment> comments;

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

}
