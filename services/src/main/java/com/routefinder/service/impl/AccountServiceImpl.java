package com.routefinder.service.impl;


import com.routefinder.repository.AccountRepository;
import com.routefinder.service.AccountService;
import com.routefinder.service.common.impl.GenericServiceImpl;
import com.routefinder.model.Account;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by karpukdm on 29.03.16.
 */
@Service
@Qualifier("accountService")
@Transactional
public class AccountServiceImpl extends GenericServiceImpl<Account, Integer, AccountRepository>
        implements AccountService{

    @Override
    public Account findOneAccountById(Integer id) {
        return repository.findOneAccountById(id);
    }

    @Override
    public Account findOneAccountByLogin(String login) {
        return repository.findOneAccountByLogin(login);
    }

    @Override
    public void deleteOneById(Integer id) {
        repository.deleteOneById(id);
    }

    @Override
    public void deleteOneByLogin(String login) {
        repository.deleteOneByLogin(login);
    }

}
