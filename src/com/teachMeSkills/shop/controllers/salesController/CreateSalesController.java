package com.teachMeSkills.shop.controllers.salesController;

import com.teachMeSkills.shop.dao.goodsDao.GoodsDaoImpl;
import com.teachMeSkills.shop.models.Good;
import com.teachMeSkills.shop.models.Sale;
import com.teachMeSkills.shop.services.GoodService;
import com.teachMeSkills.shop.services.SaleService;
import javafx.event.ActionEvent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.time.format.DateTimeFormatter;
import java.util.List;

public class CreateSalesController {

    private SaleService saleService = SaleService.getInstance();
    private GoodService goodService = GoodService.getInstance();

    public TextField nameCustomer;
    public TextField telNumberCustomer;
    public ComboBox<Good> good;
    public TextField amountGoodsSaled;
    public DatePicker dateSale;
    public Label saleInfo;


    public void initialize(){
        good.getItems().addAll(goodService.getAllGoods());
    }

    public void createSale(ActionEvent actionEvent) {
        try{
            Sale sale = new Sale();
            sale.setNameCustomer(nameCustomer.getText().trim());
            sale.setTelNumberCustomer(telNumberCustomer.getText().trim());
            sale.setGoodSaled(good.getValue());
            sale.setAmountGoodSaled(Integer.parseInt(amountGoodsSaled.getText().trim()));
            if(Integer.parseInt(amountGoodsSaled.getText().trim()) > sale.getGoodSaled().getAmountGoodsRemaining()) {
                saleInfo.setText("Превышено кол-во товара. В наличии: " + sale.getGoodSaled().getAmountGoodsRemaining());
                return;
            }
            sale.setDateOfSale(dateSale.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));

            //находим самый дорогой товар, чтоб скидку предоставить
            GoodsDaoImpl goodsDao = new GoodsDaoImpl();
            List<Good> goods = goodsDao.listAllGoods();
            Good mostExpensiveGood = goods.get(0);
            for(Good good : goods) {
                if(good.getPriceGood() > mostExpensiveGood.getPriceGood()) {
                    mostExpensiveGood = good;
                }
            }

            //читаем фактическую цену товара со всеми скидками включая количественную скидку
            double totalPercentageOfSaledGood = (double) sale.getAmountGoodSaled() / sale.getGoodSaled().getAmountGoodsRemaining();
            double totalpriceWithDiscont = 0;
            if (totalPercentageOfSaledGood >= 0.3) {
                totalpriceWithDiscont =(sale.getGoodSaled().getPriceGood() - (sale.getGoodSaled().getPriceGood() * 0.1)) * sale.getAmountGoodSaled();
                sale.setResultPrice(totalpriceWithDiscont);
            } else {
                sale.setResultPrice(sale.getGoodSaled().getPriceGood() * sale.getAmountGoodSaled());
            }

            //если товар самый дорогой, то установим ему цену со скидкой
            if(sale.getGoodSaled().getIdGood() == mostExpensiveGood.getIdGood()) {
                double mostExpensiveGoodPriceWithDiscont = totalpriceWithDiscont - (sale.getGoodSaled().getPriceGood()*0.05 * sale.getAmountGoodSaled());
                sale.setResultPrice(mostExpensiveGoodPriceWithDiscont);
            }
            sale.getGoodSaled().setAmountGoodsRemaining(sale.getGoodSaled().getAmountGoodsRemaining() - sale.getAmountGoodSaled());
            saleService.addSale(sale);
            SalesController.createStage.close();
        } catch (NullPointerException e) {
            saleInfo.setText("Заполните все поля.");
            return;
        } catch (NumberFormatException e) {
            saleInfo.setText("Введите число в поле кол-ва товара.");
            return;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
