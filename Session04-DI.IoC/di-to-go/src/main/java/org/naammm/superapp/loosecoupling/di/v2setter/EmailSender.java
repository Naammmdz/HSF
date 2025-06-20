package org.naammm.superapp.loosecoupling.di.v2setter;

public class EmailSender {
    public void sendEmail(String recipient, String message, String body) {
        //TODO: LOGIC XỬ LÝ GỬI EMAIL: SETUP ACCOUNT ĐẺ ĐÓNG VAI NGƯỜI GỬI
        //  FORMAT EMAIL CHO PRO...
        System.out.println("Mail was sent to:" + recipient);
    }
}
