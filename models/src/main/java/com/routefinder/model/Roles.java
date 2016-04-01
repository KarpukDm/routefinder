package com.routefinder.model;

/**
 * Created by karpukdm on 01.04.16.
 */
public enum Roles {
    ROLE_USER,
    ROLE_ADMIN;

    public static String getRoleUser(){
        return ROLE_USER.name();
    }

    public static String getRoleAdmin(){
        return ROLE_ADMIN.name();
    }
}
