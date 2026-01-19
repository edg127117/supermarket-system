package controller.cashRegisterModule;

import bean.Cashier;
import bean.Product;
import controller.systemModule.SystemModule;
import service.CashierService;
import service.ProductService;

import java.util.ArrayList;
import java.util.Scanner;

public class CashierManagementModule {
    public static void menu() {

        boolean isEnd = false;

        while (!isEnd) {

            System.out.println("----------------- 收 银 员 管 理 模 块 --------------------------");
            System.out.println("1.收 银 员 列 表\n2.新 增 收 银 员\n3.移 除 收 银 员\n4.返 回 上 一 级");
            System.out.println("--------------------------------------------------------------");
            System.out.print("\n 请 输 入 您 的 选 择:");

            Scanner scanner = new Scanner(System.in);
            int b = scanner.nextInt();

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
                    SystemModule.menu();
                default:
                    System.out.println("输入错误,请重新输入");
            }
        }

    }
    private static void printAll(){
        ArrayList<Cashier> all = CashierService.getAll();
        System.out.println("--------------------------------------- 收 银 员 列 表 -------------------------------------------------------------");
        System.out.println("\tID\t账号\t\t\t\t密码\t\t\t\t性别\t\t年龄\t\t\t姓名\t\t\t联系方式\t\t\t\t地址\t\t\t电话");
        for (Cashier cashier : all) {
            System.out.println(cashier);
        }
        System.out.println("--------------------------------------- 收 银 员 列 表 -------------------------------------------------------------");
    }
    private static void add(){
        System.out.println("------------- 新 增 收 银 员 ---------------");
        Scanner scanner = new Scanner(System.in);

        System.out.print("请输入id:");
        int id = scanner.nextInt();
        System.out.print("请输入账号:");
        String username = scanner.next();
        System.out.print("请输入密码:");
        String password = scanner.next();
        System.out.print("请输入姓名:");
        String name = scanner.next();
        System.out.print("请输入性别:");
        String sex = scanner.next();
        System.out.print("请输入年龄:");
        int age = Integer.parseInt(scanner.next());
        System.out.print("请输入家庭住址:");
        String address = scanner.next();
        System.out.print("请输入手机号:");
        String phone = scanner.next();

        Cashier cashier = new Cashier(id,username,password, name, sex, age, address, phone);

        CashierService.add(cashier);
    }
    private static void remove(){
        printAll();
        System.out.print("请输入要移除的类型ID: ");
        int id = new Scanner(System.in).nextInt();
        CashierService.remove(id);
    }

}
