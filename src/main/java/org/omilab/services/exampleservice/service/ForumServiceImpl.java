package org.omilab.services.exampleservice.service;

import org.omilab.services.exampleservice.model.ForumPosting;
import org.omilab.services.exampleservice.model.ForumThread;
import org.omilab.services.exampleservice.model.ForumUser;
import org.omilab.services.exampleservice.repo.ForumPostingRepository;
import org.omilab.services.exampleservice.repo.ForumThreadRepository;
import org.omilab.services.exampleservice.repo.ForumUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component("ForumService")
@Transactional
public class ForumServiceImpl implements ForumService{

    private final ForumUserRepository forumUserRepository;
    private final ForumThreadRepository forumThreadRepository;
    private final ForumPostingRepository forumPostingRepository;
    
    @Autowired
    public ForumServiceImpl(ForumUserRepository forumUserRepository, 
                            ForumThreadRepository forumThreadRepository,
                            ForumPostingRepository forumPostingRepository){
        this.forumUserRepository = forumUserRepository;
        this.forumThreadRepository= forumThreadRepository;
        this.forumPostingRepository = forumPostingRepository;
    }

    @Override
    public ForumThread findThread(Integer forumThreadId) {
        return forumThreadRepository.findByThreadId(forumThreadId);
    }

    @Override
    public List<ForumThread> searchThread(String threadTitle) {
        return forumThreadRepository.findByThreadTitleContainingIgnoreCase(threadTitle);
    }

    @Override
    public List<ForumThread> findAllThreads() {
        return forumThreadRepository.findAll();
    }

    @Override
    public ForumThread saveThread(ForumThread forumThread) {
        return forumThreadRepository.save(forumThread);
    }

    @Override
    public List<ForumPosting> findThreadPostings(Integer forumThreadId) {
        return forumPostingRepository.findAllByForumThread_ThreadId(forumThreadId);
    }

    @Override
    public List<ForumPosting> findUserPostings(Integer forumUserId) {
        return forumPostingRepository.findAllByForumUser_UserId(forumUserId);
    }

    @Override
    public ForumPosting savePosting(ForumPosting forumPosting) {
        return forumPostingRepository.save(forumPosting);
    }

    @Override
    public void deletePosting(Integer postingId) {
        forumPostingRepository.deleteByPostingId(postingId);
    }

    @Override
    public ForumUser findUser(Integer userId) {
        return forumUserRepository.findByUserId(userId);
    }

    @Override
    public ForumUser findUserByUserNameAndUserPassword(String userName, String userPassword) {
        return forumUserRepository.findByUserNameAndUserPassword( userName,userPassword);
    }

    @Override
    public ForumUser findUserByUserName(String userName) {
        return forumUserRepository.findByUserName(userName);
    }

    @Override
    public ForumUser saveUser(ForumUser f) {
        return forumUserRepository.save(f);
    }
}
