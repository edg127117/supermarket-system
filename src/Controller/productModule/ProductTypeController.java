package controller.productModule;

import bean.ProductType;
import db.DB;
import service.ProductTypeService;

import java.util.ArrayList;
import java.util.Scanner;

public class ProductTypeController {
    public static void menu() {

        boolean isEnd = false;

        while (!isEnd) {
            System.out.println("---------- 商 品 类 型 管 理 模 块 --------------------");
            System.out.println("1.类 型 列 表\n2.新 增 类 型\n3.移 除 类 型\n4.返 回 上 一 级");
            System.out.println("---------------------------------------------------");
            System.out.print("\n 请 输 入 您 的 选 择:");

            Scanner sc = new Scanner(System.in);
            int b = sc.nextInt();

            switch (b) {
                case 1:
                    printAll();
                    break;
                case 2:
                    add();
                    break;
                case 3:
                    remove();
                    break;
                case 4:
                    ProductModule.menu();
                    break;
                default:
                    System.out.println("输入错误,请重新输入");
            }
        }
    }
    private static void printAll() {
        ArrayList<ProductType> all = ProductTypeService.getAll();
        System.out.println("--------------------------------------- 商 品 类 型 列 表 -------------------------------------------------------------");
        System.out.println("\tID\t名称");
        for (ProductType productType : all) {
            System.out.println(productType);
        }
        System.out.println("---------------------------------------- 商 品 类 型 列 表 ------------------------------------------------------------");
    }
    private static void add() {
        ArrayList<ProductType> productTypes = DB.db.get("productTypeDB");
        System.out.println("------------- 新 增 商 品 类 型 ---------------");
        Scanner sc = new Scanner(System.in);

        while (true){
            System.out.print("请输入商品类型名称(输入exit退出):");
            String name = sc.next();
            if("exit".equals(name)){
                System.out.println("程序结束。");
                break;
            }
            if (name.isEmpty()){
                System.out.println("错误：类别不能为空！");
                continue;
            }
            String id = "T" + (productTypes.size() + 1);
            ProductType newType  = new ProductType(id,name);
            if (!productTypes.contains(newType )) {
                System.out.println("错误: 类别 '" + newType  + "' 已存在，请输入其他类型！");
            }else {
                ProductTypeService.add(newType);
                System.out.println(name + " 添加成功! ");
                break;
            }
        }
    }
    private static void remove() {
        printAll();
        System.out.print("请输入要移除的类型ID: ");
        int id = new Scanner(System.in).nextInt();
        ProductTypeService.remove(String.valueOf(id));
    }
}
