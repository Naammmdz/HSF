package org.naammm.superapp.tightcoupling;

public class MainTightCoupling {
    public static void main(String[] args) {
        /*
            CLASS MAIN NÀY ĐÓNG VAI TRÒ UI, CONTROLLER, GỌI, ĐIÈU KHIỂN NHỮNG CLASS Ở TẦNG DƯỚI: SERVICE, REPO, JPAUTIL
            SAU NÀY THAY BẰNG WEBPAGE, GUI
         */
        UserService userService = new UserService();
        userService.registerUser(new Account());
    }
}
