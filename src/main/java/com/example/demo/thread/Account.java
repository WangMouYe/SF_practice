package com.example.demo.thread;

public class Account {
   private int balance;
   void transfer(Account target,int amt){
       synchronized (Account.class){
           if (this.balance > amt){
               this.balance -= amt;
               target.balance += amt;
           }
       }
   }
}
