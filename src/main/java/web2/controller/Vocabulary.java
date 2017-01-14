package web2.controller;

import java.io.IOException;
import java.util.HashMap;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web2.model.CookieChecker;
import web2.model.YandexTranslator;

public class Vocabulary extends HttpServlet {
    public Vocabulary() {
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");

        Cookie[] cookies = req.getCookies();
        if(cookies != null) {
            if(CookieChecker.checkCookie(cookies)) {
                String var10 = req.getParameter("text");
                String var11 = req.getParameter("lang");
                HashMap translation = null;

                try {
                    translation = YandexTranslator.translateText(var10, var11);
                } catch (Exception var9) {
                    var9.printStackTrace();
                }

                req.setAttribute("translation", translation.get("translation"));
                req.setAttribute("meaning", translation.get("meaning"));
                req.setAttribute("synonim", translation.get("synonim"));
                req.setAttribute("text", req.getParameter("text"));
                req.setAttribute("lang", req.getParameter("lang"));
                RequestDispatcher view = req.getRequestDispatcher("translationresult.jsp");
                view.forward(req, resp);
            } else {
                resp.setStatus(302);
                resp.sendRedirect("http://localhost:34505/loginpage.html");
            }
        } else {
            resp.setStatus(302);
            resp.sendRedirect("http://localhost:34505/loginpage.html");
        }

    }
}