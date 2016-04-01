package com.routefinder.service;

import com.routefinder.model.Account;
import com.routefinder.service.common.GenericService;

/**
 * Created by karpukdm on 29.03.16.
 */

public interface AccountService extends GenericService<Account, Integer> {

    Account findOneAccountById(Integer id);
    Account findOneAccountByLogin(String login);

    void deleteOneById(Integer id);
    void deleteOneByLogin(String login);

}
