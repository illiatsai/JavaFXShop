package com.teachMeSkills.shop.dao.goodsDao;

import com.teachMeSkills.shop.models.Good;

import java.util.List;

public interface IGoodsDao {
    List<Good> listAllGoods();
    void createGood(Good good);
    void updateGood(Good good);
    void deleteGood(Good good);
    List<Good> getGoodByName(String nameGood);
    List<Good> getGoodByPrice(String priceGood);
}
