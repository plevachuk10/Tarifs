package mobilecompany.commands;

import mobilecompany.models.Tariff;
import mobilecompany.services.TariffManager;

public class ShowAllTariffsCommand implements Command {
    private TariffManager tariffManager;

    public ShowAllTariffsCommand(TariffManager tariffManager) {
        this.tariffManager = tariffManager;
    }

    @Override
    public void execute() {
        System.out.println("Showing all tariffs:");
        for (Tariff tariff : tariffManager.getTariffs()) {
            System.out.println(tariff);
        }
    }

    @Override
    public String getDesc() {
        return "📋 Show All Tariffs";
    }
}
