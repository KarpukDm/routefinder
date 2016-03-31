package com.routefinder.services;

import com.routefinder.common.GenericServiceTest;
import com.routefinder.model.Role;
import com.routefinder.service.RoleService;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by karpukdm on 31.03.16.
 */
@Transactional
public class RoleServiceTest extends GenericServiceTest<Role, Integer, RoleService> {
    @Override
    protected Role getEntity() {
        return entityGenerator.getRoleEntity();
    }
}
