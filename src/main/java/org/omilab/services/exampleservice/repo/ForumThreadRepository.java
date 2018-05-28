package org.omilab.services.exampleservice.repo;

import org.omilab.services.exampleservice.model.ForumThread;
import org.omilab.services.exampleservice.model.ForumUser;
import org.springframework.data.repository.Repository;

import java.util.List;

public interface ForumThreadRepository extends Repository<ForumThread, Integer> {

    public ForumThread findByThreadTitle(String forumThreadTitle);


    ForumThread save(ForumThread forumThread);
}