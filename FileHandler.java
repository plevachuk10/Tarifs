package mobilecompany.services;

import mobilecompany.models.Tariff;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class FileHandler {

    private static final String FILE_PATH = "C:\\Users\\monos.com.ua\\Desktop\\tariffs.dat.txt";

    // Метод для збереження тарифів у текстовий файл
    public static void saveToFile(List<Tariff> tariffs) {
        try (FileOutputStream fos = new FileOutputStream(FILE_PATH)) {
            StringBuilder data = new StringBuilder();
            for (Tariff tariff : tariffs) {
                data.append(tariff.toString()).append(System.lineSeparator());
            }
            fos.write(data.toString().getBytes(StandardCharsets.UTF_8));
            System.out.println("✅ Tariffs saved successfully to " + FILE_PATH);
        } catch (IOException e) {
            System.out.println("❌ Error saving tariffs: " + e.getMessage());
        }
    }

    // Метод для зчитування тарифів із текстового файлу
    public static List<Tariff> loadFromFile() {
        List<Tariff> tariffs = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH, StandardCharsets.UTF_8))) {
            String line;
            while ((line = reader.readLine()) != null) {
                Tariff tariff = parseTariff(line);
                if (tariff != null) {
                    tariffs.add(tariff);
                }
            }
            System.out.println("✅ Tariffs loaded successfully from " + FILE_PATH);
        } catch (IOException e) {
            System.out.println("❌ Error loading tariffs: " + e.getMessage());
        }
        return tariffs;
    }

    // Метод для парсингу рядка в об'єкт Tariff
    private static Tariff parseTariff(String line) {
        try {
            String[] parts = line.split(", ");
            String name = parts[0].split("=")[1];
            double subscriptionFee = Double.parseDouble(parts[1].split("=")[1]);
            int numberOfClients = Integer.parseInt(parts[2].split("=")[1].replace("}", ""));
            return new Tariff(name, subscriptionFee, numberOfClients);
        } catch (Exception e) {
            System.out.println("❌ Error parsing tariff: " + line);
            return null;
        }
    }
}
