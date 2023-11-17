package com.avijit.authproject.Repo;


import com.avijit.authproject.Model.Session;
import com.avijit.authproject.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SessionRepo extends JpaRepository<Session,Long> {
  Session save(Session session, User user);

    @Override
    List<Session> findAll();
}
