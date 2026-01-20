package controller.cashRegisterModule;

import bean.Cashier;
import bean.LoginCashier;
import bean.Order;
import bean.Product;
import controller.productModule.ProductController;
import db.DB;
import service.OrderService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class OrderController {
    public static void printAll() {

        ArrayList<Order> all = OrderService.getAll();

        System.out.println("--------------------------------------- 订 单 列 表 -------------------------------------------------------------");

        for (Order order : all) {
            System.out.println(order);
        }
        System.out.println("---------------------------------------- 订 单 列 表 ------------------------------------------------------------");
        System.out.println("\t共计" + all.size() + "条订单数据。");
    }
    public static void add() {
        Scanner scanner = new Scanner(System.in);
        Map<String,Integer> productQuantityMap = new HashMap<>();
        LoginCashier currentCashier = LoginSession.getCurrentCashier();

        ProductController.printAll();
        while (true) {
            System.out.print("请输入想要购买的商品编号:");
            String productId = String.valueOf(scanner.nextInt());
            System.out.print("请输入购买数量: ");
            int count = scanner.nextInt();
            int stock = OrderService.getStock(productId);
            if (count > stock) {
                System.out.printf("库存不足！当前库存: %d\n", stock);
                continue;
            }
            productQuantityMap.put(productId, count);
            System.out.printf("成功购买: %d\n", count);
            System.out.println("是否继续? (y/n):");
            String answer = scanner.nextLine().trim();
            if ("n".equals(answer)) {
                break;
            }
        }

        Order order =new Order(DB.generateOrderId(),currentCashier.getId(),productQuantityMap);
        System.out.println("下单成功,您的购物车如下:");
        System.out.println(order);

        System.out.println("请付款!");
        for (int i = 0; i < 5; i++) {
            try {
                Thread.sleep(1000);
                System.out.print("...");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("付款成功！");

        OrderService.add(order);
    }
    public static void find() {
        System.out.print("请输入订单编号: ");
        int id = new Scanner(System.in).nextInt();
        Order order = OrderService.getById(String.valueOf(id));

        if (order != null) {
            System.out.println("为您查询到了如下结果！");
            System.out.println(order);
        } else {
            System.out.println("订单不存在!");
        }
    }
}
