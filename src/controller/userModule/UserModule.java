package controller.userModule;

import bean.User;
import controller.cashRegisterModule.CashierManagementModule;
import service.UserService;

import java.util.Scanner;

public class UserModule {
    private static Scanner scanner = new Scanner(System.in);
    public static void userLogin() {
        System.out.println("\n========== 用户管理系统登录 ==========");
        boolean isEnd = false;
        while (!isEnd) {
            System.out.print("用户名: ");
            String username = scanner.nextLine().trim();

            System.out.print("密码: ");
            String password = scanner.nextLine().trim();

            User user = UserService.getUser(username, password);
            if (user != null) {
                System.out.println("\n登录成功！欢迎，" + user.getUsername() + "!");
                CashierManagementModule.menu();
                isEnd = true;
            }else {
                System.out.println("\n用户名或密码错误，请重试！");
                System.out.println("1. 重新登录");
                System.out.println("2. 退出系统");
                System.out.print("请选择: ");

                String answer = scanner.nextLine().trim();
                if ("2".equals(answer)) {
                    System.out.println("系统退出。");
                    isEnd = true;
                }
            }
        }
    }
}
