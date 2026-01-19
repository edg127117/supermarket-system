import controller.productModule.ProductController;
import controller.userModule.UserModule;
import db.DB;

public class Text {
    public static void main(String[] args) {
        DB.init();
        //ProductController.menu();
        UserModule.userLogin();
    }
}
