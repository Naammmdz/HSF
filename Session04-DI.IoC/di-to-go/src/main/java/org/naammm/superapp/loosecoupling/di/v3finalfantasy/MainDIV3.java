package org.naammm.superapp.loosecoupling.di.v3finalfantasy;

public class MainDIV3 {

    public static void main(String[] args) {
        EmailSender emailSender = new EmailSender();

        //dùng service để gửi
        UserService userService = new UserService(emailSender);
        userService.registerUser("nam@gmail.com", "hhehehe");

        SmsSender smsSender = new SmsSender();
        userService.setNotiService(smsSender);
        userService.registerUser("0123456789", "hhehehe sms");

        WhatsAppSender whatsAppSender = new WhatsAppSender();
        userService.setNotiService(whatsAppSender);
        userService.registerUser("HEHEHE", "hhehehe whatsapp");

        NotiService tele = new NotiService() {
            @Override
            public void sendNoti(String recipient, String message) {
                System.out.println("Annonymous class, DI, OCP" + recipient + ": " + message);
            }
        };

        //gửi confirm
        userService.setNotiService(tele);
        userService.registerUser("telegram", "hhehehe telegram");
    }
}
