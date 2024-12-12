package mobilecompany.models;

public class Tariff {
    private String name;
    private double price; // Subscription fee
    private int customerCount;

    public Tariff(String name, double price, int customerCount) {
        this.name = name;
        this.price = price;
        this.customerCount = customerCount;
    }

    // Геттер для назви тарифу
    public String getName() {
        return name;
    }

    // Геттер для ціни тарифу (subscription fee)
    public double getPrice() {
        return price;
    }

    // Геттер для кількості клієнтів
    public int getCustomerCount() {
        return customerCount;
    }

    // Метод для отримання ціни тарифу (можна використовувати як getSubscriptionFee)
    public double getSubscriptionFee() {
        return price;
    }

    // Перевизначення toString для зручності виведення
    @Override
    public String toString() {
        return "Tariff{name='" + name + "', price=" + price + ", customerCount=" + customerCount + '}';
    }
}
