package org.omilab.services.exampleservice.model;

import javax.persistence.*;

@Entity
public class ForumPosting {

    @Id
    @GeneratedValue
    private Integer postingId;

    @Column
    private String postingContent;

    @ManyToOne
    private ForumThread forumThread;

    @ManyToOne
    private ForumUser forumUser;


    public ForumPosting (){}



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
