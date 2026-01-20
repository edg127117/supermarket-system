package controller.cashRegisterModule;

import bean.LoginCashier;

public class LoginSession {
    private static LoginCashier currentCashier;

    public static void setCurrentCashier(LoginCashier cashier) {
        currentCashier = cashier;
    }

    public static LoginCashier getCurrentCashier() {
        return currentCashier;
    }
}
