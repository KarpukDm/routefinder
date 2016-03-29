package com.routefinder.service.impl;

import com.routefinder.model.Role;
import com.routefinder.repository.RoleRepository;
import com.routefinder.service.RoleService;
import com.routefinder.service.common.impl.GenericServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by karpukdm on 29.03.16.
 */
@Service
@Transactional
public class RoleServiceImpl extends GenericServiceImpl<Role, Integer, RoleRepository>
        implements RoleService{
}
