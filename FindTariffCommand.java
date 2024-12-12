package mobilecompany.commands;

import mobilecompany.services.TariffManager;

import java.util.Scanner;

public class FindTariffCommand implements Command {
    private final TariffManager tariffManager;

    public FindTariffCommand(TariffManager tariffManager) {
        this.tariffManager = tariffManager;
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter tariff name to find: ");
        String name = scanner.nextLine();
        tariffManager.getTariffs().stream()
                .filter(tariff -> tariff.getName().equalsIgnoreCase(name))
                .forEach(System.out::println);
    }

    @Override
    public String getDesc() {
        return "🔍 Find Tariff by Name";
    }
}
