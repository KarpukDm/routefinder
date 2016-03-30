package com.routefinder.repository;

import com.routefinder.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by karpukdm on 26.03.16.
 */

public interface RoleRepository extends JpaRepository<Role, Integer> {
}
