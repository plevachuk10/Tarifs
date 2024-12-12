package mobilecompany.models;

public class SpecialTariff extends Tariff {
    private int bonusMinutes;
    private int bonusData;

    public SpecialTariff(String name, double subscriptionFee, int numberOfClients, int bonusMinutes, int bonusData) {
        super(name, subscriptionFee, numberOfClients);
        this.bonusMinutes = bonusMinutes;
        this.bonusData = bonusData;
    }

    public int getBonusMinutes() {
        return bonusMinutes;
    }

    public int getBonusData() {
        return bonusData;
    }

    @Override
    public String toString() {
        return super.toString() + ", bonusMinutes=" + bonusMinutes + ", bonusData=" + bonusData + "}";
    }
}
