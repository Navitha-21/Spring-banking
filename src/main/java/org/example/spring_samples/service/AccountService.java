package org.example.spring_samples.service;

import org.example.spring_samples.entity.Account;
import org.example.spring_samples.entity.Transactions;
import org.example.spring_samples.respository.AccountRepository;
import org.example.spring_samples.respository.TransactionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService {

    @Autowired
    AccountRepository accountRepository;

    @Autowired
    TransactionsRepository transactionsRepository;

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

    public void insertTransactions(Transactions tnx) {
       transactionsRepository.save(tnx);
    }


    public void deposit (Long acc_id, double amount) {
        Account acc = accountRepository.findById(acc_id);
        if (acc == null) {
            System.out.println("Account not found");
            return;
        }
        acc.setBalance(acc.getBalance() + amount);
        accountRepository.save(acc);
        saveTransactions(acc, "Deposit", amount);
    }

//    public void depositt(Long acc_id, double amount){
//        Transactions tnx= transactionsRepository.findById(acc_id);
//        if(tnx==null){
//            System.out.println("Account not found");
//            return;
//        }
//        tnx.setAmount(tnx.getAmount()+ amount);
//        transactionsRepository.save(tnx);
//        saveTransactions(tnx.getAccount(), "depositt", amount);
//    }

    public  void withdraw(Long acc_id,double amount ){
        Account acc = accountRepository.findById(acc_id);
        if (acc.getBalance() < amount) {
            System.out.println("Insufficient balance");
            return;
        }
        acc.setBalance(acc.getBalance() - amount );
        accountRepository.save(acc);
        saveTransactions(acc,"Withdraw",amount);
    }

    public void transfer(Long fromAcc_id, Long toACC_id, double amount){

        Account from = accountRepository.findById(fromAcc_id);

        if(from.getBalance() < amount){
            System.out.println("Error");
            return;
        }else{
            from.setBalance(from.getBalance() - amount);

            Account to = accountRepository.findById(toACC_id);
            to.setBalance(to.getBalance() + amount);
            accountRepository.save(from);
            accountRepository.save(to);

            saveTransactions(from, "TransferOut", amount);
            saveTransactions(to, "TransferIn", amount);
        }


    }

    public void printTransactions(Long accId) {
        Account acc = accountRepository.findById(accId);

        if (acc == null) {
            System.out.println("Account not found");
            return;
        }
        transactionsRepository.findByAccount(acc).forEach(System.out::println);
    }

    private void saveTransactions(Account acc,String type,double amount){
        Transactions tnx = new Transactions() ;
        tnx.setAccount(acc);
        tnx.setType(type);
        tnx.setAmount(amount);
        transactionsRepository.save(tnx);

    }
    }

