package com.routefinder.repository;

import com.routefinder.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by karpukdm on 26.03.16.
 */
public interface AccountRepository extends JpaRepository<Account, Integer>{

}
