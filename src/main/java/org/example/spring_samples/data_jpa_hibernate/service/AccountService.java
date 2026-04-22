package org.example.spring_samples.data_jpa_hibernate.service;

import org.example.spring_samples.data_jpa_hibernate.entity.Account;
import org.example.spring_samples.data_jpa_hibernate.respository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService {

    @Autowired
    AccountRepository accountRepository;

    public void createAccount(Account acc){
        accountRepository.save(acc);
    }

    public Account getAccount(Long id){
        return accountRepository.findById(id);
    }

    public List<Account> getAccount(){
        return accountRepository.getAccounts();
    }


    public void delete(Long id ){
        accountRepository.delete(id);
    }

    public void deleteWithFailure(Long id ){
        accountRepository.deleteWithFailure(id);
    }
}
