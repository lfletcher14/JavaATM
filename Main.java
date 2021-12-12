package com.company;

import java.sql.SQLOutput;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        users obj1 = new users();
        obj1.login();
    }
}

class users {
    /** Defines the login info for bank account */
    String customerName = "Matt Hardy";
    String customerPassword = "dog123";
    int customerID = 31022;

    void login () {
        /** Asking input from user to login to account */
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome! Enter your Customer ID.");
        int IDlogin = scanner.nextInt();
        System.out.println("Now enter your password.");
        Scanner scanner2 = new Scanner(System.in);
        String passwd = scanner2.nextLine();

        /** Checking to see if the username and password are correct */
        if (IDlogin == customerID  && passwd.equals(customerPassword)) {
            System.out.println("Welcome to your bank account " + customerName + "!");
            banking obj2 = new banking();
            obj2.giveOptions();
        } else {
            System.out.println("Your login information was incorrect. Please try again.");
        }
    }

}

class banking {
    /** Define variables we need */
    int balance;

    /** Define functions used to process bank statements */
    void deposit (int amount) {
        if (amount >= 0) {
            balance = balance + amount;
            System.out.println("You now have $" + balance + " in your account.");
        }
    }
    void withdraw (int amount) {
        if (amount >= 0) {
            balance = balance - amount;
            System.out.println("You now have $" + balance + " in your account.");
        } else if (amount > balance) {
            System.out.println("You cannot overdraft your account.");
        }
    }
    /** Provides an interface and simple instructions for the user */
    void giveOptions () {
        char option='\0';
        Scanner scanner = new Scanner(System.in);

        System.out.println("A. Check Balance");
        System.out.println("B. Deposit");
        System.out.println("C. Withdraw");
        System.out.println("D. Exit");

        do {
            System.out.println("-----------------------------------------------------------------");
            System.out.println("Enter an option");
            System.out.println("-----------------------------------------------------------------");
            option = scanner.next().charAt(0);
            System.out.println("\n");

            switch (option) {
                /** Lets user view balance */
                case 'A':
                    System.out.println("----------------------------------------------------------------");
                    System.out.println("Balance = " +balance);
                    System.out.println("----------------------------------------------------------------");
                    System.out.println("\n");
                    break;
                /** Lets user deposit money */
                case 'B':
                    System.out.println("----------------------------------------------------------------");
                    System.out.println("Enter an amount to deposit.");
                    System.out.println("----------------------------------------------------------------");
                    int depAmount = scanner.nextInt();
                    deposit(depAmount);
                    System.out.println("\n");
                    break;
                /** Lets user withdraw money */
                case 'C':
                    System.out.println("----------------------------------------------------------------");
                    System.out.println("Enter an amount to withdraw.");
                    System.out.println("----------------------------------------------------------------");
                    int withAmount = scanner.nextInt();
                    withdraw(withAmount);
                    System.out.println("\n");
                    break;
                /** Allows user to log out */
                case 'D':
                    System.out.println("====================");
                    System.out.println("Goodbye!");
                    System.out.println("====================");

                default:
                    System.out.println("Invalid option! Please enter another letter.");
            }
        } while (option != 'D');
        System.out.println("Have a great day!");
    }
}