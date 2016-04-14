package com.routefinder.model;

import org.springframework.data.domain.Persistable;

import javax.persistence.*;

/**
 * Created by karpukdm on 26.03.16.
 */
@Entity
@Table(name = "comment")
public class Comment implements Persistable<Integer> {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "comment_gen")
    @SequenceGenerator(name = "comment_gen", sequenceName = "comment_id_sec", allocationSize = 1)
    @Column(name = "id", unique = true, nullable = false)
    private Integer id;

    @Column(nullable = false)
    private String message;

    public Comment(){
        super();
    }

    public Comment(String message){
        super();
        this.message = message;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getId() {
        return id;
    }

    public boolean isNew() {
        return false;
    }

}
