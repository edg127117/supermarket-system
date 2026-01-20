package controller.systemModule;

import controller.userModule.UserModule;
import systemmodule.IndexController;

import java.util.Scanner;

public class SystemModule {
    public static void menu() {
        boolean isEnd = false;

        while (!isEnd) {
            System.out.println("--------------- 系 统 管 理 ---------------------");
            System.out.println("1.收 银 员 管 理 \n2.日 志 管 理\n3.返 回 上 级");
            System.out.println("--------------- 系 统 管 理 ---------------------");

            System.out.print("\n 请 输 入 您 的 选 择:");

            Scanner scanner = new Scanner(System.in);
            int b = scanner.nextInt();

            switch (b) {
                case 1:
                    UserModule.userLogin();
                    break;
                case 2:
                    LogController.menu();
                    break;
                case 3:
                    IndexController.run();
                default:
                    System.out.println("输入错误,请重新输入");
            }
        }
    }
}
