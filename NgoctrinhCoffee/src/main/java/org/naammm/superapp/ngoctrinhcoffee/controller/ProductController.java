package org.naammm.superapp.ngoctrinhcoffee.controller;

import org.naammm.superapp.ngoctrinhcoffee.entity.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

//class này sẽ lo xử lí liên quan đến sản phẩm product
//CRUD product nhưng ở góc độ xử lí request, respone
//NHƯNG LÁT HỒI NÓ SẼ KÍNH CHUYỂN DẦN CHO SERVICE, REPO
//NÓ LẮNG NGHE CÁC URL VÀ XEM URL NÀO HỢP VỚI HÀM CỦA NÓ
//QUAN TRỌNG: 1 URL GET -> ỨNG VỚI 1 HÀM RETURN TRANG NÀO ĐÓ
//                      -> HÀM PHẢI NẰM TRONG 1 CLASS @Controller
//                      -> GET CÓ NGHĨA LÀ MUỐN LẤY 1 TRNG THÔNG TIN
@Controller
public class ProductController {

    //

    @GetMapping("/products")
    public String showProducts() {
        // Trả về tên trang để hiển thị danh sách sản phẩm
        return "products"; // Trang products.html sẽ được hiển thị
    }

    @RequestMapping("/ngoctrinh")
    public String list(Model model) { //list nghĩa là show danh sách sản phẩm
                            // nằm trong trang products.html
        model.addAttribute("message", "Danh sách sản phẩm Ngọc Trinh Coffee");
        List<Product> productList = new ArrayList<>();
        productList.add(new Product("NTCF1", "Cà phê Ngọc Trinh", 100_000));
        productList.add(new Product("NTCF2", "Trà sữa Ngọc Trinh", 50_000));
        productList.add(new Product("NTCF3", "Sinh tố Ngọc Trinh", 70_000));
        model.addAttribute("products", productList); // Đưa danh sách sản phẩm vào model

        return "products";
    }

    //KHI CONTROLLER TÌM THẤ HÀM XỬ LÍ URL TƯƠNG ỨNG, NÓ SẼ GỌI HÀM NÀY
    //NHƯNG TRƯỚC KHI GỌI, NÓ GỬI CHO HÀM 1 THÙNG CHỨA ĐỒ RỖNG GỌI LÀ MODEL
    //MÌNH NHÉT DATA VÀO THÙNG CHỨA ĐỒ NÀY, THÙNG ĐỒ MODEL ĐC NEW TỰ ĐỘNG VÀ CHÍCH VÀO HÀM XỬ LÍ URL

    //TRƯỚC KHI THỰC THI LỆNH RETURN CHO URL GET... THÌ SPRING SẼ ĐÍNH KÈM CÁI THÙNG ĐỒ VÀO CÙNG TRANG TRẢ VỀ, VÀ ĐƯA TEN TRANG + THÙNG ĐỒ CHO THYMELEAF MIX, TRỘN, RENDER
    //THYMELEAF SẼ LẤY ĐỒ TRONG THÙNG, TRỌN VỚI CÁC TAG HTML, TRỘN XONG, TRẢ CHO TOMCAT TRANG WEB HTML NGON -> ĐẨY VỀ TRÌNH DUYỆT USER!!!

    //CÂU HỎI: LÀM SAO NHÉT ĐỒ - DATA VÀO THÙNG, VÀ LẤY RA

}
