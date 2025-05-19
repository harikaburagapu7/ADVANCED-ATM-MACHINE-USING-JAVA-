import java.text.DecimalFormat;
import java.util.Scanner;

public class Account {
    private int customerNumber;
    private int pinNumber;
    private double checkingBalance = 0.0;
    private double savingBalance = 0.0;
    Scanner input = new Scanner(System.in);
    DecimalFormat moneyFormat = new DecimalFormat("'₹'###,##0.00");

    public Account() {}

    public Account(int customerNumber, int pinNumber, double checkingBalance, double savingBalance) {
        this.customerNumber = customerNumber;
        this.pinNumber = pinNumber;
        this.checkingBalance = checkingBalance;
        this.savingBalance = savingBalance;
    }

    // Getters and setters
    public int getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerNumber(int customerNumber) {
        this.customerNumber = customerNumber;
    }

    public int getPinNumber() {
        return pinNumber;
    }

    public void setPinNumber(int pinNumber) {
        this.pinNumber = pinNumber;
    }

    public double getCheckingBalance() {
        return checkingBalance;
    }

    public double getSavingBalance() {
        return savingBalance;
    }

    // Deposit and Withdraw for Checking
    public void getCheckingWithdrawInput() {
        System.out.println("Current Checking Balance: " + moneyFormat.format(checkingBalance));
        System.out.print("Enter amount to withdraw: ");
        double amount = input.nextDouble();

        if (amount <= checkingBalance) {
            checkingBalance -= amount;
            System.out.println("New Checking Balance: " + moneyFormat.format(checkingBalance));
        } else {
            System.out.println("Insufficient Balance.");
        }
    }

    public void getCheckingDepositInput() {
        System.out.println("Current Checking Balance: " + moneyFormat.format(checkingBalance));
        System.out.print("Enter amount to deposit: ");
        double amount = input.nextDouble();
        checkingBalance += amount;
        System.out.println("New Checking Balance: " + moneyFormat.format(checkingBalance));
    }

    // Deposit and Withdraw for Saving
    public void getSavingWithdrawInput() {
        System.out.println("Current Saving Balance: " + moneyFormat.format(savingBalance));
        System.out.print("Enter amount to withdraw: ");
        double amount = input.nextDouble();

        if (amount <= savingBalance) {
            savingBalance -= amount;
            System.out.println("New Saving Balance: " + moneyFormat.format(savingBalance));
        } else {
            System.out.println("Insufficient Balance.");
        }
    }

    public void getSavingDepositInput() {
        System.out.println("Current Saving Balance: " + moneyFormat.format(savingBalance));
        System.out.print("Enter amount to deposit: ");
        double amount = input.nextDouble();
        savingBalance += amount;
        System.out.println("New Saving Balance: " + moneyFormat.format(savingBalance));
    }

    // Transfer
    public void getTransferInput(String accountType) {
        System.out.print("Enter amount to transfer: ");
        double amount = input.nextDouble();

        if (accountType.equals("Checking")) {
            if (amount <= checkingBalance) {
                checkingBalance -= amount;
                savingBalance += amount;
                System.out.println("Transferred " + moneyFormat.format(amount) + " from Checking to Saving.");
            } else {
                System.out.println("Insufficient funds in Checking.");
            }
        } else if (accountType.equals("Savings")) {
            if (amount <= savingBalance) {
                savingBalance -= amount;
                checkingBalance += amount;
                System.out.println("Transferred " + moneyFormat.format(amount) + " from Saving to Checking.");
            } else {
                System.out.println("Insufficient funds in Saving.");
            }
        }
    }
}
