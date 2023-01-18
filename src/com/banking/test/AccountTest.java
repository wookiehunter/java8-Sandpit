package com.banking.test;

import com.banking.account.Account;
import com.banking.account.IDs;

import java.io.IOException;

public class AccountTest {
    public static void main(String[] args) throws IOException {
//        Account acct1 = new Account("AB123", 1000, "Steven Godson");
        String ID1 = "XYZ-123";
        double balance1 = 1000;
        String user1 = "Steven Godson";

        String ID2 = "XYZ-456";
        double balance2 = 1234;
        String user2 = "Steven Godson";
        Account acct1 = new Account(balance1, user1);
        acct1.setOverdraft(true, 1234);
        acct1.transaction('w', 1500);
        acct1.readData();
        IDs.getIDs();
    }

//    private static void createAccount(String ID, double balance, String name) throws IOException {
//        Account acct = new Account(ID, balance, name);
//        printDetails(acct);
//        acct.getTransactionHistory();
//        acct.setOverdraft(false, 0.00);
//        printDetails(acct);
//    }

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
