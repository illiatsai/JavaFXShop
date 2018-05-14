package com.teachMeSkills.shop.services;

import com.teachMeSkills.shop.models.Sale;

import java.util.List;

public interface ISaleService {
    List<Sale> listOfSales();
    void addSale(Sale sale);
    List<Sale> listOfSalesByCustomerName(String customerName);
    List<Sale> listOfSalesByGoodName(String goodName);
    List<Sale> listOfSalesByGoodPrice(String goodPrice);
}
