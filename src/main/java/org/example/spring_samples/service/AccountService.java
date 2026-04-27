package org.example.spring_samples.service;

import org.example.spring_samples.entity.Account;
import org.example.spring_samples.respository.AccountRepository;
import org.example.spring_samples.spring_AOP.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService {
    @Autowired
    AccountRepository accountRepository;

    @Autowired
    PaymentService paymentService;

    public void createAccount(Account acc) {
        accountRepository.save(acc);
    }

    public Account getAccount(Long id) {
        return accountRepository.findById(id);
    }

    public List<Account> getAccount() {
        return accountRepository.getAccounts();
    }

    public void delete(Long id) {
        accountRepository.delete(id);
    }

    public void deleteWithFailure(Long id) {
        accountRepository.deleteWithFailure(id);
    }

    public void deposit(Long acc_id, double amount) {
        paymentService.deposit(acc_id, amount);
    }

    public void withdraw(Long acc_id, double amount) {
        paymentService.withdraw(acc_id, amount);
    }

    public void transfer(Long fromAcc, Long toAcc, double amount) {
        paymentService.transfer(fromAcc, toAcc, amount);
    }


}
