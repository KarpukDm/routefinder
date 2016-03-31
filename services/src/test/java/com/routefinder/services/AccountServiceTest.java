package com.routefinder.services;

import com.routefinder.common.GenericServiceTest;
import com.routefinder.model.Account;
import com.routefinder.service.AccountService;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by karpukdm on 31.03.16.
 */
@Transactional
public class AccountServiceTest extends GenericServiceTest<Account, Integer, AccountService>{

    @Override
    protected Account getEntity(){
        return entityGenerator.getAccountEntity();
    }
}
