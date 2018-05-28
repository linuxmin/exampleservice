package org.omilab.services.exampleservice.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "forumthread",
        uniqueConstraints = @UniqueConstraint(name="ttitle", columnNames = "thread_title"))
public class ForumThread {

    @Id
    @GeneratedValue
    private Integer threadId;

    @Column(name = "thread_title")
    private String threadTitle;

    @ManyToOne
    private ForumUser forumUser;

    @OneToMany(mappedBy = "forumThread", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    private List<ForumPosting> forumPostings;

    public ForumThread(){}

    public List<ForumPosting> getForumPostings() {
        return forumPostings;
    }

    public void setForumPostings(List<ForumPosting> forumPostings) {
        this.forumPostings = forumPostings;
    }

    public Integer getThreadId() {
        return threadId;
    }

    public void setThreadId(Integer threadId) {
        this.threadId = threadId;
    }

    public String getThreadTitle() {
        return threadTitle;
    }

    public void setThreadTitle(String threadTitle) {
        this.threadTitle = threadTitle;
    }

    public ForumUser getForumUser() {
        return forumUser;
    }

    public void setForumUser(ForumUser forumUser) {
        this.forumUser = forumUser;
    }
}
