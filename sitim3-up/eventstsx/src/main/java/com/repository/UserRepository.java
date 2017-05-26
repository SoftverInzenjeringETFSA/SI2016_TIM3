package com.repository;

import com.models.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;


/**
 * Created by ohrinator on 5/22/17.
 */
public interface UserRepository extends JpaRepository<User, Long>, CrudRepository<User, Long> {

    /* FInd by email and password */
    @Query("SELECT u FROM User u WHERE u.email = ?1 AND u.password = ?2")
    Page<User> findByMailAndPass(String email, String password, Pageable pageable);

    /* Find by token */
    @Query("SELECT u FROM User u WHERE u.authToken = ?1")
    User findByToken(String token);

    /* Vrati na osnovu imena */
    @Query("SELECT u FROM User u WHERE u.name like ?1%")
    Iterable<User> findByName(String name);
}
