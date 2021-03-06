package org.omilab.services.exampleservice.model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
 @Table(name = "forumuser",
         uniqueConstraints = @UniqueConstraint(name="uname", columnNames = "user_name"))
public class ForumUser {
    @Id
    @GeneratedValue
    private Integer userId;

    @Column(name = "user_name")
    private String userName;

    @Column
    private String userPassword;

    @Column
    private String userMail;

    @Column(name="creationDate")
    private Date creationDate = new Date();

    @OneToMany(mappedBy = "forumUser", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    private List<ForumThread> forumThreads;

    @OneToMany(mappedBy = "forumUser", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    private List<ForumPosting> forumPostings;

    public ForumUser(){}

    public String getCreationDate() {
        return creationDate.toString().substring(0,16);
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public List<ForumThread> getForumThreads() {
        return forumThreads;
    }

    public void setForumThreads(List<ForumThread> forumThreads) {
        this.forumThreads = forumThreads;
    }

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
