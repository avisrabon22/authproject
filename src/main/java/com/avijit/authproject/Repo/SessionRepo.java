package com.avijit.authproject.Repo;

import com.avijit.authproject.Model.Session;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface SessionRepo extends JpaRepository<Session,Long> {
    Session  save(Session session);

    Optional<Session> findByToken(String token);
}
