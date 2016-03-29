package com.routefinder.repository;

import com.routefinder.common.GenericRepositoryTest;
import com.routefinder.model.Account;
import com.routefinder.model.Role;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by karpukdm on 27.03.16.
 */
@DirtiesContext
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:database-config/database-context.xml")
public class AccountRepositoryTestTest extends GenericRepositoryTest {

    @Autowired
    private AccountRepository accountRepository;

    @Before
    public void before(){
        accountRepository.deleteAll();
    }

    @Test
    public void addAccount(){
        Account account = new Account("KarpukDM", "1111");
        List<Role> roles = new LinkedList<>();
        roles.add(new Role("ROLE_ADMIN"));
        account.setRoles(roles);

        accountRepository.save(account);
    }

    @Test
    public void findById(){
        Account user = accountRepository.findOneAccountById(1);
        if(user != null) {
            System.out.println(user.toString());
        }
    }

    @Test
    public void findByLogin(){
        Account user = accountRepository.findOneAccountByLogin("KarpukDM");
        if(user != null) {
            System.out.println(user.toString());
        }
    }

    @Test
    public void deleteById(){
        accountRepository.deleteOneById(1);
    }

    @Test
    public void deleteByLogin(){
        accountRepository.deleteOneByLogin("KarpukDM");
    }
}
