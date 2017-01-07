package web2.model;

import org.hibernate.Query;
import org.hibernate.Session;
import web2.hibernate.HibernateUtil;
import web2.hibernate.dto.UserEntity;

import javax.servlet.RequestDispatcher;
import java.util.List;

/**
 * Created by timur on 07.01.17.
 */
public class UserChecker {
    public static boolean checkUser(String login, String password){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        String hql = "FROM web2.hibernate.dto.UserEntity";
        Query query = session.createQuery(hql);
        System.out.println(hql);

        List results = query.list();
        System.out.println(results);
        if (results.toString().contains(login+' '+ password)){
            System.out.println(true);
            HibernateUtil.shutdown();
            return true;
        } else {
        HibernateUtil.shutdown();
        System.out.println(false);
        return false;}
    }



}
