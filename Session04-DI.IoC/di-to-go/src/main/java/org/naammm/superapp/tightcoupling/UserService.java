package org.naammm.superapp.tightcoupling;

public class UserService {

    //Có ít nhất 2 dependency: UserRepo, EmailSender
    //1. UserRepo: CRUD table Account
    // 2. EmailSender: gửi email cho người dùng
    private UserRepo userRepo = new UserRepo(); //dependency, tight coupling, chủ động quản lí object dependency
    private EmailSender emailSender = new EmailSender(); //dependency, tight coupling, chủ động quản lí object dependency
    //new Service, có luôn 2 chú này đc new luôn!!!
    //hard-coded dependency, cứng dependency vào đây

    //CÓ NHIỀU HÀM LIÊN QUAN ĐẾN TABLE USER
    //getAllAccounts() findByEmail() findByPhone() updateAccount()

    //nhận vào full thông tin của người dùng, lưu vào db, gửi email thông báo
    public void registerUser(Account account) {
        //TODO: gọi repo để xuống table!!! XÀI DEPENDENCY 1

        emailSender.sendEmail(
            "hehehe",
            "Welcome to our service",", thank you for registering!"
        );
    }
}
