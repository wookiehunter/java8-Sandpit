package com.banking.test;

import com.banking.account.Account;

public class AccountTest {
    public static void main(String[] args) {
        Account acct1 = new Account("AB123", 1000.10, "Steven Godson");
//        acct1.getTransactionHistory();
        acct1.setOverdraft(true, 1500.00);
        printDetails(acct1);

        depositTest(acct1);
        withdrawalTest(acct1);

        acct1.lockAccount();
        printDetails(acct1);
        acct1.unlockAccount();
        printDetails(acct1);

        acct1.getTransactionHistory();
    }

    private static void createAccount() {

    }

    private static void depositTest(Account acct1) {
        System.out.println("Deposit test start");
        acct1.transaction('d', 250);
//        acct1.getTransactionHistory();
        System.out.println("Deposit test finish");
    }

    private static void withdrawalTest(Account acct1) {
        System.out.println("Withdrawal test start");
        acct1.transaction('w', 1350.1);
//        acct1.getTransactionHistory();
        System.out.println("Withdrawal test finish");
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
