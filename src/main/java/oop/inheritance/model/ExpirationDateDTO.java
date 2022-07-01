package oop.inheritance.model;

public class ExpirationDateDTO {
    private final int year;
    private final int month;

    public ExpirationDateDTO(int year, int month) {
        this.year = year;
        this.month = month;
    }

    public int getYear() {
        return this.year;
    }

    public int getMonth() {
        return this.month;
    }

    public static ExpirationDateBuilderDTO builder() {
        return new ExpirationDateBuilderDTO();
    }
}
