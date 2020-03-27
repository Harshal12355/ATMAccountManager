package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        double checkingBalance = 0; // checking account balance
        double savingBalance = 0; // saving account balance

        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to Barclays");
        System.out.println();

        System.out.println("Choose option (choose number): " +
                "\n1. Checking Account" +
                "\n2. Savings Account" +
                "\n3. Exit");

        System.out.println();

        int option = scanner.nextInt();

        switch(option){ // executes accordingly to user input
            case 1:
                checking(checkingBalance);
                break;
            case 2:
                saving(savingBalance);
                break;
            case 3:
                break;
        }
    }

    // this is a method that will execute the command of whatever the needs of the user are accordingly using a switch case
    public static void checking(double balance){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose option (choose number): " +
                "\n1. View Balance" +
                "\n2. Withdraw Funds" +
                "\n3. Deposit Funds" +
                "\n4. Exit");
        System.out.println();
        int option = scanner.nextInt();

        switch(option){
            case 1:
                balanceChecking(balance);
                break;
            case 2:
                System.out.println("Please enter amount you want to withdraw");
                double withdrawAmount = scanner.nextInt();
                if (withdrawAmount > balance){
                    System.out.println("You do not have the required amount of cash to withdraw the amount you have asked for");
                    break;
                } else {
                    withdrawChecking(withdrawAmount, balance);
                }
                break;
            case 3:
                System.out.println("Please enter amount you want to deposit");
                double depositAmount = scanner.nextInt();
                depositChecking(depositAmount, balance);
                break;
            case 4:
                break;
        }
    }

    // this should print the current balance onto the screen (not working)
    public static void balanceChecking(double checkingBalance){
        try {
            File myObj = new File("checking.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                System.out.println(data);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        System.out.println("$"+checkingBalance);
    }

    // this should withdraw and take away the cash from the balance amount
    public static void withdrawChecking(double amount, double checkingBalance){
        checkingBalance = checkingBalance - amount;
        try {
            FileWriter myWriter = new FileWriter("checking.txt");
            myWriter.write((int) checkingBalance);
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        System.out.println("$"+checkingBalance);
    }

    // this should deposit and add the amount to the balance to the account
    public static void depositChecking(double amount, double checkBalance){
        checkBalance = checkBalance + amount;
        try {
            FileWriter myWriter = new FileWriter("checking.txt");
            myWriter.write((int) checkBalance);
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        System.out.println("$"+checkBalance);
    }


    // The same procedure as above but for the saving account

    public static void saving(double balance){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose option (choose number): " +
                "\n1. View Balance" +
                "\n2. Withdraw Funds" +
                "\n3. Deposit Funds" +
                "\n4. Exit");
        System.out.println();
        int option = scanner.nextInt();

        switch(option){
            case 1:
                balanceSaving(balance);
                break;
            case 2:
                System.out.println("Please enter amount you want to withdraw");
                double withdrawAmount = scanner.nextInt();
                if (withdrawAmount > balance){
                    System.out.println("You do not have the required amount of cash to withdraw the amount you have asked for");
                    break;
                } else {
                    withdrawSaving(withdrawAmount, balance);
                }
                break;
            case 3:
                System.out.println("Please enter amount you want to deposit");
                double depositAmount = scanner.nextInt();
                depositSaving(depositAmount, balance);
                break;
            case 4:
                break;
        }
    }


    public static void balanceSaving(double savingBalance){
        try {
            File myObj = new File("savings.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                System.out.println(data);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        System.out.println("$"+savingBalance);
    }

    public static void withdrawSaving(double amount, double savingBalance){
        savingBalance = savingBalance - amount;
        try {
            FileWriter myWriter = new FileWriter("savings.txt");
            myWriter.write((int) savingBalance);
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        System.out.println("$"+savingBalance);
    }

    public static void depositSaving(double amount, double savingBalance){
        savingBalance = savingBalance + amount;
        try {
            FileWriter myWriter = new FileWriter("savings.txt");
            myWriter.write((int) savingBalance);
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        System.out.println("$"+savingBalance);
    }

}
