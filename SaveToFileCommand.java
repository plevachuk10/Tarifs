package mobilecompany.commands;

import mobilecompany.services.TariffManager;

public class SaveToFileCommand implements Command {
    private final TariffManager tariffManager;

    public SaveToFileCommand(TariffManager tariffManager) {
        this.tariffManager = tariffManager;
    }

    @Override
    public void execute() {
        // Тут передаємо шлях до файлу для збереження тарифів
        tariffManager.saveTariffs("C:\\Users\\monos.com.ua\\Desktop\\tariffs.dat.txt");
        System.out.println("Tariffs saved successfully.");
    }

    @Override
    public String getDesc() {
        return "💾 Save Tariffs to File";
    }
}
