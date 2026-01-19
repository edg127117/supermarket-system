package bean;

import utils.DateTimeUtil;

import java.util.StringJoiner;

public class Log {

    private static long count = 0;

    private Long id;

    private String title;


    private String description;

    private String dateTime;

    private Boolean isSuccess;


    private LogType logType;

    private String remark;

    public Log() {
    }

    public Log(String title, String description, Boolean isSuccess, LogType logType, String remark) {
        this.id = ++count;
        this.title = title;
        this.description = description;
        this.isSuccess = isSuccess;
        this.logType = logType;
        this.remark = remark;
        this.dateTime = DateTimeUtil.getNowDateTime();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public boolean isSuccess() {
        return isSuccess;
    }

    public void setSuccess(boolean success) {
        isSuccess = success;
    }

    @Override
    public String toString() {
        return new StringJoiner("\t", id + "\t", "")
                .add(dateTime)
                .add("" + logType)
                .add((isSuccess ? "成功" : "失败"))
                .add("\t" + title)
                .add(":" + description)
                .add("\t\t备注:" + remark)
                .toString();
    }

    public enum LogType {
        收银员管理模块日志,
        日志管理模块日志,
        收银员登录日志,
        订单模块日志,
        商品模块日志,
    }
}
