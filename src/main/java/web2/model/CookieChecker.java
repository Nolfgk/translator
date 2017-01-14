package web2.model;

import javax.servlet.http.Cookie;
import java.util.List;

public class CookieChecker {

    public static boolean checkCookie(Cookie[] cookies) {
        List users = UserChecker.getUsers();
        boolean userExist = false;

        for (Cookie cookie : cookies) {
            String username = cookie.getValue();
            for (Object user : users) {
                if (user.toString().startsWith(username)) {
                    userExist = true;
                }
            }
        }
        return userExist;
    }
}