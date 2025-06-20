package org.naammm.superapp.loosecoupling.di.v1constructor;

import org.naammm.superapp.tightcoupling.UserRepo;

public class UserService {

    //SRP: TAO GIỎI VỤ CRUD TABLE ACCOUNT, TRONG RAM
    //TỚ CẦN 2 DEPENDENCY, MỖI THẰNG LO 1 VIỆC
    //USER-REPO VÀ EMAIL-SENDER
    private UserRepo userRepo; //có new hay ko, có là tight-coupling
    //lỏng ra, đó là DI @Autowire nghĩa làDI, nghĩa là ko full control

    //@Autowire - AI đó khác new và tiêm chích object vào cho mình service
    private EmailSender emailSender; //ko new thì phải được đưa vào!!!

    //Có nhiều cách đưa obj từ ngoài vào trong 1 class
    //1. Trực tiếp qua field, biến emailSender thành public - nguy hiểm vi phạm, encapsulation, Vẫn muốn qua field mà private - dùng kĩ thuật nâng cao reflection!!!
    //Field injection (Dùng reflection, IoC framework)
    //2. Qua constructor - DI constructor


    public UserService(EmailSender emailSender) {
//        this.userRepo = userRepo; //được inject từ bên ngoài vào
        this.emailSender = emailSender; //được inject từ bên ngoài vào
    }

    public void registerUser(Account account) {
        //TODO: gọi repo để xuống table!!! XÀI DEPENDENCY 1

        //GỬI EMAIL
        emailSender.sendEmail(
            "hehehe@gmail.com",
            "Welcome to our service", ", thank you for registering!"
        );
    }
}
