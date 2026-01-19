package service;

import bean.Log;
import db.DB;

import java.util.List;

public class LogService {
    public static List<Log> logs = DB.db.get("logDB");

    public static void log(String title, String description, Boolean isSuccess, Log.LogType logType, String remark) {
        Log log = new Log(title, description, isSuccess, logType, remark);
        logs.add(log);
    }
    public static List<Log> getAll() {
        log("查看日志", "查看了全部日志记录", true, Log.LogType.日志管理模块日志, "无");
        return logs;
    }
}
