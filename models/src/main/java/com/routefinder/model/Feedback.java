package com.routefinder.model;

import org.springframework.data.domain.Persistable;

import javax.persistence.*;

/**
 * Created by karpukdm on 26.03.16.
 */
@Entity
@Table(name = "feedback")
public class Feedback implements Persistable<Integer> {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "feedback_gen")
    @SequenceGenerator(name = "feedback_gen", sequenceName = "feedback_id_sec", allocationSize = 1)
    @Column(name = "id", unique = true, nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "account_id", nullable = false)
    private Account account;

    @Column(nullable = false)
    private String email;

    public Feedback(){
        super();
    }

    public Feedback(String email) {
        super();
        this.email = email;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getId() {
        return null;
    }

    public boolean isNew() {
        return false;
    }
}
