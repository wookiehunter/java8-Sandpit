package com.banking.account;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class IDs {
    private static List<String> IDList = new ArrayList<>();

    public static void collectIDs(String ID) throws IOException {
        IDList.add(ID);
        writeData(IDList);
    }

    private static void writeData(List<String> data) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("AccountIDs.txt"))) {
            for (String d:data) {
                writer.write(d);
                writer.newLine();
            }
        }
    }

    public static void getIDs() throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader("AccountIDs.txt"))) {
            String inValue;
            while ((inValue = reader.readLine()) != null) {
                System.out.println(inValue);
            }
        }
    }
}
