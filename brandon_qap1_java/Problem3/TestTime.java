package Problem3;

public class TestTime {

    // Main method: entry point of the program
    public static void main(String[] args) {
        System.out.println("Testing Time class");

        // Create two standard time objects
        Time t1 = new Time(21, 10, 15);
        Time t2 = new Time(10, 20, 25);

        // Print initial values
        System.out.println("Before changes:");
        System.out.println("t1 = " + t1);
        System.out.println("t2 = " + t2);

        // Apply nextSecond and previousSecond
        t1.nextSecond();
        t2.previousSecond();

        // Print values after modifications
        System.out.println("\nAfter changes:");
        System.out.println("t1 = " + t1);
        System.out.println("t2 = " + t2);

        // Edge case tests
        Time t3 = new Time(23, 59, 59);
        Time t4 = new Time(0, 0, 0);

        System.out.println("\nEdge case tests:");

        // Test rollover at midnight
        System.out.println("t3 before nextSecond: " + t3);
        t3.nextSecond();
        System.out.println("t3 after nextSecond:  " + t3); // Should roll over to 00:00:00

        // Test rollback before midnight
        System.out.println("t4 before previousSecond: " + t4);
        t4.previousSecond();
        System.out.println("t4 after previousSecond:  " + t4); // Should roll back to 23:59:59
    }
}
