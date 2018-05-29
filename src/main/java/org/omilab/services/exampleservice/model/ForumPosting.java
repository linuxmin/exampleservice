package org.omilab.services.exampleservice.model;

import javax.persistence.*;
import java.util.Date;

@Entity
public class ForumPosting {

    @Id
    @GeneratedValue
    private Integer postingId;

    @Lob
    @Column( length = 100000 )
    private String postingContent;

    @ManyToOne
    private ForumThread forumThread;

    @ManyToOne
    private ForumUser forumUser;


    @Column(name="creationDate")
    private Date creationDate = new Date();


    public ForumPosting (){}

    public String getCreationDate() {
        return creationDate.toString().substring(0,16);
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }



    public Integer getPostingId() {
        return postingId;
    }

    public void setPostingId(Integer postingId) {
        this.postingId = postingId;
    }

    public String getPostingContent() {
        return postingContent;
    }

    public void setPostingContent(String postingContent) {
        this.postingContent = postingContent;
    }

    public ForumThread getForumThread() {
        return forumThread;
    }

    public void setForumThread(ForumThread forumThread) {
        this.forumThread = forumThread;
    }

    public ForumUser getForumUser() {
        return forumUser;
    }

    public void setForumUser(ForumUser forumUser) {
        this.forumUser = forumUser;
    }
}
