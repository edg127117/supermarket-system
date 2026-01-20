package db;

import bean.*;

import java.util.*;

public class DB {
    public static HashMap<String, ArrayList> db = new HashMap<>();

    public static void init() {
        db.put("productDB", new ArrayList<Product>());

        db.put("productTypeDB", new ArrayList<ProductType>());

        db.put("cashierDB", new ArrayList<Calendar>());

        db.put("orderDB", new ArrayList<Order>());

        db.put("loginCashier",new ArrayList<Cashier>());

        db.put("logDB", new ArrayList<Log>());

        ArrayList<Product> products = DB.db.get("productDB");
        products.add(new Product("P001","小米11",5999.99,10,"T001"));
        products.add(new Product("P002","康师傅冰红茶",3.00,10,"T002"));
        products.add(new Product("P003","新疆进口西瓜",10.00,10,"T003"));
        products.add(new Product("P004","中性笔",1.00,10,"T004"));
        products.add(new Product("P005","保温杯",15.00,10,"T005"));
        products.add(new Product("P006","康佳锅巴",3.00,10,"T006"));

        ArrayList<ProductType> productTypes = DB.db.get("productTypeDB");
        productTypes.add(new ProductType("T001","食品类"));
        productTypes.add(new ProductType("T002","日用品类"));
        productTypes.add(new ProductType("T003","文具类"));
        productTypes.add(new ProductType("T004","水果类"));
        productTypes.add(new ProductType("T005","饮料类"));
        productTypes.add(new ProductType("T006","数码类"));

        ArrayList<Cashier> calendars = DB.db.get("cashierDB");
        calendars.add(new Cashier(1,"cashier1","pos123","张三","男",18,"重庆","1234567890"));
        calendars.add(new Cashier(2,"cashier1","pos123","李四","男",20,"北京","1234567891"));
        calendars.add(new Cashier(3,"cashier1","pos123","王舞","女",19,"杭州","1234567890"));

        ArrayList<LoginCashier> loginCashiers = DB.db.get("loginCashier");

        ArrayList<Order> orders = DB.db.get("orderDB");
        Map<String,Integer> productQuantityMap = new HashMap<>();
        productQuantityMap.put("P001", 2);
        productQuantityMap.put("P002", 1);

        Order newOrder = new Order(
                generateOrderId(),
                1,
                productQuantityMap
        );

        orders.add(newOrder);

    }
    public static String generateOrderId() {
        return "ORD" + System.currentTimeMillis();
    }
}
