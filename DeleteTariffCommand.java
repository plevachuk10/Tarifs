package mobilecompany.commands;

import mobilecompany.services.TariffManager;
import java.util.Scanner;

public class DeleteTariffCommand implements Command {
    private TariffManager tariffManager;

    public DeleteTariffCommand(TariffManager tariffManager) {
        this.tariffManager = tariffManager;
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Tariff Name to Delete: ");
        String name = scanner.nextLine();

        boolean deleted = tariffManager.removeTariff(name);  // Тепер метод повертає boolean
        if (deleted) {
            System.out.println("Tariff deleted successfully.");
        } else {
            System.out.println("Tariff not found.");
        }
    }

    @Override
    public String getDesc() {
        return "❌ Delete Tariff";
    }
}
