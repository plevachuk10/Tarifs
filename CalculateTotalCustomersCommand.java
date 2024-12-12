package mobilecompany.commands;

import mobilecompany.services.TariffManager;
import mobilecompany.models.Tariff;

public class CalculateTotalCustomersCommand implements Command {
    private final TariffManager tariffManager;

    public CalculateTotalCustomersCommand(TariffManager tariffManager) {
        this.tariffManager = tariffManager;
    }

    @Override
    public void execute() {
        int totalCustomers = 0;

        // Проходимо по всіх тарифах і підсумовуємо кількість клієнтів
        for (Tariff tariff : tariffManager.getTariffs()) {
            totalCustomers += tariff.getCustomerCount();
        }

        System.out.println("Total number of customers: " + totalCustomers);
    }

    @Override
    public String getDesc() {
        return "📊 Calculate Total Customers";
    }
}
