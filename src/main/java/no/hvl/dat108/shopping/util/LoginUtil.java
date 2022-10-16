package no.hvl.dat108.shopping.util;

import no.hvl.dat108.shopping.model.Shoppingitem;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class LoginUtil {

    private final static int MAX_INTERACTIVE_INTERVAL = 60;

    public static void logOutUser(HttpSession session) { session.invalidate(); }

    public static void logInUser(HttpServletRequest request, String password) {

        logOutUser(request.getSession());

        HttpSession session = request.getSession();
        session.setMaxInactiveInterval(MAX_INTERACTIVE_INTERVAL);
        session.setAttribute("password", password);
        session.setAttribute("cart", new Shoppingitem());
    }

    public static boolean isUserLoggedIn(HttpSession session) {

        return session != null
                && session.getAttribute("password") != null
                && session.getAttribute("cart") != null;
    }
}
