package Problem1;

import java.util.regex.Pattern;

public class Account {
    // Pattern for validating account IDs: must start with 'A' followed by 3 digits (e.g., A101)
    private static final Pattern ID_PATTERN = Pattern.compile("^A\\d{3}$");

    // Instance variables
    String ID;
    String name;
    double balance = 0.0;

    // Constructor: initializes account with ID and name
    public Account(String var1, String var2) {
        if (!ID_PATTERN.matcher(var1).matches()) {
            throw new IllegalArgumentException("Invalid ID format. Expected: A followed by 3 digits (e.g., A101).");
        } else {
            this.ID = var1;
            this.name = var2;
        }
    }

    // Constructor: initializes account with ID, name, and balance
    public Account(String var1, String var2, double var3) {
        if (!ID_PATTERN.matcher(var1).matches()) {
            throw new IllegalArgumentException("Invalid ID format. Expected: A followed by 3 digits (e.g., A101).");
        } else if (var3 < 0.0) {
            throw new IllegalArgumentException("Balance cannot be negative.");
        } else {
            this.ID = var1;
            this.name = var2;
            this.balance = var3;
        }
    }

    // Getters
    public String getID() { return this.ID; }
    public String getName() { return this.name; }
    public double getBalance() { return this.balance; }

    // Sets the account holder's name (must be 2–30 letters/spaces only)
    public void setName(String var1) {
        if (var1 != null && var1.matches("^[A-Za-z ]{2,30}$")) {
            this.name = var1;
        } else {
            throw new IllegalArgumentException("Invalid name. Only letters and spaces allowed, length 2-30.");
        }
    }

    // Sets the account balance (cannot be negative)
    public void setBalance(double var1) {
        if (var1 < 0.0) {
            throw new IllegalArgumentException("Balance cannot be negative.");
        } else {
            this.balance = var1;
        }
    }

    // Credits (adds) money to the account
    public double credit(int var1) {
        if (this.balance < 0.0) {
            throw new IllegalArgumentException("Balance cannot be negative.");
        } else {
            this.balance += (double)var1;
            return this.balance;
        }
    }

    // Debits (subtracts) money from the account if sufficient balance exists
    public double debit(int var1) {
        if (var1 <= 0) {
            throw new IllegalArgumentException("Debit amount must be positive.");
        } else {
            if ((double)var1 <= this.balance) {
                this.balance -= (double)var1;
            } else {
                System.out.println("Amount exceeded balance.");
            }
            return this.balance;
        }
    }

    // Transfers money to another account if sufficient balance exists
    public double transferTo(Account var1, int var2) {
        if (var2 <= 0) {
            throw new IllegalArgumentException("Transfer amount must be positive.");
        } else {
            if ((double)var2 <= this.balance) {
                this.balance -= (double)var2;
                var1.credit(var2);
            } else {
                System.out.println("Amount exceeded balance.");
            }
            return this.balance;
        }
    }

    // Formatted string output
    public String toString() {
        return "Account[id=" + this.ID + ",name=" + this.name + ",balance=" + this.balance + "]";
    }
}
