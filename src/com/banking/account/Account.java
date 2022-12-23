package com.banking.account;

import java.io.*;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;

public class Account {
    private static String id;
    private static double balance;
    private static String name;
    private static boolean lock;
    private static boolean overdraft;
    private static double overdraftLimit;
    static ArrayList<String> transactionHistory = new ArrayList<>();
    private static String filename = "";

    public Account(String id, double balance, String name) throws IOException {
        Account.id = id;
        Account.balance = balance;
        Account.name = name;
        Account.lock = false;
        Account.overdraft = false;
        Account.overdraftLimit = 0.0d;
        Account.filename = id + ".txt";
        transactionHistory.add("Account_ID: " + id);
        transactionHistory.add("Account_Owner: " + name);
        transactionHistory.add("Opening_Balance: " + numberFormatter(balance));
        writeData(transactionHistory);
    }
    public static void main(String[] args) {
    }
    // Need to format the outputs to show negative values
    public static void transaction(char type, double transactionAmount) throws IOException {
        if (!lock) {
            if(type == 'd') {
                balance += transactionAmount;
                transactionHistory.add("Deposit: " + transactionAmount);
                transactionHistory.add("Balance: " + numberFormatter(balance));
                writeData(transactionHistory);
                System.out.println("Deposit successful.");
            } else if (type == 'w') {
                if(overdraft && (balance - transactionAmount) >= (0 - overdraftLimit)) {
                    balance -= transactionAmount;
                    transactionHistory.add("Withdrawal: " + transactionAmount);
                    transactionHistory.add("Balance: " + numberFormatter(balance));
                    writeData(transactionHistory);
                    System.out.println("Withdrawal successful.");
                } else {
                    System.out.println("Withdrawal failed. " +
                            "\nYou do not have sufficient overdraft facilities available. " +
                            "\nSpeak with your local Branch to arrange this.");
                }
            } else {
                System.out.println("Invalid Transaction Code. Use d or w.");
            }
        } else {
            System.out.println("Account is locked. Contact Head Office.");
        }
    }

    private String balanceEnquiry() {
        if(!lock) {
            return numberFormatter(balance);
        } else {
            System.out.println("Account is locked. Contact Head Office.");
        }
        return null;
    }

    private String overdraftEnquiry() {
        if(!lock) {
            return numberFormatter(overdraftLimit);
        } else {
            System.out.println("Account is locked. Contact Head Office.");
        }
        return null;
    }

    public void lockAccount() throws IOException {
        lock = true;
        transactionHistory.add("Account Locked");
        writeData(transactionHistory);
    }

    public void unlockAccount() throws IOException {
        lock = false;
        transactionHistory.add("Account Unlocked");
        writeData(transactionHistory);
    }

    public void setOverdraft(boolean flag, double limit) throws IOException {
        if(!lock) {
            if(flag) {
                overdraft = true;
                overdraftLimit = limit;
                transactionHistory.add("OD_Limit: " + numberFormatter(limit));
                writeData(transactionHistory);
            } else {
                overdraft = false;
                overdraftLimit = 0.0d;
                transactionHistory.add("OD_Limit: 0.00");
                writeData(transactionHistory);
            }
        } else {
            System.out.println("Account is locked. Contact Head Office.");
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

    public static void getTransactionHistory() throws IOException {
        if(!lock) {
            readData();
        } else {
            System.out.println("Account is locked. Contact Head Office.");
        }
    }

    private static void writeData(ArrayList<String> data) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (String d:data) {
                writer.write(d);
                writer.newLine();
            }
        }
    }

    private static void readData() throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String inValue;
            while ((inValue = reader.readLine()) != null) {
                System.out.println(inValue);
            }
        }
    }

    private static String numberFormatter(Double value) {
        NumberFormat formatter = new DecimalFormat("#0.00");
        return formatter.format(value);
    }
}
