import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;

public class OptionMenu {
    Scanner input = new Scanner(System.in);
    HashMap<Integer, Account> data = new HashMap<>();

    public OptionMenu() {
        Account acc1 = new Account(12345, 1234, 1000.0, 5000.0);
        Account acc2 = new Account(54321, 4321, 2000.0, 3000.0);
        data.put(acc1.getCustomerNumber(), acc1);
        data.put(acc2.getCustomerNumber(), acc2);
    }

    public void getLogin() {
        int customerNumber = 0;
        int pinNumber = 0;

        while (true) {
            try {
                System.out.println("Welcome to the ATM!");
                System.out.print("Enter your customer number: ");
                customerNumber = input.nextInt();
                System.out.print("Enter your PIN: ");
                pinNumber = input.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Only numbers are allowed.");
                input.nextLine();
                continue;
            }

            Account acc = data.get(customerNumber);
            if (acc != null && acc.getPinNumber() == pinNumber) {
                getAccountType(acc);
                break;
            } else {
                System.out.println("Incorrect customer number or PIN.");
            }
        }
    }

    public void getAccountType(Account acc) {
        boolean quit = false;
        while (!quit) {
            System.out.println("\nSelect Account Type:");
            System.out.println("1 - Checking Account");
            System.out.println("2 - Saving Account");
            System.out.println("3 - Exit");

            int choice = input.nextInt();

            switch (choice) {
                case 1:
                    getChecking(acc);
                    break;
                case 2:
                    getSaving(acc);
                    break;
                case 3:
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    quit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    public void getChecking(Account acc) {
        boolean end = false;
        while (!end) {
            System.out.println("\nChecking Account Options:");
            System.out.println("1 - View Balance");
            System.out.println("2 - Withdraw");
            System.out.println("3 - Deposit");
            System.out.println("4 - Transfer to Saving");
            System.out.println("5 - Exit");

            int choice = input.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Checking Balance: ₹" + acc.getCheckingBalance());
                    break;
                case 2:
                    acc.getCheckingWithdrawInput();
                    break;
                case 3:
                    acc.getCheckingDepositInput();
                    break;
                case 4:
                    acc.getTransferInput("Checking");
                    break;
                case 5:
                    end = true;
                    break;
                default:
                    System.out.println("Invalid option.");
            }
        }
    }

    public void getSaving(Account acc) {
        boolean end = false;
        while (!end) {
            System.out.println("\nSaving Account Options:");
            System.out.println("1 - View Balance");
            System.out.println("2 - Withdraw");
            System.out.println("3 - Deposit");
            System.out.println("4 - Transfer to Checking");
            System.out.println("5 - Exit");

            int choice = input.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Saving Balance: ₹" + acc.getSavingBalance());
                    break;
                case 2:
                    acc.getSavingWithdrawInput();
                    break;
                case 3:
                    acc.getSavingDepositInput();
                    break;
                case 4:
                    acc.getTransferInput("Savings");
                    break;
                case 5:
                    end = true;
                    break;
                default:
                    System.out.println("Invalid option.");
            }
        }
    }
}
