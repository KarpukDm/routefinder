package com.routefinder.model;

import org.springframework.data.domain.Persistable;

import javax.persistence.*;
import java.util.List;

/**
 * Created by karpukdm on 26.03.16.
 */
@Entity
@Table(name = "role")
public class Role implements Persistable<Integer> {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "account_gen")
    @SequenceGenerator(name = "role_gen", sequenceName = "role_id_sec", allocationSize = 1)
    @Column(name = "id", unique = true, nullable = false)
    private Integer id;

    @Column
    private String name;

    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "roles")
    private List<Account> users;

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Account> getUsers() {
        return users;
    }

    public void setUsers(List<Account> users) {
        this.users = users;
    }

    public Integer getId() {
        return null;
    }

    public boolean isNew() {
        return false;
    }
}
