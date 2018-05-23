package org.omilab.services.exampleservice.model;

import javax.persistence.*;

@Entity
 @Table(name = "forumuser",
         uniqueConstraints = @UniqueConstraint(name="uname", columnNames = "user_name"))
public class ForumUser {
    @Id
    @GeneratedValue
    private Integer userId;

    @Column
    private String userName;

    @Column
    private String userPassword;

    @Column String userMail;

    public ForumUser(){}

    public void setUserData(String userName, String userPassword, String userMail){
        setUserName(userName);
        setUserPassword(userPassword);
        setUserMail(userMail);
    }

    public String getUserMail() {
        return userMail;
    }

    public void setUserMail(String userMail) {
        this.userMail = userMail;
    }

    public Integer getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }
}
