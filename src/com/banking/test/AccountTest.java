package com.banking.test;

import com.banking.account.Account;

import java.util.Arrays;
import java.util.Formatter;

public class AccountTest {
    public static void main(String[] args) {
//        createAccount();
        lockTest();
//        depositTest();
//        withdrawalTest();
    }

    private static void createAccount() {
        System.out.println("Account create start");
        Account acct1 = new Account("AB123", 1000.10, "Steven Godson");
        acct1.setOverdraft(true, 1500.00);
        printDetails(acct1);
        System.out.println("Account create finish");
    }

    private static void lockTest() {
        System.out.println("Lock test start");
        Account acct1 = new Account("AB123", 1000.10, "Steven Godson");
        acct1.lockAccount();
        // should return null and nothing gets printed
        printDetails(acct1);
        System.out.println("Lock test finish");
    }

    private static void depositTest() {
        System.out.println("Deposit test start");
        Account acct1 = new Account("AB123", 1000.10, "Steven Godson");
        printDetails(acct1);
        acct1.transaction('d', 999.99);
        printDetails(acct1);
        System.out.println("Deposit test finish");
    }

    private static void withdrawalTest() {
        System.out.println("Withdrawal test start");
        Account acct1 = new Account("AB123", 1000.10, "Steven Godson");
        acct1.setOverdraft(true, 150.00);
        printDetails(acct1);
        acct1.transaction('w', 1100);
        printDetails(acct1);
        System.out.println("Withdrawal test finish");
    }

    private static void printDetails(Account account) {
        String[] details = account.getAcctDetails();
        if (details != null) {
            System.out.println("Your new account details are... ID: " + details[0]
                    + ", Available Balance: " + details[1]
                    + ", Overdraft Facility: " + details[3]
                    + " and Customer: " + details[2]
                    + ".");
        }
    }
}
