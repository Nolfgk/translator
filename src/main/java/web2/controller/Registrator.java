package web2.controller;

import org.hibernate.Query;
import org.hibernate.Session;
import web2.hibernate.HibernateUtil;
import web2.hibernate.dto.UserEntity;
import web2.model.UserChecker;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


public class Registrator extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String login = req.getParameter("login");
        String password = req.getParameter("password");

        if(UserChecker.addUser(login,password)){
            resp.setStatus(302);
            resp.sendRedirect("http://localhost:34505/loginpage.html");
        }   else {
            req.setAttribute("login", "already exist.");
            req.setAttribute("password", "not needed, try another login.");
            RequestDispatcher view = req.getRequestDispatcher("registerresult.jsp");
            view.forward(req, resp);
        }
    }
}

