package org.naammm.superapp.tightcoupling;

public class EmailSender {
    //TUI, CHUYÊN GỬI EMAIL, TUI KHÔNG DÍNH DÁNG GÌ ĐẾN SMS
    //TUI CHỈ CHỨA NHIỀU HÀM CHUYÊN XỬ LÍ CÁC TÍNH NĂNG LIÊN QUAN ĐẾN EMAIL
    //SAU NÀY NÂNG CẤP CODE, CŨNG CHỈ LÀ XOAY QUANH EMAIL, 1 LÍ DO/CHỦ THỂ SỬA ĐỔI
    public void sendEmail(String recipient, String message, String body) {
        //TODO: LOGIC XỬ LÝ GỬI EMAIL: SETUP ACCOUNT ĐẺ ĐÓNG VAI NGƯỜI GỬI
        //  FORMAT EMAIL CHO PRO...
        System.out.println("Mail was sent to:" + recipient);
    }
}
