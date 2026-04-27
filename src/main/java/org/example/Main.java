package org.example;

import org.example.spring_samples.config.AppConfigDataJPA;
import org.example.spring_samples.entity.Account;
import org.example.spring_samples.service.AccountService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfigDataJPA.class);
        AccountService accountService = ctx.getBean(AccountService.class);

        Scanner sc=new Scanner(System.in);
        int choice;
        while(true){
            try{
                System.out.println("1.Create Account:");
                System.out.println("2. Deposit");
                System.out.println("3. Withdraw");
                System.out.println("4. Transfer");
                System.out.println("5. Exit");
                System.out.println("Enter your choice: ");
                choice=sc.nextInt();

                switch(choice) {
                    case 1:
                        Account account = new Account();
                        sc.nextLine();
                        System.out.println("Enter Account number: ");
                        String acc_num = sc.nextLine();
                        account.setAcc_num(acc_num);

                        System.out.println("Enter name: ");
                        String name = sc.nextLine();
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
                        System.out.println("Account id: ");
                        Long dAcc_id = sc.nextLong();
                        System.out.println("Amount: ");
                        double dAmount = sc.nextDouble();
                        accountService.deposit(dAcc_id, dAmount);
                        break;
                    case 3:
                        System.out.println("Account id: ");
                        Long wAcc_id = sc.nextLong();
                        System.out.println("Amount: ");
                        double wAmount = sc.nextDouble();

                        accountService.withdraw(wAcc_id, wAmount);
                        break;
                    case 4:
                        System.out.println("From Account id: ");
                        Long fromAcc = sc.nextLong();
                        System.out.println("To Account id: ");
                        Long toAcc = sc.nextLong();
                        System.out.println("Amount: ");
                        double amount = sc.nextDouble();

                        accountService.transfer(fromAcc, toAcc, amount);
                        break;

                    case 5:
                        System.exit(0);

                    default:
                        System.out.println("Invalid choice");
                }
            } catch(IllegalArgumentException e){
                System.out.println(e.getMessage());

            }

        }

    }

    }

