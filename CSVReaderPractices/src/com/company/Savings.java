package com.company;

public class Savings extends Account{
    //List properties specific to the Savings account
    private double safetyDepositBoxID;
    private int safetyDepositBoxKey;

    //Constructor to initialize settings for the Savings properties
    public Savings(String name, String socialSecNumber, double initDeposit){
        super(name, socialSecNumber, initDeposit);
        accountNumber = "1" + accountNumber;
        setSafetyDepositBox();
    }

    @Override
    public void setRate() {
        rate = getBaseRate() - .25;
    }

    private void setSafetyDepositBox(){
        safetyDepositBoxID = (int) (Math.random() * Math.pow(10,3));
        safetyDepositBoxKey = (int) (Math.random() * Math.pow(10,4));
    }



    //List any methods specific to savings account
    public void showInfo(){
        System.out.println("Account Type: Savings");
        super.showInfo();
        System.out.println(
                "Your Savings Account Features" +
                        "\n Safety Deposit Box ID: " + safetyDepositBoxID+
                        "\n Safety Deposit Box Key: " + safetyDepositBoxKey
        );
    }
}
