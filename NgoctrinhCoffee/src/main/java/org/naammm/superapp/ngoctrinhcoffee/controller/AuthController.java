package org.naammm.superapp.ngoctrinhcoffee.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AuthController {
    @GetMapping("/login")
    public String showLoginForm() {
        // Trả về tên trang để hiển thị form đăng nhập
        return "login"; // Trang login.html sẽ được hiển thị
    }

    @PostMapping("/login")
    public String login() {
        // Xử lý đăng nhập ở đây
        // Ví dụ: kiểm tra thông tin đăng nhập, xác thực người dùng, v.v.

        // Trả về tên trang để hiển thị sau khi đăng nhập thành công
        return "/ngoctrinh"; // Chuyển hướng đến trang home sau khi đăng nhập
    }
}
