package com.avijit.authproject.Repo;

import com.avijit.authproject.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepo extends JpaRepository<User,Long> {

    @Override
    Optional<User> findById(Long aLong);
}
