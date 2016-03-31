package com.routefinder.common;

import com.routefinder.service.common.GenericService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Persistable;
import org.springframework.stereotype.Component;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.Serializable;

/**
 * Created by karpukdm on 31.03.16.
 */
@DirtiesContext
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:database-config/database-config.xml")
@Component
public abstract class GenericServiceTest<T extends Persistable<ID>, ID extends Serializable,
        Service extends GenericService<T, ID>> {

    @Autowired
    protected Service service;

    protected abstract T getEntity();

    @Autowired
    protected EntityGenerator entityGenerator;

    protected T entity;

    @Before
    public void before(){

        entity = getEntity();
        service.deleteAll();
    }

    @Test
    public void addEntity(){

        service.save(entity);
    }

}