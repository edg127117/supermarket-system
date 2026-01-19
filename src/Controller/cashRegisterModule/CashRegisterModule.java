package controller.cashRegisterModule;
import bean.*;
import controller.productModule.ProductModule;
import db.DB;
import service.LogService;
import service.UserService;
import systemmodule.IndexController;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CashRegisterModule {
    public static void login () {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Cashier> calendars = DB.db.get("cashierDB");
        System.out.println("\n========== 收银员操作界面 ==========");

        System.out.println("请登录您的收银员身份:");
        System.out.print("用户名: ");
        String username = scanner.nextLine();
        System.out.print("密码: ");
        String password = scanner.nextLine();

        User user = UserService.getUser(username, password);
        if (user != null && "cashier".equals(user.getRole())) {
            for (Cashier cashier : calendars) {
                if (cashier.getUsername() ==username){
                   int id= cashier.getId();

                    LoginCashier cashiers = new LoginCashier(id,username);
                    LoginSession.setCurrentCashier(cashiers);
                    LogService.log("尝试登录", "使用【账号:" + username + ",密码:" + password + "】登录", true, Log.LogType.收银员登录日志, "账号密码正确");
                    System.out.println("身份验证通过，欢迎!");
                    menu();
                }
            }
        } else {
            LogService.log("尝试登录", "使用【账号:" + username + ",密码:" + password + "】登录", false, Log.LogType.收银员登录日志, "账号密码验证错误");
            System.out.println("收银员身份验证失败！");
        }
    }
    public static void menu () {
        boolean isEnd = false;

        while (!isEnd) {
            System.out.println("------------ 收 银 模 块  -----------------");
            System.out.println("1.新 增 订 单 \n2.订 单 列 表\n3.查 找 订 单 \n4.返回上一级");

            System.out.print("\n 请 输 入 您 的 选 择:");
            Scanner scanner = new Scanner(System.in);
            int b = scanner.nextInt();

            switch (b) {
                case 1:
                    OrderController.add();
                    break;
                case 2:
                    OrderController.printAll();
                    break;
                case 3:
                    OrderController.find();
                    break;
                case 4:
                    IndexController.run();
                default:
                    System.out.println("输入错误,请重新输入");
            }
        }
        System.out.println("\t\t\t ------------ 收 银 模 块 结 束 -----------------");
    }
}
