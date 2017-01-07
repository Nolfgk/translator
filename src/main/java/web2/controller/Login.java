package web2.controller;

import web2.model.UserChecker;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by timur on 02.01.17.
 */
public class Login extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        //работаем с базой
//        Session session = HibernateUtil.getSessionFactory().openSession();
//        session.beginTransaction();
//
//        String hql = "FROM web2.hibernate.dto.UserEntity";
//        Query query = session.createQuery(hql);
//        List results = query.list();
//        if (!results.contains(login)){
//        UserEntity user = new UserEntity(login, password);
//        session.save(user);
//        session.getTransaction().commit();
//        }
//        HibernateUtil.shutdown();

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
