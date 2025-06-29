package org.naammm.superapp.ngoctrinhcoffee.controller;

import org.naammm.superapp.ngoctrinhcoffee.entity.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/products/edit")
    public String update(@RequestParam("name") String name,
                         @RequestParam("price") String price,
                            @RequestParam("id") String id,
                         Model model) {
        model.addAttribute("msg", "Đã update thành công");
        return "result"; // Trả về tên trang để hiển thị form chỉnh sửa sản phẩm
    }

    @GetMapping("/products/edit/{id}") //tấch url thành 2 phần, 1 cố định 1 thay đổi, phần thay đổi là path variable
    public String showProductForm(Model model, @PathVariable("id") String id) {
        // đã trích ra được id muốn xem chi tiết từ click hyperlink của user
        //tạm thời mock
        Product selectProduct;
        if (id.equalsIgnoreCase("NTCF1")) {
            selectProduct = new Product("NTCF1", "Cà phê Ngọc Trinh", 100_000);
        } else if (id.equalsIgnoreCase("NTCF2")) {
            selectProduct = new Product("NTCF2", "Trà sữa Ngọc Trinh", 50_000);
        } else if (id.equalsIgnoreCase("NTCF3")) {
            selectProduct = new Product("NTCF3", "Sinh tố Ngọc Trinh", 70_000);
        } else {
            selectProduct = new Product("UNKNOWN", "Sản phẩm không tồn tại", 0);
        }
//        new Product("NTCF1", "Cà phê Ngọc Trinh", 100_000);
//        new Product("NTCF2", "Trà sữa Ngọc Trinh", 50_000);
//        new Product("NTCF3", "Sinh tố Ngọc Trinh", 70_000);
        //Throw vào model để Thymeleaf có thể lấy ra
        model.addAttribute("product", selectProduct);
        return "product-form";
    }

//    @GetMapping("/products")
//    public String showProducts() {
//        // Trả về tên trang để hiển thị danh sách sản phẩm
//        return "products"; // Trang products.html sẽ được hiển thị
//    }
    //nguy hiểm 1 chút: url này dành cho cả GET/PUT/POST/.. miễn match url
    //ta cần phân tách: hàm nào dành cho GET, hàm nào dành cho POST

    //Cách viết chuẩn
//    @RequestMapping(path = {"/ngoctrinh", "/products"}, method = RequestMethod.GET)
    //Cách viết ngắn

    @GetMapping(path = {"/ngoctrinh", "/products"})
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
