package org.example.spring_samples.entity;

import jakarta.persistence.*;

@Entity
@Table(name="transactions")
public class Transactions {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @ManyToOne
    private Account account;

//    @Column(name="fromacc_id")
//    private String fromacc;
//
//    @Column(name="toacc_id")
//    private String  toacc;
    @Column(name="amount")
    private double amount;

    @JoinColumn(name="type")
    private String type;

//    @Column(name="accountid")
//    public String account_id;
//

    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id=id;
    }

    public  Account getAccount() {
        return account;
    }
    public void setAccount(Account account){
        this.account = account;
    }

    public double getAmount(){
        return amount;
    }
    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getType(){
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }

//    public String getFromacc(){
//        return fromacc;
//    }
//    public void setFromacc(String fromacc){
//        this.fromacc=fromacc;
//    }
//
//    public String getToacc(){
//        return toacc;
//    }
//    public void setToacc(String toacc){
//        this.toacc=toacc;
//    }

//    public String getAccount_id(){
//        return account_id;
//    }
//    public void setAccount_id(String account_id) {
//        this.account_id = account_id;
//    }


}
