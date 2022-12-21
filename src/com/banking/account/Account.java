package com.banking.account;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class Account {
    private static String id;
    private static double balance;
    private static String name;
    private static boolean lock;
    private static boolean overdraft;
    private static double overdraftLimit;
    public Account(String id, double balance, String name) {
        Account.id = id;
        Account.balance = balance;
        Account.name = name;
        Account.lock = false;
        Account.overdraft = false;
        Account.overdraftLimit = 0.0d;
    }
    public static void main(String[] args) {
    }
    // Need to format the outputs to show negative values
    public static void transaction(char type, double transactionAmount) {
        if (lock == false) {
            if(type == 'd') {
                balance += transactionAmount;
                System.out.println("Deposit successful.");
            } else if (type == 'w') {
                if(((balance) - transactionAmount) > (0 - overdraftLimit)) {
                    balance -= transactionAmount;
                    System.out.println("Withdrawal successful.");
                } else {
                    System.out.println("Transaction failed as would take you overdrawn!");
                }
            }
        } else {
            System.out.println("Account is locked. Contact Head Office.");
        }
    }

    public String balanceEnquiry() {
        NumberFormat formatter = new DecimalFormat("#0.00");
        return formatter.format(balance + overdraftLimit);
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
        } else if (!flag) {
            overdraft = false;
            overdraftLimit = 0.0d;

        }
    }

    public String[] getAcctDetails() {
        if(!lock) {
            String[] details = new String[5];
            details[0] = id;
            details[1] = balanceEnquiry();
            details[2] = name;
            return details;
        } else if(lock) {
            System.out.println("Account is locked. Contact Head Office.");
        }
        return null;
    }
}
