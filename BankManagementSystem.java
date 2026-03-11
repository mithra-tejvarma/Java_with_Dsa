import java.util.*;

// BankAccount class represents a customer's bank account
class BankAccount {
    int accountNumber;
    String accountHolderName;
    double balance;

    // Constructor
    BankAccount(int accountNumber, String accountHolderName, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = balance;
    }

    // Deposit money
    void deposit(double amount) {
        balance += amount;
        System.out.println("₹" + amount + " deposited successfully.");
    }

    // Withdraw money
    void withdraw(double amount) {
        if (amount > balance) {
            System.out.println("Insufficient balance!");
        } else {
            balance -= amount;
            System.out.println("₹" + amount + " withdrawn successfully.");
        }
    }

    // Display account details
    void displayAccount() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder: " + accountHolderName);
        System.out.println("Balance: ₹" + balance);
    }
}

// Bank class manages all accounts
class Bank {

    HashMap<Integer, BankAccount> accounts = new HashMap<>();

    // Create account
    void createAccount(int accNo, String name, double initialBalance) {
        BankAccount account = new BankAccount(accNo, name, initialBalance);
        accounts.put(accNo, account);
        System.out.println("Account created successfully.");
    }

    // Deposit
    void depositMoney(int accNo, double amount) {
        BankAccount acc = accounts.get(accNo);

        if (acc != null) {
            acc.deposit(amount);
        } else {
            System.out.println("Account not found.");
        }
    }

    // Withdraw
    void withdrawMoney(int accNo, double amount) {
        BankAccount acc = accounts.get(accNo);

        if (acc != null) {
            acc.withdraw(amount);
        } else {
            System.out.println("Account not found.");
        }
    }

    // Transfer money
    void transferMoney(int fromAcc, int toAcc, double amount) {

        BankAccount sender = accounts.get(fromAcc);
        BankAccount receiver = accounts.get(toAcc);

        if (sender == null || receiver == null) {
            System.out.println("One of the accounts does not exist.");
            return;
        }

        if (sender.balance < amount) {
            System.out.println("Insufficient balance for transfer.");
            return;
        }

        sender.balance -= amount;
        receiver.balance += amount;

        System.out.println("₹" + amount + " transferred successfully.");
    }

    // Check balance
    void checkBalance(int accNo) {
        BankAccount acc = accounts.get(accNo);

        if (acc != null) {
            acc.displayAccount();
        } else {
            System.out.println("Account not found.");
        }
    }
}

public class BankManagementSystem {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Bank bank = new Bank();

        int choice;

        do {

            System.out.println("\n===== BANK MANAGEMENT SYSTEM =====");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Transfer Money");
            System.out.println("5. Check Balance");
            System.out.println("6. Exit");

            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter Account Number: ");
                    int accNo = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Account Holder Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Initial Balance: ");
                    double balance = sc.nextDouble();

                    bank.createAccount(accNo, name, balance);
                    break;

                case 2:
                    System.out.print("Enter Account Number: ");
                    int depAcc = sc.nextInt();

                    System.out.print("Enter Amount to Deposit: ");
                    double depAmt = sc.nextDouble();

                    bank.depositMoney(depAcc, depAmt);
                    break;

                case 3:
                    System.out.print("Enter Account Number: ");
                    int witAcc = sc.nextInt();

                    System.out.print("Enter Amount to Withdraw: ");
                    double witAmt = sc.nextDouble();

                    bank.withdrawMoney(witAcc, witAmt);
                    break;

                case 4:
                    System.out.print("Enter Sender Account Number: ");
                    int sender = sc.nextInt();

                    System.out.print("Enter Receiver Account Number: ");
                    int receiver = sc.nextInt();

                    System.out.print("Enter Amount to Transfer: ");
                    double amount = sc.nextDouble();

                    bank.transferMoney(sender, receiver, amount);
                    break;

                case 5:
                    System.out.print("Enter Account Number: ");
                    int checkAcc = sc.nextInt();

                    bank.checkBalance(checkAcc);
                    break;

                case 6:
                    System.out.println("Thank you for using the bank system.");
                    break;

                default:
                    System.out.println("Invalid choice.");

            }

        } while (choice != 6);

        sc.close();
    }
}