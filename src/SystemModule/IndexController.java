package systemmodule;

import controller.cashRegisterModule.CashRegisterModule;
import controller.productModule.ProductModule;
import controller.systemModule.SystemModule;

import java.util.Scanner;

public class IndexController {
    public static void run() {

        System.out.println("\t\t\t 欢 迎 来 到 超 市 管 理 系 统 ~ ~ ~");

        boolean isEnd = false;

        while (!isEnd) {
            System.out.println("------------------------------------------------------");
            System.out.println("1.收 银 模 块 \n2.商 品 模 块\n3.系 统 模 块\n4.退 出 系 统");
            System.out.println("------------------------------------------------------");

            System.out.print("\n 请 输 入 您 的 选 择:");
            Scanner scanner = new Scanner(System.in);
            int b = scanner.nextInt();

            switch (b) {
                case 1:
                    CashRegisterModule.login();
                    break;
                case 2:
                    ProductModule.menu();
                    break;
                case 3:
                    SystemModule.menu();
                    break;
                case 4:
                    isEnd = true;
                    break;
                default:
                    System.out.println("输入错误,请重新输入");
            }
        }
        System.out.println(" 感 谢 使 用，欢 迎 下 次 再 来 !");

    }
}
