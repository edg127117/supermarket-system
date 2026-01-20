package bean;

import service.CashierService;
import service.ProductService;
import utils.DateTimeUtil;

import java.util.*;

public class Order {
    private String id;


    private int cashierId;
    private Map<String, Integer> products = null;
    private double totalPrice;
    private String dateTime;

    public Order(String id,int cashierId, Map<String, Integer> products) {
        this.id = id;
        this.cashierId = cashierId;
        this.products = products;
        this.dateTime = DateTimeUtil.getNowDateTime();
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getCashierId() {
        return cashierId;
    }

    public void setCashierId(int cashierId) {
        this.cashierId = cashierId;
    }

    public Map<String, Integer> getProducts() {
        return products;
    }

    public void setProducts(Map<String, Integer> products) {
        this.products = products;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }


    @Override
    public String toString() {
        double totalPrice = 0;
        String product = "===================";
        Set<Map.Entry<String, Integer>> entries = products.entrySet();
        for (Map.Entry entry : entries) {
            Product p = ProductService.getById((String) entry.getKey());
            totalPrice += p.getPrice() * (Integer) entry.getValue();
            product += "\n\t" + p.getName() + "\t单价:" + p.getPrice() + "\t数量:" + entry.getValue() + "\t\t";
        }
        product += "\n=================== 商 品 列 表 ===================";
        this.totalPrice = totalPrice;

        return new StringJoiner("\t\t", "--------------" + id + "号订单-------------\n", "--------------" + id + "号订单-------------\n")
                .add("收银员:" + CashierService.getById(cashierId).getName())
                .add("\n=================== 商 品 列 表 "  + product + "\n")
                .add("总价:" + this.totalPrice + "\t")
                .add("下单日期:" + dateTime + "\n")
                .toString();
    }
}
