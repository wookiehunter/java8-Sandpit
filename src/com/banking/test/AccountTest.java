package com.banking.test;

import com.banking.account.Account;

import java.io.IOException;

public class AccountTest {
    public static void main(String[] args) throws IOException {
        Account acct1 = new Account("AB123", 1000, "Steven Godson");
//        acct1.getTransactionHistory();
        acct1.setOverdraft(true, 15000.00);
        acct1.transaction('d', 1000);
        acct1.transaction('w', 1);
        acct1.transaction('w', 5000);
        acct1.lockAccount();
        printDetails(acct1);
        acct1.getTransactionHistory();
        acct1.unlockAccount();
        printDetails(acct1);
        acct1.transaction('d', 2000);
        acct1.getTransactionHistory();
    }

    private static void createAccount() {

    }

    private static void printDetails(Account account) {
        String[] details = account.getAcctDetails();
        if (details != null) {
            System.out.println("Your account details are... ID: " + details[0]
                    + ", Account Balance: " + details[1]
                    + ", Overdraft Facility: " + details[3]
                    + " and Customer: " + details[2]
                    + ".");
        }
    }
}
