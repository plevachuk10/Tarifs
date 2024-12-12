package mobilecompany.commands;

import mobilecompany.models.Tariff;
import mobilecompany.services.TariffManager;

import java.util.Scanner;

public class AddTariffCommand implements Command {
    private TariffManager tariffManager;

    public AddTariffCommand(TariffManager tariffManager) {
        this.tariffManager = tariffManager;
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);

        // Введення даних для нового тарифу
        System.out.println("Enter tariff name:");
        String name = scanner.nextLine();
        System.out.println("Enter subscription fee:");
        double subscriptionFee = scanner.nextDouble();
        System.out.println("Enter number of clients:");
        int numberOfClients = scanner.nextInt();

        // Створюємо новий тариф
        Tariff newTariff = new Tariff(name, subscriptionFee, numberOfClients);

        // Додаємо тариф до менеджера
        tariffManager.addTariff(newTariff);
        System.out.println("Tariff added successfully!");
    }

    @Override
    public String getDesc() {
        return "➕ Add New Tariff";
    }
}
