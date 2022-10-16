package no.hvl.dat108.shopping.controller;

import no.hvl.dat108.shopping.model.Shoppingitem;
import no.hvl.dat108.shopping.service.ShoppingService;
import no.hvl.dat108.shopping.util.LoginUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
public class ShoppingController {

    @Value("${app.message.requiresLogin}") private String REQUIRES_LOGIN_MESSAGE;
    @Value("${app.url.login}") private String LOGIN_URL;
    @Value("${app.url.shopping}") private String SHOPPING_URL;

    @Autowired
    ShoppingService shoppingService;

    @RequestMapping(value = "/shopping", method = RequestMethod.GET)
    public String showShopping(HttpSession session, RedirectAttributes ra) {

        if (!LoginUtil.isUserLoggedIn(session)) {
            ra.addFlashAttribute("redirectMessage", REQUIRES_LOGIN_MESSAGE);
            return "redirect:" + LOGIN_URL;
        }
        ra.addFlashAttribute("shoppingitems", shoppingService.retrieveShoppingitems());
        return "shopping";
    }

    @RequestMapping(value = "/shopping", method = RequestMethod.POST)
    public String addShoppingitem(@Valid Shoppingitem item,
                                  HttpSession session, RedirectAttributes ra) {

        if (!LoginUtil.isUserLoggedIn(session)) {
            ra.addFlashAttribute("redirectMessage", REQUIRES_LOGIN_MESSAGE);
            return "redirect:" + LOGIN_URL;
        }

        shoppingService.addShoppingitem(item.getName());
        return "redirect:" + SHOPPING_URL;
    }

    @RequestMapping(value = "/delete-shoppingitem", method = RequestMethod.GET)
    public String deleteShoppingitem(@RequestParam int id,
                                     HttpSession session, RedirectAttributes ra) {

        if (!LoginUtil.isUserLoggedIn(session)) {
            ra.addFlashAttribute("redirectMessage", REQUIRES_LOGIN_MESSAGE);
            return "redirect:" + LOGIN_URL;
        }

        shoppingService.deleteShoppingitem(id);
        return "redirect:" + SHOPPING_URL;
    }
}
