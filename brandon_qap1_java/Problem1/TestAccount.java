package Problem1;

public class TestAccount {

    // Default constructor (not used in this case)
    public TestAccount() {
    }

    // Main method: entry point of the program
    public static void main(String[] var0) {
        // Create two accounts with initial balances
        Account var1 = new Account("A101", "Alice", 5000.0);
        Account var2 = new Account("A102", "Bob", 4000.0);

        // Print initial balances
        System.out.println("Initial Balances:");
        System.out.printf("%s: $%.2f%n", var1.getName(), var1.getBalance());
        System.out.printf("%s: $%.2f%n", var2.getName(), var2.getBalance());

        // Transfer $1000 from Alice to Bob
        var1.transferTo(var2, 1000);

        // Print balances after transfer
        System.out.println("\nBalances After Transfer of $1000 from Alice to Bob:");
        System.out.printf("%s: $%.2f%n", var1.getName(), var1.getBalance());
        System.out.printf("%s: $%.2f%n", var2.getName(), var2.getBalance());
    }
}
