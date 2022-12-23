package com.banking.test;

import com.banking.account.Account;

import java.io.IOException;

public class AccountTest {
    public static void main(String[] args) throws IOException {
//        Account acct1 = new Account("AB123", 1000, "Steven Godson");
////        acct1.getTransactionHistory();
//        acct1.setOverdraft(true, 15000.00);
//        acct1.transaction('d', 1000);
//        acct1.transaction('w', 1);
//        acct1.transaction('w', 5000);
//        acct1.lockAccount();
//        printDetails(acct1);
//        acct1.getTransactionHistory();
//        acct1.transaction('d', 10000);
//        acct1.unlockAccount();
//        printDetails(acct1);
//        acct1.transaction('d', 2000);
//        acct1.getTransactionHistory();

        createAccount();
    }

    private static void createAccount() throws IOException {
        Account acct2 = new Account("AB321", 1000, "Steven Godson");
        printDetails(acct2);
        acct2.getTransactionHistory();
        acct2.setOverdraft(false, 0.00);
        printDetails(acct2);
    }

    private static void printDetails(Account account) {
        String[] details = account.getAcctDetails();
        if (details != null) {
            System.out.println("Your account details are... ID: " + details[0]
                    + ", \nAccount Balance: " + details[1]
                    + ", \nOverdraft Facility: " + details[3]
                    + " \nand Customer: " + details[2]
                    + ".");
        }
    }
}
