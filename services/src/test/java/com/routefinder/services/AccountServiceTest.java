package com.routefinder.services;

import com.routefinder.common.GenericServiceTest;
import com.routefinder.model.*;
import com.routefinder.service.AccountService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedList;
import java.util.List;

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
