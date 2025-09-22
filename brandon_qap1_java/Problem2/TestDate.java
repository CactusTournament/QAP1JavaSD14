package Problem2;

public class TestDate {
    public static void main(String[] args) {
        System.out.println("Testing Date Class");

        // Create a valid date
        try {
            Date validDate = new Date(15, 8, 2025);
            System.out.println("Created valid date: " + validDate);
        } catch (IllegalArgumentException e) {
            System.out.println("Error creating valid date: " + e.getMessage());
        }

        // Attempt to create an invalid date
        try {
            Date invalidDate = new Date(31, 4, 2025); // April has 30 days
            System.out.println("Created invalid date: " + invalidDate); // Won't run
        } catch (IllegalArgumentException e) {
            System.out.println("Caught invalid date: " + e.getMessage());
        }
    }
}
