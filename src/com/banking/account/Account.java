package com.banking.account;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Account {
    private static String id;
    private static double balance;
    private static String name;
    private static boolean lock;
    private static boolean overdraft;
    private static double overdraftLimit;
    static ArrayList<String> transactionHistory = new ArrayList<>();

    public Account(String id, double balance, String name) {
        Account.id = id;
        Account.balance = balance;
        Account.name = name;
        Account.lock = false;
        Account.overdraft = false;
        Account.overdraftLimit = 0.0d;
        transactionHistory.add("Account_ID: " + id);
        transactionHistory.add("Account_Owner: " + name);
        transactionHistory.add("Opening_Balance: " + balance);
    }
    public static void main(String[] args) {
    }
    // Need to format the outputs to show negative values
    public static void transaction(char type, double transactionAmount) {
        if (!lock) {
            if(type == 'd') {
                balance += transactionAmount;
                transactionHistory.add("Deposit: " + transactionAmount);
                System.out.println("Deposit successful.");
            } else if (type == 'w') {
                if(overdraft && (balance - transactionAmount) >= (0 - overdraftLimit)) {
                    balance -= transactionAmount;
                    transactionHistory.add("Withdrawal: " + transactionAmount);
                    System.out.println("Withdrawal successful.");
                } else {
                    System.out.println("Withdrawal failed. " +
                            "\nYou do not have sufficient overdraft facilities available. " +
                            "\nSpeak with your local Branch to arrange this.");
                }
            }
        } else {
            System.out.println("Account is locked. Contact Head Office.");
        }
    }

    private String balanceEnquiry() {
        NumberFormat formatter = new DecimalFormat("#0.00");
        return formatter.format(balance);
    }

    private String overdraftEnquiry() {
        NumberFormat formatter = new DecimalFormat("#0.00");
        return formatter.format(overdraftLimit);
    }

    public void lockAccount() {
        lock = true;
    }

    public void unlockAccount() {
        lock = false;
    }

    public void setOverdraft(boolean flag, double limit) {
        if(flag) {
            overdraft = true;
            overdraftLimit = limit;
            transactionHistory.add("OD_Limit: " + limit);
        } else {
            overdraft = false;
            overdraftLimit = 0.0d;
            transactionHistory.add("OD_Limit: 0.00");
        }
    }

    public String[] getAcctDetails() {
        if(!lock) {
            String[] details = new String[5];
            details[0] = id;
            details[1] = balanceEnquiry();
            details[2] = name;
            details[3] = overdraftEnquiry();
            return details;
        } else {
            System.out.println("Account is locked. Contact Head Office.");
        }
        return null;
    }

    public static void getTransactionHistory() {
        for(String o:transactionHistory)
            System.out.println(o);
    }
}
