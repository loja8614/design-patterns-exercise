package oop.inheritance.model;

public class ExpirationDate {
    private final int year;
    private final int month;

    public ExpirationDate(int year, int month) {
        this.year = year;
        this.month = month;
    }

    public int getYear() {
        return this.year;
    }

    public int getMonth() {
        return this.month;
    }

    public static ExpirationDateBuilder builder() {
        return new ExpirationDateBuilder();
    }
}
