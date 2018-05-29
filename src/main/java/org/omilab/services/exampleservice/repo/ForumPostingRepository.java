package org.omilab.services.exampleservice.repo;

import org.omilab.services.exampleservice.model.ForumPosting;
import org.omilab.services.exampleservice.model.ForumThread;
import org.springframework.data.repository.Repository;

import java.util.List;

public interface ForumPostingRepository extends Repository<ForumPosting, Integer> {

    List<ForumPosting> findAllByForumThread_ThreadId(Integer forumThreadId);
    List<ForumPosting> findAllByForumUser_UserId(Integer forumUserId);

    ForumPosting save(ForumPosting forumPosting);
}
