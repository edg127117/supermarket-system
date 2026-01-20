package service;

import bean.Cashier;
import bean.Log;
import db.DB;

import java.util.ArrayList;

public class CashierService {
    private static ArrayList<Cashier> calendars = DB.db.get("cashierDB");

    public static ArrayList<Cashier> getAll() {
        LogService.log("查看所有收银员", "查看了所有的收银员信息", true, Log.LogType.收银员管理模块日志, "无");
        return calendars;
    }

    public static Cashier getById(int id) {
        for (Cashier calendar : calendars) {
            if (calendar.getId() == id) {
                return calendar;
            }
        }
        return null;
    }

    public static void add(Cashier cashier) {
        LogService.log("添加收银员", "添加了一个收银员:" + cashier.getName(), true, Log.LogType.收银员管理模块日志, "无");
        calendars.add(cashier);
    }

    public static void remove(int id) {
        Cashier cashier = new Cashier();
        cashier.setId(id);
        boolean remove = calendars.remove(cashier);
        if (remove) {
            System.out.println("移除收银员成功!");
            LogService.log("删除收银员", "删除了ID为" + id + "的收银员", true, Log.LogType.收银员管理模块日志, "无");
        } else {
            System.out.println("移除失败，该收银员不存在!");
            LogService.log("删除收银员", "尝试删除ID为" + id + "的收银员", false, Log.LogType.收银员管理模块日志, "该ID不存在");
        }
    }
}
