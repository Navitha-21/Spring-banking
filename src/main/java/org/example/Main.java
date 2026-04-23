package org.example;

import org.example.spring_samples.config.AppConfigDataJPA;
import org.example.spring_samples.entity.Account;
import org.example.spring_samples.entity.Transactions;
import org.example.spring_samples.service.AccountService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfigDataJPA.class);
        AccountService accountService = ctx.getBean(AccountService.class);
//        Account acc = new Account();
//        acc.setAcc_num("146");
//        acc.setName("thanvi");
//        acc.setCity("bangalore");
//        acc.setEmail("thanvi897@gmail.com");
//        acc.setPhone("8988735589");
//        acc.setBalance(5000);
//        accountService.createAccount(acc);
//
//        Account acc1 = new Account();
//        acc1.setAcc_num("214");
//        acc1.setName("Nani");
//        acc1.setCity("hyderabad");
//        acc1.setEmail("nani12@gmail.com");
//        acc1.setPhone("86328290177");
//        acc1.setBalance(500);
//        accountService.createAccount(acc1);

//        List<Account> accounts = accountService.getAccount();
//        System.out.println(accounts);



//        long accId=accounts.get(0).getId();
//        long acc1Id=accounts.get(1).getId();
//
//        accountService.deposit(accId, 500);
//        accountService.withdraw(accId,100);
//
//        accountService.transfer(accId,acc1Id, 200);
//
//        accountService.printTransactions(accId);
//        accountService.printTransactions(acc1Id);
//
//
//
//        System.out.println(accounts);
        Scanner sc=new Scanner(System.in);
        int choice;
        while(true){
            System.out.println("1.Create Account:");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Transfer");
            System.out.println("5. Exit");
            System.out.println("Enter your choice: ");
            choice=sc.nextInt();

            switch(choice){
                case 1:
                    Account account=new Account();
                    sc.nextLine();
                    System.out.println("Enter Account number: ");
                    String acc_num=sc.nextLine();
                    account.setAcc_num(acc_num);

                    System.out.println("Enter name: ");
                    String name=sc.nextLine();
                    account.setName(name);

                    System.out.print("Enter City: ");
                    String city = sc.nextLine();
                    account.setCity(city);

                    System.out.print("Enter Phone: ");
                    String phone = sc.nextLine();
                    account.setPhone(phone);

                    System.out.print("Enter Email: ");
                    String email = sc.nextLine();
                    account.setEmail(email);

                    System.out.print("Balance: ");
                    double balance = sc.nextDouble();
                    account.setBalance(balance);

                    sc.nextLine();
                    accountService.createAccount(account);

                    break;
                case 2:
                    System.out.print("Account Number: ");
                    Long dAcc_num = sc.nextLong();
                    System.out.print("Amount: ");
                    double dAmount = sc.nextDouble();
                    accountService.deposit(dAcc_num, dAmount);
                    break;
                case 3:
                    System.out.print("Account Number: ");
                    Long wAcc_num = sc.nextLong();
                    System.out.print("Amount: ");
                    double wAmount = sc.nextDouble();

                    accountService.withdraw(wAcc_num, wAmount);
                    break;
                case 4:
                    System.out.print("From Account: ");
                    Long fromAcc_num= sc.nextLong();
                    System.out.print("To Account: ");
                    Long toAcc_num= sc.nextLong();
                    System.out.print("Amount: ");
                    double amount = sc.nextDouble();

                    accountService.transfer(fromAcc_num, toAcc_num, amount);
                    break;

                case 5:
                    System.exit(0);

            }
        }

    }

    }

