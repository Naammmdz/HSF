package org.naammm.superapp.loosecoupling.di.v3finalfantasy;

public class UserService {
    private SmsSender smsSender;
    private EmailSender emailSender;
    //ko new
    private UserRepo userRepo;
    private NotiService notiService;

    public UserService(UserRepo userRepo, NotiService notiService) {
        this.userRepo = userRepo;
        this.notiService = notiService;
    }

    public UserService(NotiService notiService) {
        this.notiService = notiService;
    }

    //
    public void setNotiService(NotiService notiService) {
        this.notiService = notiService;
    }

//    public void registerAccount(User user) {
//        notiService.sendNoti();
//    }

    public void registerUser(String to, String message) {
        notiService.sendNoti(to, message);


    }


}
