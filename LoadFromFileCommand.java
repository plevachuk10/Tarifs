package mobilecompany.commands;

import mobilecompany.services.TariffManager;

public class LoadFromFileCommand implements Command {
    private final TariffManager tariffManager;

    public LoadFromFileCommand(TariffManager tariffManager) {
        this.tariffManager = tariffManager;
    }

    @Override
    public void execute() {
        // Завантажуємо тарифи з файлу
        String filePath = "C:\\Users\\monos.com.ua\\Desktop\\tariffs.dat.txt";
        tariffManager.loadTariffs(filePath);
    }

    @Override
    public String getDesc() {
        return "📂 Load Tariffs from File";
    }
}
