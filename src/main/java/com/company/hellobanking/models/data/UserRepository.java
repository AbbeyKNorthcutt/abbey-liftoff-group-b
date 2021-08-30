package com.company.hellobanking.models.data;

import com.company.hellobanking.models.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {

}
