package com.teachMeSkills.shop.services;

import com.teachMeSkills.shop.dao.salesDao.ISalesDao;
import com.teachMeSkills.shop.dao.salesDao.SalesDaoImpl;
import com.teachMeSkills.shop.models.Sale;

import java.util.List;

public class SaleService implements ISaleService {
    private static SaleService saleService = new SaleService();
    private ISalesDao dao = new SalesDaoImpl();

    public SaleService() {
    }

    public static SaleService getInstance() {
        return saleService;
    }

    @Override
    public List<Sale> listOfSales() {
        return dao.listOfSales();
    }

    @Override
    public void addSale(Sale sale) {
        dao.addSale(sale);
    }

    @Override
    public List<Sale> listOfSalesByCustomerName(String customerName) {
        return dao.listOfSalesByCustomerName(customerName);
    }

    @Override
    public List<Sale> listOfSalesByGoodName(String goodName) {
        return dao.listOfSalesByGoodName(goodName);
    }

    @Override
    public List<Sale> listOfSalesByGoodPrice(String goodPrice) {
        return dao.listOfSalesByGoodPrice(goodPrice);
    }
}
