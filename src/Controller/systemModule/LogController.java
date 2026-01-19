package controller.systemModule;

import bean.Log;
import service.LogService;

import java.util.List;

public class LogController {
    public static void menu() {
        printAll();
    }
    public static void printAll() {
        System.out.println("------------------------------------------ 日 志 记 录 --------------------------------------------------------");
        //循环输出
        List<Log> all = LogService.getAll();
        all.stream().forEach(System.out::println);
        System.out.println("------------------------------------------ 日 志 记 录 --------------------------------------------------------");
        System.out.println("\t共计" + all.size() + "条记录。");
    }
}
