package com.company;

import java.util.LinkedList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Account> accounts = new LinkedList<Account>();

        //Read a CSV File then create new accounts based on that data
        String file = "C:\\Users\\bruger\\Desktop\\CSVReaderPrøve\\NewBankAccounts.csv";
        List<String[]> newAccountHolder = com.company.utilities.CSV.read(file);
        for(String[] accountHolder : newAccountHolder){
            String name = accountHolder[0];
            String ssN = accountHolder[1];
            String accountType = accountHolder[2];
            double initDeposit = Double.parseDouble(accountHolder[3]);
            if(accountType.equals("Savings")){
                accounts.add(new Savings(name,ssN, initDeposit));
            }
            else if(accountType.equals("Checking")) {
                accounts.add(new Checking(name,ssN, initDeposit));
            }
            else {
                System.out.println("Error reading account type");
            }
        }

        for (Account acc: accounts) {
            System.out.println("\n*************************");
            acc.showInfo();
        }
        
    }
}
