package org.naammm.superapp.loosecoupling.di.v2setter;

//GUI --- CONTROLLER --- SERVICE --- REPO (JPA/HIBERNATE CRUD) --- TABLE
public class UserService {

    //CHUÊN XỬ LÍ DATA VỀ USER/ACCOUNT TRONG RAM, SAU ĐÓ GỌI REPO ĐỂ XUỐNG TABLE
    //TA CẦN TRỢ GIÚP TỪ NGOÀI 2 VIỆC/2 DEPENDENCY: REPO, SENDER GỬI CONFIRM
    //TA KO TỰ NEW, KHÔNG NUÔI 2 THẰNG NÀY, BÊN NGOÀI TIÊM CHÍCH VÀO, GỌI DỊCH VỤ
    //C1: FIELD
    //C2: CONSTRUCTOR
    // C3: SETTER
    //C4: DÙNG FRAMEWORK
    private UserRepo repo;
    private EmailSender sender;

    public void setRepo(UserRepo repo) {
        this.repo = repo;
    }

    public void setSender(EmailSender sender) {
        this.sender = sender;
    }

    //NẾU QUA CONSTRUCTOR, BẠN KO ĐƯA VÀO CTOR, THÌ KHÔNG NEW ĐƯỢC, VÌ CTOR YÊU CẦU PHẢI ĐƯA THAM SỐ VÀO THÌ MỚI TRỌN VẸN VIỆC GỌI HÀM

    public void registerUser(Account account) {
        //GỬI EMAIL
        sender.sendEmail(
                "hehehe@gmail.com",
                "Welcome to our service", ", thank you for registering!"
        );
    }
}
