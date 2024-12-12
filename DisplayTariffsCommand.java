package mobilecompany.commands;

import mobilecompany.services.TariffManager;

public class DisplayTariffsCommand implements Command {
    private final TariffManager tariffManager;

    public DisplayTariffsCommand(TariffManager tariffManager) {
        this.tariffManager = tariffManager;
    }

    @Override
    public void execute() {
        tariffManager.displayTariffs();
    }

    @Override
    public String getDesc() {
        return "📜 Display All Tariffs";
    }
}
