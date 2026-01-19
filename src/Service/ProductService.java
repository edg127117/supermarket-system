package service;

import bean.Log;
import bean.Product;
import db.DB;

import java.util.ArrayList;

public class ProductService {
    private static ArrayList<Product> products = DB.db.get("productDB");

    public static ArrayList<Product> getAll() {
        return products;
    }
    public static void add(Product product) {
        LogService.log("添加商品", "添加了一个商品:" + product.getName(), true, Log.LogType.商品模块日志, "无");
        products.add(product);
    }
    public static void remove(String id) {
        Product product = new Product();
        product.setId(id);
        boolean remove =products.remove(product);
        if(remove) {
            System.out.println("移除成功!");
            LogService.log("删除商品", "删除了ID为" + id + "的商品", true, Log.LogType.商品模块日志, "无");
        }else {
            System.out.println("移除失败，该商品不存在!");
            LogService.log("删除商品", "尝试删除ID为" + id + "的商品", false, Log.LogType.商品模块日志, "该ID的商品不存在");
        }
    }
    public static Product getById(String id) {
        for (Product product : products) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }

}
