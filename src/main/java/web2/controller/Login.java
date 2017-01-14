package web2.controller;

import web2.model.UserChecker;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Login extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");

        if(UserChecker.checkUser(login, password)){
            req.setAttribute("login", login);
            req.setAttribute("password", password);
            Cookie cookie = new Cookie("username", login);
            cookie.setMaxAge(30*60);
            resp.addCookie(cookie);
        } else {
            req.setAttribute("login", "wrong, try again.");
            req.setAttribute("password", "wrong, try again.");
        }
            RequestDispatcher view = req.getRequestDispatcher("loginresult.jsp");
            view.forward(req, resp);
    }

}
