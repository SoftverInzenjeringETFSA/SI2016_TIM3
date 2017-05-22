package com.repository;

import com.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;


/**
 * Created by ohrinator on 5/22/17.
 */
public interface UserRepository extends JpaRepository<User, Long>, CrudRepository<User, Long> {

}
