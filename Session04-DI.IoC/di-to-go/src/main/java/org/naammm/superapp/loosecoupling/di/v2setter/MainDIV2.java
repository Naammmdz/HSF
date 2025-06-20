package org.naammm.superapp.loosecoupling.di.v2setter;

import org.naammm.superapp.loosecoupling.di.v2setter.UserService;

public class MainDIV2 {
    public static void main(String[] args) {
        EmailSender sender = new EmailSender();
        UserService service = new UserService();
        service.setSender(sender);
        service.registerUser(new Account());

        //
    }
}
