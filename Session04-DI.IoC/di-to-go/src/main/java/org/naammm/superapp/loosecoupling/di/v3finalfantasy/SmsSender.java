package org.naammm.superapp.loosecoupling.di.v3finalfantasy;

public class SmsSender implements NotiService {
    public void sendSms(String phoneNumber, String message) {
        // Logic to send SMS
        System.out.println("Sending SMS to " + phoneNumber + ": " + message);
    }

    @Override
    public void sendNoti(String recipient, String message) {
        System.out.println("Sending SMS to " + recipient + ": " + message);
    }
}
