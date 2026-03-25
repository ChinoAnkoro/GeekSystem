package main.java.com.example.demo.controller;

import jakarta.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LogoutController {

	@GetMapping("/admin/logout")
    public String logout(HttpSession session) {

        // セッション削除
        session.invalidate();

        // ログイン画面へ
        return "redirect:/admin/signin";
    }
}
