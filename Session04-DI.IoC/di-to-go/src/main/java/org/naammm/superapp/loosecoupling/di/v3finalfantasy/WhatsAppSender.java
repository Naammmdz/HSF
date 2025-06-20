package org.naammm.superapp.loosecoupling.di.v3finalfantasy;

public class WhatsAppSender implements NotiService{
    @Override
    public void sendNoti(String recipient, String message) {

        // Logic to send WhatsApp message
        System.out.println("Sending WhatsApp message to " + recipient + ": " + message);
    }
}
