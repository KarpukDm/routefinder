package com.routefinder;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class AppTest {

    private int i;
    private int x;

    @Before
    public void setUp() {
        i = 3;
        x = 5;
    }

    @Test
    public void test1() {
        System.out.println(i);
    }

    @Test
    public void test2() {
        System.out.println(x);
    }

    @After
    public void clean() {
        i = 0;
        x = 0;
    }
}
