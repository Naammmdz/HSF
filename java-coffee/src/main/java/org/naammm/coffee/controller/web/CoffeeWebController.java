package org.naammm.coffee.controller.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller//1 bean được new tự động bowr Container, chuyên trả lời các request từ url của trình duyệt người dùng
//Có nhiều url khác nhâu, thì ứng với nhiều hàm trong class này
//các hàm trả về html, trang web lung linh
public class CoffeeWebController {

    @GetMapping("/") //user gõ localhost:8080/ thì sẽ gọi hàm này
    public  String home(Model model) {

        model.addAttribute("coffee", "Cafe Java đậm đà vị Ngọc Trinh");
        return "index"; //trả về tên trang cho trình duyệt
    }
}
