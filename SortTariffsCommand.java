package mobilecompany.commands;

import mobilecompany.models.Tariff;
import mobilecompany.services.TariffManager;

import java.util.List;

public class SortTariffsCommand implements Command {
    private final TariffManager tariffManager;

    public SortTariffsCommand(TariffManager tariffManager) {
        this.tariffManager = tariffManager;
    }

    @Override
    public void execute() {
        List<Tariff> tariffs = tariffManager.getTariffs();

        // Сортуємо тарифи за ціною (subscription fee)
        tariffs.sort((tariff1, tariff2) -> Double.compare(tariff1.getSubscriptionFee(), tariff2.getSubscriptionFee()));

        System.out.println("Tariffs sorted by subscription fee:");
        for (Tariff tariff : tariffs) {
            System.out.println(tariff);
        }
    }

    @Override
    public String getDesc() {
        return "🔄 Sort Tariffs by Subscription Fee";
    }
}
