package org.example.spring_samples.spring_AOP;

import org.example.spring_samples.entity.Account;
import org.example.spring_samples.entity.Transactions;
import org.example.spring_samples.respository.AccountRepository;
import org.example.spring_samples.respository.TransactionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {
    @Autowired
    AccountRepository accountRepository;
    @Autowired
    TransactionsRepository transactionsRepository;

    public void deposit(Long acc_id, double amount) {
        Account acc = accountRepository.findById(acc_id);
        if (acc == null) {
            throw new IllegalArgumentException("Account not found");
        }
        acc.setBalance(acc.getBalance() + amount);
        accountRepository.update(acc);
        saveTransactions(acc, "Deposit", amount);

    }

    public  void withdraw(Long acc_id,double amount ){
        Account acc = accountRepository.findById(acc_id);
        if (acc.getBalance() < amount) {
            throw new IllegalArgumentException("Insufficient balance");
        }
        acc.setBalance(acc.getBalance() - amount );
        accountRepository.update(acc);
        saveTransactions(acc,"Withdraw",amount);
    }


    public void transfer(Long fromAcc, Long toAcc, double amount){
        Account from = accountRepository.findById(fromAcc);
        Account to = accountRepository.findById(toAcc);
        if (from == null || to == null || from.getBalance() < amount ) {
            throw new IllegalArgumentException("Account not found");
        }
        from.setBalance(from.getBalance() - amount);
        to.setBalance(to.getBalance() + amount);
        accountRepository.update(from);
        accountRepository.update(to);
        saveTransactions(from, "Debit", amount);
        saveTransactions(to, "Credit", amount);
    }

//    public void printTransactions(Long acc_id) {
//        Account acc = accountRepository.findById(acc_id);
//        if (acc == null) {
//            throw new IllegalArgumentException("Account not found");
//        }
//        transactionsRepository.findByAccount(acc).forEach(System.out::println);
//    }

   private void saveTransactions(Account acc,String type,double amount){
        Transactions tnx = new Transactions() ;
        tnx.setAccount(acc);
        tnx.setType(type);
        tnx.setAmount(amount);
        transactionsRepository.save(tnx);
    }
}
