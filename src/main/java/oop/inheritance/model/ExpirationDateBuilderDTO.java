package oop.inheritance.model;

public class ExpirationDateBuilderDTO {
    private int year;
    private int month;

    ExpirationDateBuilderDTO() {
    }

    public ExpirationDateBuilderDTO year(int year) {
        this.year = year;
        return this;
    }

    public ExpirationDateBuilderDTO month(int month) {
        this.month = month;
        return this;
    }

    public ExpirationDateDTO build() {
        return new ExpirationDateDTO(this.year, this.month);
    }
}
