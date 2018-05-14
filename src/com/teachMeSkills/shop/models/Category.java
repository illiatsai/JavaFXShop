package com.teachMeSkills.shop.models;

public class Category {
    private int idCategory;
    private String nameCategory;
    private int amountRemainingForCategory;

    public Category(int idCategory, String nameCategory, int amountRemainingForCategory) {
        this.idCategory = idCategory;
        this.nameCategory = nameCategory;
        this.amountRemainingForCategory = amountRemainingForCategory;
    }

    public Category(int idCategory, String nameCategory) {
        this.idCategory = idCategory;
        this.nameCategory = nameCategory;
    }

    public Category() {
    }

    public int getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(int idCategory) {
        this.idCategory = idCategory;
    }

    public String getNameCategory() {
        return nameCategory;
    }

    public void setNameCategory(String nameCategory) {
        this.nameCategory = nameCategory;
    }

    public int getAmountRemainingForCategory() {
        return amountRemainingForCategory;
    }

    public void setAmountRemainingForCategory(int amountRemainingForCategory) {
        this.amountRemainingForCategory = amountRemainingForCategory;
    }

    @Override
    public String toString() {
        return nameCategory;
    }
}
