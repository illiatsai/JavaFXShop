package com.teachMeSkills.shop.services;

import com.teachMeSkills.shop.dao.goodsDao.GoodsDaoImpl;
import com.teachMeSkills.shop.models.Good;

import java.util.List;

public class GoodService implements IGoodService {
    private static GoodService goodService = new GoodService();
    private GoodsDaoImpl dao = new GoodsDaoImpl();

    private GoodService(){

    }

    public static GoodService getInstance(){
        return goodService;
    }
    @Override
    public List<Good> getAllGoods() {
        return dao.listAllGoods();
    }

    @Override
    public void createGood(Good good) {
        dao.createGood(good);

    }

    @Override
    public void updateGood(Good good) {
        dao.updateGood(good);
    }

    @Override
    public void deleteGood(Good good) {
        dao.deleteGood(good);
    }

    @Override
    public List<Good> getGoodByName(String nameGood) {
        return dao.getGoodByName(nameGood);
    }

    @Override
    public List<Good> getGoodByPrice(String priceGood) {
        return dao.getGoodByPrice(priceGood);
    }
}
