package org.omilab.services.exampleservice.repo;

import org.omilab.services.exampleservice.model.ForumUser;
import org.omilab.services.exampleservice.model.Page;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

public interface ForumUserRepository extends Repository<ForumUser, Integer> {

    ForumUser findById(Integer id);

  //  @Query("select f from ForumUser f join f.instance i where i.id=?1 and f.endpoint=?2")
    public ForumUser findByUserId(Integer userId);

    ForumUser save(ForumUser f);
}
