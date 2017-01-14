package web2.model;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Projections;
import web2.hibernate.HibernateUtil;
import web2.hibernate.dto.UserEntity;

import javax.servlet.RequestDispatcher;
import java.util.List;

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

    public static boolean addUser(String login, String password){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        String hql = "FROM web2.hibernate.dto.UserEntity";
        Query query = session.createQuery(hql);
        List results = query.list();
        System.out.println(results);
        boolean loginExist=false;
        for (Object user : results){
            if (user.toString().startsWith(login)){
                loginExist=true;
            }
        }
        if (!loginExist) {
            System.out.println("not contains");
            UserEntity user = new UserEntity(login, password);
            session.save(user);
            session.getTransaction().commit();
            HibernateUtil.shutdown();
            return true;
        } else {
            HibernateUtil.shutdown();
            System.out.println("already contains");
            return false;
        }
    }

    static List getUsers(){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        String hql = "FROM web2.hibernate.dto.UserEntity";
        Query query = session.createQuery(hql);
        List results = query.list();
        HibernateUtil.shutdown();
        return results;

    }




}
