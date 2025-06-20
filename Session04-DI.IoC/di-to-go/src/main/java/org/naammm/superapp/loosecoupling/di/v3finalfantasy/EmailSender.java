package org.naammm.superapp.loosecoupling.di.v3finalfantasy;


//
public class EmailSender implements NotiService{
    public void sendEmail(String recipient, String message) {
        //TODO: LOGIC XỬ LÝ GỬI EMAIL: SETUP ACCOUNT ĐẺ ĐÓNG VAI NGƯỜI GỬI
        //  FORMAT EMAIL CHO PRO...
        System.out.println("Mail was sent to:" + recipient);
    }

    @Override
    public void sendNoti(String recipient, String message) {
        System.out.println("Mail was sent to:" + recipient);
    }
}
