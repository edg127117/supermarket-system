package service;

import bean.Log;
import bean.ProductType;
import db.DB;

import java.util.ArrayList;
import java.util.Objects;

public class ProductTypeService {
    private static ArrayList<ProductType> productTypes = DB.db.get("productTypeDB");

    public static ArrayList<ProductType> getAll() {
        LogService.log("查找所有", "查看了所有的商品类型", true, Log.LogType.商品模块日志, "无");
        return productTypes;
    }
    public static void add(ProductType productType) {
        LogService.log("添加商品类型", "添加了一个商品类型:" + productType.getName(), true, Log.LogType.商品模块日志, "无");
        productTypes.add(productType);
    }
    public static void remove(String id) {
        ProductType productType=new ProductType();
        productType.setId(id);
        boolean remove =productTypes.remove(productType);
        if (remove) {
            LogService.log("删除商品类型", "删除了ID为" + id + "的商品类型", true, Log.LogType.商品模块日志, "无");
            System.out.println("移除成功!");
        } else {
            LogService.log("删除商品类型", "尝试删除ID为" + id + "的商品类型", false, Log.LogType.商品模块日志, "该ID的类型不存在");
            System.out.println("移除失败，该商品类型不存在!");
        }
    }

}
