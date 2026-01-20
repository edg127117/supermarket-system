package controller.productModule;

import systemmodule.IndexController;

import java.util.Scanner;

public class ProductModule {
    public static void menu() {

        System.out.println("--------------- 商 品 模 块 ---------------------");

        boolean isEnd = false;

        while (!isEnd) {
            System.out.println("1.商 品 管 理 \n2.商 品 类 型 管 理\n3.返 回 上 级");
            System.out.println("--------------- 系 统 管 理 ---------------------");

            System.out.print("\n 请 输 入 您 的 选 择:");
            Scanner sc = new Scanner(System.in);
            int b=sc.nextInt();
            switch (b) {
                case 1:
                    ProductController.menu();
                    break;
                case 2:
                    ProductTypeController.menu();
                    break;
                case 3:
                    IndexController.run();
                default:
                    System.out.println("输入错误,请重新输入");
            }
        }
    }
}
