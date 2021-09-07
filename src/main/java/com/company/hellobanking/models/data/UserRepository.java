package com.company.hellobanking.models.data;

import com.company.hellobanking.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


/* Repository in order to access User objects stored in the database */
@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

    /* this method is intended to take a username, and return the given user with that username. */
    User findByUsername(String username);
}
