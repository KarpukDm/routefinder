package com.routefinder.service.impl;

import com.routefinder.model.Account;
import com.routefinder.repository.AccountRepository;
import com.routefinder.service.AccountService;
import com.routefinder.service.common.impl.GenericServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by karpukdm on 29.03.16.
 */
@Service
@Transactional
public class AccountServiceImpl extends GenericServiceImpl<Account, Integer, AccountRepository>
        implements AccountService{


}
