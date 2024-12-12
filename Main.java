package mobilecompany;

import mobilecompany.services.TariffManager;
import mobilecompany.ui.Menu;

public class Main {
    public static void main(String[] args) {
        TariffManager tariffManager = new TariffManager();
        Menu menu = new Menu(tariffManager);
        menu.displayMenu();
    }
}
