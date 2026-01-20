package service;

import bean.User;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class UserService {
    private static final String CONFIG_FILE = "db.properties";
    private static Properties props = new Properties();

    static {
        try (InputStream input = UserService.class.getClassLoader().getResourceAsStream(CONFIG_FILE)){
            if (input == null) {
                System.out.println("没有找到配置文件 " + CONFIG_FILE);
                System.exit(1);
            }
            props.load(input);

        }catch (IOException e ) {
            e.printStackTrace();
            System.exit(1);
        }
    }
    public static User getUser(String username, String password) {
        String adminUser = props.getProperty("admin.username");
        String adminPass = props.getProperty("admin.password");
        if (username.equals(adminUser)){
            if (password.equals(adminPass)) {
                return new User(username, password, "admin");
            }
            return null;
        }

        String cashierUser = props.getProperty("cashier.username");
        String cashierPass = props.getProperty("cashier.password");
        if (username.equals(cashierUser)) {
            if (password.equals(cashierPass)) {
                return new User(username, password, "cashier");
            }
            return null;
        }
       return null;
    }
}
