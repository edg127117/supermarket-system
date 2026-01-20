package controller.productModule;

import bean.Product;
import bean.ProductType;
import db.DB;
import service.ProductService;
import service.ProductTypeService;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ProductController {
    public static void menu() {
        boolean a = false;

        while (!a) {
            System.out.println("---------- 商 品 管 理 模 块 ------------------");
            System.out.println("1.商 品 列 表\n2.新 增 商 品 \n3.移 除 商 品 \n4.修 改 商 品 \n5.商 品 入 库 \n6.商 品 出 库  \n7.返 回 上 一 级");
            System.out.println("-------------------------------------------------");
            System.out.print("\n 请 输 入 您 的 选 择:");

            Scanner sc = new Scanner(System.in);
            int b=sc.nextInt();
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
                    modify();
                    break;
                case 5:
                    processInbound();
                    break;
                case 6:
                    processOutbound();
                    break;
                case 7:
                    ProductModule.menu();
                    break;
                default:
                    System.out.println("输入错误,请重新输入");

            }
        }

    }
    public static void printAll() {
        ArrayList<Product> all = ProductService.getAll();

        System.out.println("--------------------------------------- 商 品 列 表 -------------------------------------------------------------");
        System.out.println("\t编号\t\t名称\t\t\t\t价格\t\t数量\t\t所属类别");
        for (Product product : all) {
            System.out.println(product);
        }
        System.out.println("---------------------------------------- 商 品 列 表 ------------------------------------------------------------");
        System.out.println("\t共计" + all.size() + "条数据。");
    }
    private static void add() {
        System.out.println("------------- 新 增 商 品 ---------------");
        Scanner scanner = new Scanner(System.in);
        System.out.print("输入商品ID: ");
        String id = scanner.nextLine();

        System.out.print("请输入商品名称:");
        String name = scanner.next();

        System.out.print("请输入商品价格:");
        Double price = scanner.nextDouble();

        System.out.print("输入商品数量: ");
        int count = scanner.nextInt();

        ArrayList<ProductType> all = ProductTypeService.getAll();
        for (ProductType productType : all) {
            System.out.println(productType);
        }
        System.out.print("请输入商品类型编号:");
        String typeId = scanner.next();

        Product product = new Product(id, name, price, count, typeId);

        ProductService.add(product);

        System.out.println(name + " 添加成功! ");
    }
    private static void remove() {
        printAll();
        System.out.print("请输入要移除的类型ID: ");
        String id = String.valueOf(new Scanner(System.in).next());
        ProductService.remove(id);
    }
    private static void modify() {
        ArrayList<Product> products = DB.db.get("productDB");
        ArrayList<ProductType> productTypes = DB.db.get("productTypeDB");

        System.out.println("\n---------- 商品修改 ----------");
        System.out.print("请输入要修改的商品ID: ");
        String productId = new Scanner(System.in).nextLine().trim();

        Product product = null;
        for (Product p : products) {
            if (p.getId().equals(productId)) {
                product = p;
                break;
            }
        }
        if (product == null) {
            System.out.println("未找到ID为 " + productId + " 的商品");
            return;
        }
        System.out.println("\n当前商品信息:");
        System.out.println(product);
        Scanner scanner = new Scanner(System.in);

        System.out.print("\n请输入新的商品名称(直接回车跳过): ");
        String newName = scanner.nextLine().trim();
        if (!newName.isEmpty()) {
            product.setName(newName);
        }

        boolean validPrice = false;
        while (!validPrice) {
            System.out.print("请输入新的商品价格(直接回车跳过): ");
            String priceInput = scanner.nextLine().trim();
            if (priceInput.isEmpty()) {
                validPrice = true;
            } else {
                try {
                    double newPrice = Double.parseDouble(priceInput);
                    if (newPrice > 0) {
                        product.setPrice(newPrice);
                        validPrice = true;
                    } else {
                        System.out.println("价格必须大于0！");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("请输入有效的数字！");
                }
            }
        }

        boolean validType = false;
        while (!validType) {
            System.out.print("请输入新的商品类型ID(直接回车跳过): ");
            String newTypeId = scanner.nextLine().trim();
            if (newTypeId.isEmpty()) {
                validType = true;
            }else {
                boolean typeExists= productTypes.stream()
                        .anyMatch(t->t.getId().equals(newTypeId));
                if (typeExists) {
                    product.setTypeId(newTypeId);
                    validType = true;
                }else {
                    System.out.println("该商品类型不存在！可用类型：");
                    productTypes.forEach(t -> System.out.println(t.getId() + "-" + t.getName()));
                }
            }

        }
        System.out.println("\n商品修改成功！");
    }
    private static void processInbound() {
        ArrayList<Product> products = DB.db.get("productDB");
        System.out.print("请输入商品编号: ");
        Scanner scanner = new Scanner(System.in);
        String productId = scanner.nextLine().trim();
        Product targetProduct = null;
        for (Product p : products) {
            if (p.getId().equals(productId)) {
                targetProduct=p;
            break;
            }
        }
        if (targetProduct == null) {
            System.out.println("未找到ID为 " + productId + " 的商品");
            return;
        }

        System.out.print("请输入入库数量: ");
        int quantity;
        try {
            quantity = scanner.nextInt();
            if (quantity <= 0) {
                System.out.println("数量必须为正数！");
                return;
            }
        } catch (InputMismatchException e) {
            System.out.println("请输入有效数字！");
            return;
        }
        int newCount = targetProduct.getCount()+quantity;
        targetProduct.setCount(newCount);

        System.out.println("\n入库成功！");
        System.out.println("商品信息: " + targetProduct);
        System.out.println("当前库存: " + newCount);
    }
    private static void processOutbound() {
        ArrayList<Product> products = DB.db.get("productDB");
        System.out.print("请输入商品编号: ");
        Scanner scanner = new Scanner(System.in);
        String productId = scanner.nextLine().trim();
        Product targetProduct = null;
        for (Product p : products) {
            if (p.getId().equals(productId)) {
                targetProduct=p;
                break;
            }
        }
        if (targetProduct == null) {
            System.out.println("未找到ID为 " + productId + " 的商品");
            return;
        }

        System.out.print("请输入出库数量: ");
        int quantity;
        try {
            quantity = scanner.nextInt();
            if (quantity <= 0) {
                System.out.println("数量必须为正数！");
                return;
            }
        } catch (InputMismatchException e) {
            System.out.println("请输入有效数字！");
            return;
        }
        int newCount = targetProduct.getCount()-quantity;
        targetProduct.setCount(newCount);

        System.out.println("\n出库成功！");
        System.out.println("商品信息: " + targetProduct);
        System.out.println("当前库存: " + newCount);
    }
}
