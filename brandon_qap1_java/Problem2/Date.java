package Problem2;

public class Date {
    private int day;
    private int month;
    private int year;

    // Constructor
    public Date(int day, int month, int year) {
        setYear(year);
        setMonth(month);
        setDay(day); // Day validation depends on month and year
    }

    // Getters
    public int getDay() { return day; }
    public int getMonth() { return month; }
    public int getYear() { return year; }

    // Setters
    public void setYear(int year) {
        if (year < 1900 || year > 9999) {
            throw new IllegalArgumentException("Year must be between 1900 and 9999.");
        }
        this.year = year;
    }

    public void setMonth(int month) {
        if (month < 1 || month > 12) {
            throw new IllegalArgumentException("Month must be between 1 and 12.");
        }
        this.month = month;
    }

    public void setDay(int day) {
        if (day < 1 || day > daysInMonth(this.month, this.year)) {
            throw new IllegalArgumentException(
                "Invalid day for the given month/year: " + day
            );
        }
        this.day = day;
    }

    // Returns the number of days in a given month, considering leap years
    private int daysInMonth(int month, int year) {
        switch (month) {
            case 2: return isLeapYear(year) ? 29 : 28;
            case 4: case 6: case 9: case 11: return 30;
            default: return 31;
        }
    }

    // Checks if a year is a leap year
    private boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    // Formatted string output: dd/mm/yyyy
    @Override
    public String toString() {
        return String.format("%02d/%02d/%04d", day, month, year);
    }
}
