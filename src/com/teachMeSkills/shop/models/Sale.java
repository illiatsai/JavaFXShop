package com.teachMeSkills.shop.models;

public class Sale {
    private int idSale;
    private String nameCustomer;
    private String telNumberCustomer;
    private Good goodSaled;
    private int amountGoodSaled;
    private double resultPrice;
    private String dateOfSale;

    public Sale(int idSale, String nameCustomer, String telNumberCustomer, Good goodSaled, int amountGoodSaled, double resultPrice, String dateOfSale) {
        this.idSale = idSale;
        this.nameCustomer = nameCustomer;
        this.telNumberCustomer = telNumberCustomer;
        this.goodSaled = goodSaled;
        this.amountGoodSaled = amountGoodSaled;
        this.resultPrice = resultPrice;
        this.dateOfSale = dateOfSale;
    }

    public Sale() {
    }

    public int getIdSale() {
        return idSale;
    }

    public void setIdSale(int idSale) {
        this.idSale = idSale;
    }

    public String getNameCustomer() {
        return nameCustomer;
    }

    public void setNameCustomer(String nameCustomer) {
        this.nameCustomer = nameCustomer;
    }

    public String getTelNumberCustomer() {
        return telNumberCustomer;
    }

    public void setTelNumberCustomer(String telNumberCustomer) {
        this.telNumberCustomer = telNumberCustomer;
    }

    public Good getGoodSaled() {
        return goodSaled;
    }

    public void setGoodSaled(Good goodSaled) {
        this.goodSaled = goodSaled;
    }

    public int getAmountGoodSaled() {
        return amountGoodSaled;
    }

    public void setAmountGoodSaled(int amountGoodSaled) {
        this.amountGoodSaled = amountGoodSaled;
    }

    public String getDateOfSale() {
        return dateOfSale;
    }

    public void setDateOfSale(String dateOfSale) {
        this.dateOfSale = dateOfSale;
    }

    public double getResultPrice() {
        return resultPrice;
    }

    public void setResultPrice(double resultPrice) {
        this.resultPrice = resultPrice;
    }

    @Override
    public String toString() {
        return "Продажа №" + idSale + ": " +
                nameCustomer  + " " +
                telNumberCustomer +
                ", товар: " + goodSaled +
                ", в кол-ве: " + amountGoodSaled +
                ", на сумму: " + resultPrice + "$" +
                ", дата продажи: " + dateOfSale + " ";
    }
}
