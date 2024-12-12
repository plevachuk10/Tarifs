package mobilecompany.ui;

import mobilecompany.services.TariffManager;
import mobilecompany.commands.*;

import java.util.Scanner;

public class Menu {
    private final TariffManager tariffManager;

    public Menu(TariffManager tariffManager) {
        this.tariffManager = tariffManager;
    }

    public void displayMenu() {
        Scanner scanner = new Scanner(System.in);
        // Створення команд
        Command[] commands = {
                new AddTariffCommand(tariffManager),
                new CalculateTotalCustomersCommand(tariffManager),
                new DisplayTariffsCommand(tariffManager),
                new FindTariffCommand(tariffManager),
                new LoadFromFileCommand(tariffManager),
                new SaveToFileCommand(tariffManager),
                new SortTariffsCommand(tariffManager),
                new NewCommand(),
                new ExitCommand() // ExitCommand в кінці
        };

        while (true) {
            System.out.println("\nMenu:");

            // Виведення команд
            for (int i = 0; i < commands.length - 1; i++) {  // Команди з 1 до 7
                System.out.println((i + 1) + ". " + commands[i].getDesc());
            }

            System.out.println("0. ❌ Exit Program"); // Вихід в кінці

            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            if (choice == 0) {
                // Якщо вибрано 0, виконуємо ExitCommand
                System.out.println("Exiting program...");
                return; // Вихід з програми
            } else if (choice >= 1 && choice <= commands.length - 1) {
                // Всі інші варіанти (не вихід)
                commands[choice - 1].execute();
            } else {
                System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
