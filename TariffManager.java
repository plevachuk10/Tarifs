package mobilecompany.services;

import mobilecompany.models.Tariff;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class TariffManager {
    private List<Tariff> tariffs;

    // Конструктор для ініціалізації тарифів
    public TariffManager() {
        tariffs = new ArrayList<>();
    }

    // Метод для додавання тарифу
    public void addTariff(Tariff tariff) {
        tariffs.add(tariff);
    }
    public void displayTariffs() {
        if (tariffs.isEmpty()) {
            System.out.println("No tariffs available.");
        } else {
            for (Tariff tariff : tariffs) {
                System.out.println("Tariff: " + tariff.getName() + ", Price: " + tariff.getPrice() + ", Customers: " + tariff.getCustomerCount());
            }
        }
    }
    // Метод для отримання списку тарифів
    public List<Tariff> getTariffs() {
        return tariffs;
    }

    // Метод для завантаження тарифів з файлу
    public void loadTariffs(String filePath) {
        File file = new File(filePath);
        if (!file.exists()) {
            System.out.println("File does not exist!");
            return;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 3) {
                    String name = data[0].trim();
                    double price = Double.parseDouble(data[1].trim());
                    int customerCount = Integer.parseInt(data[2].trim());
                    Tariff tariff = new Tariff(name, price, customerCount);
                    addTariff(tariff);
                }
            }
            System.out.println("Tariffs loaded successfully.");
        } catch (IOException e) {
            System.out.println("Error loading tariffs from file: " + e.getMessage());
        }
    }

    // Метод для збереження тарифів у файл
    // Оновлений метод saveTariffs, який приймає шлях до файлу
    public void saveTariffs(String filePath) {
        try (FileOutputStream fos = new FileOutputStream(filePath)) {
            for (Tariff tariff : tariffs) {
                // Форматуємо дані тарифа в рядок
                String data = tariff.getName() + "," + tariff.getPrice() + "," + tariff.getCustomerCount() + "\n";
                fos.write(data.getBytes(StandardCharsets.UTF_8));  // Записуємо в файл
            }
            System.out.println("Tariffs saved successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Метод для видалення тарифу за назвою
    public boolean removeTariff(String name) {
        return tariffs.removeIf(tariff -> tariff.getName().equalsIgnoreCase(name));
    }
}
