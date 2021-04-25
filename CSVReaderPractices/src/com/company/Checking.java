package com.company;

public class Checking extends Account{
    //List properties specific to a Checking account
    private int debitCardNumber;
    private int debitCardPin;

    //Constructor to initialize checking account properties
    public Checking(String name, String socialSecNumber, double initDeposit){
        super(name, socialSecNumber,initDeposit);
        accountNumber = "2" + accountNumber;
        setDebitCard();
    }

    @Override
    public void setRate() {
       rate = getBaseRate() * .15;
    }

    private void setDebitCard() {
        debitCardNumber = (int) (Math.random() * Math.pow(10,12));
        debitCardPin= (int) (Math.random() * Math.pow(10,4));
    }

    //List any methods specific to the checking account
    public void showInfo(){
        super.showInfo();
        System.out.println("Account type: Checking"+
        "\n Debit Card Number: " + debitCardNumber +
        "\n Debit Card Pin " + debitCardPin);
    }

}