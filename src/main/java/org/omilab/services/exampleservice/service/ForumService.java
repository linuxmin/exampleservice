package org.omilab.services.exampleservice.service;

import org.omilab.services.exampleservice.model.ForumPosting;
import org.omilab.services.exampleservice.model.ForumThread;
import org.omilab.services.exampleservice.model.ForumUser;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ForumService {
    

    public ForumThread findThread(Integer forumThreadId);
    public List<ForumThread> searchThread(String threadTitle);
    public List<ForumThread> findAllThreads();
    public ForumThread saveThread(ForumThread forumThread);

    public List<ForumPosting> findThreadPostings(Integer forumThreadId);
    public List<ForumPosting> findUserPostings(Integer forumUserId);
    public ForumPosting savePosting(ForumPosting forumPosting);
    public void deletePosting(Integer postingId);

    public ForumUser findUser(Integer userId);
    public ForumUser findUserByUserNameAndUserPassword(String userName, String userPassword);
    public ForumUser findUserByUserName(String userName);
    public ForumUser saveUser(ForumUser f);


}
