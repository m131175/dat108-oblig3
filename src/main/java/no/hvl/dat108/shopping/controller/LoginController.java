package no.hvl.dat108.shopping.controller;

import no.hvl.dat108.shopping.util.InputValidator;
import no.hvl.dat108.shopping.util.LoginUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/login")
public class LoginController {

    @Value("${app.message.invalidPassword}") private String INVALID_PASSWORD_MESSAGE;
    @Value("${app.url.login}") private String LOGIN_URL;
    @Value("${app.url.shopping}") private String SHOPPING_URL;

    @GetMapping
    public String showLoginPage() { return "login"; }

    @PostMapping
    public String onLogin(@RequestParam String password,
                          HttpServletRequest request, RedirectAttributes ra) {

        if (!InputValidator.isValidPassword(password)) {
            ra.addFlashAttribute("redirectMessage", INVALID_PASSWORD_MESSAGE);
            return "redirect:" + LOGIN_URL;
        }

        LoginUtil.logInUser(request, password);
        return "redirect:" + SHOPPING_URL;
    }
}
