package com.routefinder.model;

import org.springframework.data.domain.Persistable;

/**
 * Created by karpukdm on 26.03.16.
 */
public class Point implements Persistable<Integer> {
    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return null;
    }

    public boolean isNew() {
        return false;
    }
}
