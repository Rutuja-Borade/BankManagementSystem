package bankmanagement;

public class BankAccount {

    private long accNo;
    private String name;
    private double balance;
    private int pin;

    // ✅ Constructor (fixes line 80 error)
    public BankAccount(long accNo, String name, double balance) {
        this.accNo = accNo;
        this.name = name;
        this.balance = balance;
        this.pin = 1234; // default PIN
    }

    public long getAccountNumber() {
        return accNo;
    }

    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposit successful. Current balance: " + balance);
    }

    public void withdraw(double amount) {
        if (amount > balance) {
            System.out.println("Insufficient balance!");
        } else {
            balance -= amount;
            System.out.println("Withdrawal successful. Current balance: " + balance);
        }
    }

    // ✅ Fixes line 196 error
    public boolean checkBalance(int enteredPin) {
        if (enteredPin == pin) {
            System.out.println("Current Balance: " + balance);
            return true;
        }
        return false;
    }

    public void display() {
        System.out.println("Account No: " + accNo +
                           ", Name: " + name +
                           ", Balance: " + balance);
    }
}
