package org.example.spring_samples.data_jpa_hibernate;

import org.example.spring_samples.data_jpa_hibernate.config.AppConfigDataJPA;
import org.example.spring_samples.data_jpa_hibernate.entity.Account;
import org.example.spring_samples.data_jpa_hibernate.service.AccountService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class SpringMain {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfigDataJPA.class);
        AccountService accountService = ctx.getBean(AccountService.class);
        Account acc = new Account();
        acc.setAcc_num("789");
        acc.setName("Naveen");
        acc.setCity("bangalore");
        acc.setEmail("naveen14@gmail.com");
        acc.setPhone("8988735272");
        acc.setBalance(500);
        accountService.createAccount(acc);

        List<Account> accounts = accountService.getAccount();
        System.out.println(accounts);

    }
}
