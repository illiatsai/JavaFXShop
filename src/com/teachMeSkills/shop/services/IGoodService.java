package com.teachMeSkills.shop.services;

import com.teachMeSkills.shop.models.Good;

import java.util.List;

public interface IGoodService {
    List<Good> getAllGoods();
    void createGood(Good good);
    void updateGood(Good good);
    void deleteGood(Good good);
    List<Good> getGoodByName(String nameGood);
    List<Good> getGoodByPrice(String priceGood);
}
