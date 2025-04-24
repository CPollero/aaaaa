package model;

public class Departamento {

    private String name;

    private int totalGoldManMedals;
    private int totalSilverManMedals;
    private int totalBronzeManMedals;

    private int totalGoldWomenMedals;
    private int totalSilverWomenMedals;
    private int totalBronzeWomenMedals;

    private int totalGoldMixMedals;
    private int totalSilverMixMedals;
    private int totalBronzeMixMedals;

    private int totalGoldMedals;
    private int totalSilverMedals;
    private int totalBronzeMedals;

    public Departamento(String name, int totalGoldManMedals, int totalSilverManMedals, int totalBronzeManMedals,
                        int totalGoldWomenMedals, int totalSilverWomenMedals, int totalBronzeWomenMedals,
                        int totalGoldMixMedals, int totalSilverMixMedals, int totalBronzeMixMedals) {
        this.name = name;
        this.totalGoldManMedals = totalGoldManMedals;
        this.totalSilverManMedals = totalSilverManMedals;
        this.totalBronzeManMedals = totalBronzeManMedals;
        this.totalGoldWomenMedals = totalGoldWomenMedals;
        this.totalSilverWomenMedals = totalSilverWomenMedals;
        this.totalBronzeWomenMedals = totalBronzeWomenMedals;
        this.totalGoldMixMedals = totalGoldMixMedals;
        this.totalSilverMixMedals = totalSilverMixMedals;
        this.totalBronzeMixMedals = totalBronzeMixMedals;
        this.totalGoldMedals = Integer.MIN_VALUE;
        this.totalSilverMedals = Integer.MIN_VALUE;
        this.totalBronzeMedals = Integer.MIN_VALUE;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTotalGoldManMedals() {
        return totalGoldManMedals;
    }

    public void setTotalGoldManMedals(int totalGoldManMedals) {
        this.totalGoldManMedals = totalGoldManMedals;
    }

    public int getTotalSilverManMedals() {
        return totalSilverManMedals;
    }

    public void setTotalSilverManMedals(int totalSilverManMedals) {
        this.totalSilverManMedals = totalSilverManMedals;
    }

    public int getTotalBronzeManMedals() {
        return totalBronzeManMedals;
    }

    public void setTotalBronzeManMedals(int totalBronzeManMedals) {
        this.totalBronzeManMedals = totalBronzeManMedals;
    }

    public int getTotalGoldWomenMedals() {
        return totalGoldWomenMedals;
    }

    public void setTotalGoldWomenMedals(int totalGoldWomenMedals) {
        this.totalGoldWomenMedals = totalGoldWomenMedals;
    }

    public int getTotalSilverWomenMedals() {
        return totalSilverWomenMedals;
    }

    public void setTotalSilverWomenMedals(int totalSilverWomenMedals) {
        this.totalSilverWomenMedals = totalSilverWomenMedals;
    }

    public int getTotalBronzeWomenMedals() {
        return totalBronzeWomenMedals;
    }

    public void setTotalBronzeWomenMedals(int totalBronzeWomenMedals) {
        this.totalBronzeWomenMedals = totalBronzeWomenMedals;
    }

    public int getTotalGoldMixMedals() {
        return totalGoldMixMedals;
    }

    public void setTotalGoldMixMedals(int totalGoldMixMedals) {
        this.totalGoldMixMedals = totalGoldMixMedals;
    }

    public int getTotalSilverMixMedals() {
        return totalSilverMixMedals;
    }

    public void setTotalSilverMixMedals(int totalSilverMixMedals) {
        this.totalSilverMixMedals = totalSilverMixMedals;
    }

    public int getTotalBronzeMixMedals() {
        return totalBronzeMixMedals;
    }

    public void setTotalBronzeMixMedals(int totalBronzeMixMedals) {
        this.totalBronzeMixMedals = totalBronzeMixMedals;
    }

    public int getTotalGoldMedals() {
        return totalGoldMedals;
    }

    public void setTotalGoldMedals(int totalGoldMedals) {
        this.totalGoldMedals = totalGoldMedals;
    }

    public int getTotalSilverMedals() {
        return totalSilverMedals;
    }

    public void setTotalSilverMedals(int totalSilverMedals) {
        this.totalSilverMedals = totalSilverMedals;
    }

    public int getTotalBronzeMedals() {
        return totalBronzeMedals;
    }

    public void setTotalBronzeMedals(int totalBronzeMedals) {
        this.totalBronzeMedals = totalBronzeMedals;
    }

    public int getTotalMedallas() {
        int total =
                totalGoldManMedals +totalSilverManMedals
                +totalGoldWomenMedals +totalBronzeManMedals
                +totalSilverWomenMedals +totalBronzeWomenMedals
                +totalGoldMixMedals +totalSilverMixMedals
                +totalBronzeMixMedals;
        return total;
    }

    @Override
    public String toString() {
        return name + ": \n -Gold medals: " + totalGoldMedals + "\n -Silver medals: " + totalSilverMedals
                + "\n -Bronze medals: " + totalBronzeMedals+ "\n -Total medals: " + getTotalMedallas();
    }
}
