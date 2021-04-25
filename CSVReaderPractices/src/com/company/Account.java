package com.company;

public abstract class Account implements IBaseRate {
//List common properties for savings and checking accounts
    private String name;
    private String socialSecNumber;
    private double balance;

    static int index = 10000;
    protected String accountNumber;
    protected double rate;


    //Constructor to set base properties and initialize the account
    public Account(String name,String socialSecNumber, double initDeposit){
        index++;
        this.name = name;
        this.socialSecNumber = socialSecNumber;
        this.balance = initDeposit;
        this.accountNumber = setAccountNumber();
        setRate();
    }

    public abstract void setRate();

    private String setAccountNumber(){
        String lastTwoOfSSN = socialSecNumber.substring(socialSecNumber.length() - 2, socialSecNumber.length());
        int uniqueID = index;
        int randomNumber =(int) (Math.random() * Math.pow(10,3));
        return lastTwoOfSSN + uniqueID + randomNumber;
    }



    public void compound(){
        double accruedInterest = balance * (rate/100);
        balance = balance + accruedInterest;
        System.out.println("Accrued Interest: $" + accruedInterest);
        printBalance();
    }
    //List common methods - transactions
    public void deposit(double amount){
        balance = balance + amount;
        System.out.println("Depositing $" + amount);
        printBalance();
    }

    public void withdraw(double amount){
        balance = balance - amount;
        System.out.println("Withdrawing $" + amount);
        printBalance();
    }

    public void transfer(String toWhere, double amount){
        balance = balance - amount;
        System.out.println("Transfering $" + amount + " to " + toWhere);
        printBalance();
    }

    public void printBalance(){
        System.out.println("Your balance is now: $" + balance);
    }

    public void showInfo(){
        System.out.println(
                "Name: " + name +
                        "\nAccount number: " + accountNumber +
                        "\nBalance: " + balance +
                        "\nRate: " + rate + "%"
        );
    }


    }
