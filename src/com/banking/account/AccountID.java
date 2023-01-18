package com.banking.account;

import com.sun.xml.internal.bind.v2.model.core.ID;

import java.io.IOException;
import java.util.ArrayList;
import java.util.UUID;

public class AccountID {
    static ArrayList<String> accountIDs;
    static String ID;
    public AccountID() {}
    public static void main(String[] args){}

    public static String setID() throws IOException {
        String random = UUID.randomUUID().toString();
        IDs.collectIDs(random);
        ID = random;
        return ID;
    }
}
