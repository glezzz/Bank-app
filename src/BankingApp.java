
import java.util.Scanner;

public class BankingApp {
    public static void main(String[] args) {

    BankAccount person = new BankAccount("Alejandro", "007");
    person.showMenu();
    }
}

class BankAccount {
    int balance;
    int previousTransaction;
    String customerName;
    String customerId;

    BankAccount(String cName, String cId) {
        customerName = cName;
        customerId = cId;
    }

    void deposit(int amount) {
        if (amount != 0) {
            balance = balance + amount;
            previousTransaction = amount;
        }
    }

    void withdraw(int amount) {
        if (amount != 0) {
            balance = balance - amount;
            //Add negative sign to show that money was subtracted from balance
            previousTransaction = -amount;
        }
    }

    void getPreviousTransaction() {
        if (previousTransaction > 0) {
            System.out.println("Deposited: " + previousTransaction);

        } else if (previousTransaction < 0) {
            System.out.println("Withdrawn: " + Math.abs(previousTransaction));

        } else {
            System.out.println("No transaction occurred");
        }
    }

    void showMenu() {
        char option;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome " + customerName);
        System.out.println("Your ID is " + customerId);
        System.out.println("\n");
        System.out.println("a. Check balance");
        System.out.println("b. Deposit");
        System.out.println("c. Withdraw");
        System.out.println("d. Previous transaction");
        System.out.println("e. Exit");

        do {
            System.out.println("==============================================================================");
            System.out.println("Enter an option");
            System.out.println("==============================================================================");
            option = scanner.next().charAt(0);
            System.out.println("\n");

            switch (option) {
                case 'a':
                    System.out.println("---------------------------");
                    System.out.println("Balance = " + balance);
                    System.out.println("---------------------------");
                    System.out.println("\n");
                    break;

                case 'b':
                    System.out.println("---------------------------");
                    System.out.println("Enter an amount to deposit");
                    System.out.println("---------------------------");
                    int amount = scanner.nextInt();
                    deposit(amount);
                    System.out.println("\n");
                    break;

                case 'c':
                    System.out.println("---------------------------");
                    System.out.println("Enter an amount to withdraw");
                    System.out.println("---------------------------");
                    int amount2 = scanner.nextInt();
                    withdraw(amount2);
                    System.out.println("\n");
                    break;

                case 'd':
                    System.out.println("---------------------------");
                    getPreviousTransaction();
                    System.out.println("---------------------------");
                    System.out.println("\n");
                    break;

                case 'e':
                    System.out.println("************************************");
                    break;

                default:
                    System.out.println("Invalid option! Please, enter again");
            }

        } while (option != 'e');

        System.out.println("Thank you dor using our services");
    }
}