package bankmanagement;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<BankAccount> accounts = new ArrayList<>();

        while (true) {
            System.out.println("\n===== Bank Management System =====");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Check Balance (PIN required)");
            System.out.println("5. View All Accounts");
            System.out.println("6. Exit");

            System.out.print("Enter choice: ");

            if (!sc.hasNextInt()) {
                System.out.println("Invalid choice!");
                sc.next(); // clear invalid input
                continue;
            }

            int choice = sc.nextInt();

            switch (choice) {

                case 1: // Create Account
                    System.out.print("Enter 10-digit Account Number: ");
                    if (!sc.hasNextLong()) {
                        System.out.println("Invalid account number!");
                        sc.next();
                        break;
                    }

                    long accNo = sc.nextLong();

                    if (accNo < 1_000_000_000L || accNo > 9_999_999_999L) {
                        System.out.println("Account number must be 10 digits.");
                        break;
                    }

                    boolean exists = false;
                    for (BankAccount acc : accounts) {
                        if (acc.getAccountNumber() == accNo) {
                            exists = true;
                            break;
                        }
                    }

                    if (exists) {
                        System.out.println("Account already exists.");
                        break;
                    }

                    sc.nextLine(); // clear buffer
                    System.out.print("Enter Holder Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Initial Balance: ");
                    if (!sc.hasNextDouble()) {
                        System.out.println("Invalid balance!");
                        sc.next();
                        break;
                    }

                    double bal = sc.nextDouble();

                    if (bal < 0) {
                        System.out.println("Balance cannot be negative.");
                        break;
                    }

                    accounts.add(new BankAccount(accNo, name, bal));
                    System.out.println("Account created successfully!");
                    break;

                case 2: // Deposit
                    System.out.print("Enter Account Number: ");
                    if (!sc.hasNextLong()) {
                        System.out.println("Invalid account number!");
                        sc.next();
                        break;
                    }

                    long depAcc = sc.nextLong();
                    BankAccount depAccount = null;

                    for (BankAccount acc : accounts) {
                        if (acc.getAccountNumber() == depAcc) {
                            depAccount = acc;
                            break;
                        }
                    }

                    if (depAccount == null) {
                        System.out.println("Account not found!");
                        break;
                    }

                    System.out.print("Enter deposit amount: ");
                    if (!sc.hasNextDouble()) {
                        System.out.println("Invalid amount!");
                        sc.next();
                        break;
                    }

                    double depAmount = sc.nextDouble();

                    if (depAmount <= 0) {
                        System.out.println("Amount must be greater than 0.");
                        break;
                    }

                    depAccount.deposit(depAmount);
                    break;

                case 3: // Withdraw
                    System.out.print("Enter Account Number: ");
                    if (!sc.hasNextLong()) {
                        System.out.println("Invalid account number!");
                        sc.next();
                        break;
                    }

                    long wAcc = sc.nextLong();
                    BankAccount wAccount = null;

                    for (BankAccount acc : accounts) {
                        if (acc.getAccountNumber() == wAcc) {
                            wAccount = acc;
                            break;
                        }
                    }

                    if (wAccount == null) {
                        System.out.println("Account not found!");
                        break;
                    }

                    System.out.print("Enter withdraw amount: ");
                    if (!sc.hasNextDouble()) {
                        System.out.println("Invalid amount!");
                        sc.next();
                        break;
                    }

                    double wAmount = sc.nextDouble();

                    if (wAmount <= 0) {
                        System.out.println("Amount must be greater than 0.");
                        break;
                    }

                    wAccount.withdraw(wAmount);
                    break;

                case 4: // Check Balance
                    System.out.print("Enter Account Number: ");
                    if (!sc.hasNextLong()) {
                        System.out.println("Invalid account number!");
                        sc.next();
                        break;
                    }

                    long balAcc = sc.nextLong();
                    BankAccount balAccount = null;

                    for (BankAccount acc : accounts) {
                        if (acc.getAccountNumber() == balAcc) {
                            balAccount = acc;
                            break;
                        }
                    }

                    if (balAccount == null) {
                        System.out.println("Account not found!");
                        break;
                    }

                    System.out.print("Enter PIN: ");
                    if (!sc.hasNextInt()) {
                        System.out.println("Invalid PIN!");
                        sc.next();
                        break;
                    }

                    int enteredPin = sc.nextInt();

                    if (!balAccount.checkBalance(enteredPin)) { // returns false if PIN wrong
                        System.out.println("Incorrect PIN!");
                    }
                    break;

                case 5: // View All Accounts
                    if (accounts.isEmpty()) {
                        System.out.println("No accounts found.");
                    } else {
                        System.out.println("=== All Accounts ===");
                        for (BankAccount acc : accounts) {
                            acc.display(); // Assuming display() prints account info
                        }
                    }
                    break;

                case 6: // Exit
                    System.out.println("Exiting... Goodbye!");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
