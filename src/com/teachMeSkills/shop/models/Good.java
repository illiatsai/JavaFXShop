package com.teachMeSkills.shop.models;

public class Good {
    private int idGood;
    private String nameGood;
    private String descriptionGood;
    private Category category;
    private double priceGood;
    private int amountGoodsRemaining;

    public Good(int idGood, String nameGood, String descriptionGood, Category category, double priceGood, int amountGoodsRemaining) {
        this.idGood = idGood;
        this.nameGood = nameGood;
        this.descriptionGood = descriptionGood;
        this.category = category;
        this.priceGood = priceGood;
        this.amountGoodsRemaining = amountGoodsRemaining;
    }

    public Good(String nameGood, String descriptionGood, double priceGood, int amountGoodsRemaining) {
        this.nameGood = nameGood;
        this.descriptionGood = descriptionGood;
        this.priceGood = priceGood;
        this.amountGoodsRemaining = amountGoodsRemaining;
    }

    public Good() {
    }

    public int getIdGood() {
        return idGood;
    }

    public void setIdGood(int idGood) {
        this.idGood = idGood;
    }

    public String getNameGood() {
        return nameGood;
    }

    public void setNameGood(String nameGood) {
        this.nameGood = nameGood;
    }

    public String getDescriptionGood() {
        return descriptionGood;
    }

    public void setDescriptionGood(String descriptionGood) {
        this.descriptionGood = descriptionGood;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public double getPriceGood() {
        return priceGood;
    }

    public void setPriceGood(double priceGood) {
        this.priceGood = priceGood;
    }

    public int getAmountGoodsRemaining() {
        return amountGoodsRemaining;
    }

    public void setAmountGoodsRemaining(int amountGoodsRemaining) {
        this.amountGoodsRemaining = amountGoodsRemaining;
    }

    @Override
    public String toString() {
        return nameGood;
    }
}
