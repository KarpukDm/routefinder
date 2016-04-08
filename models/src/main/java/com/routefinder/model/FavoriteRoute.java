package com.routefinder.model;

import org.springframework.data.domain.Persistable;

import javax.persistence.*;

/**
 * Created by karpukdm on 26.03.16.
 */
@Entity
@Table(name = "favorite_route")
public class FavoriteRoute implements Persistable<Integer> {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "favorite_gen")
    @SequenceGenerator(name = "favorite_gen", sequenceName = "favorite_id_sec", allocationSize = 1)
    @Column(name = "id", unique = true, nullable = false)
    private Integer id;

    @Column
    private Integer route_id;

    public FavoriteRoute(Integer route_id){
        super();
        this.route_id =  route_id;
    }

    public FavoriteRoute(){
        super();
    }

    public Integer getRoute_id() {
        return route_id;
    }

    public void setRoute_id(Integer route_id) {
        this.route_id = route_id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return null;
    }

    public boolean isNew() {
        return false;
    }

    @ManyToOne(cascade=CascadeType.ALL)
    private Account account;

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}
