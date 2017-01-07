package web2.hibernate.dto;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Set;

public class UserEntity implements Serializable{
    private static final long serialVersionUID = -1798070712343154676L;

    public UserEntity(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public UserEntity() {
    }

    @Override
    public String toString() {
        return login+' '+ password;
    }

    public String getUser(){
        return(login+" "+ password);
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    private long id;

    private String login;

    private String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }


}
