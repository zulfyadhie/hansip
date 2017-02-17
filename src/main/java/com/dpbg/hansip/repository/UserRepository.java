package com.dpbg.hansip.repository;

import com.dpbg.hansip.model.User;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by zulfyadhie on 2/14/17.
 */
public interface UserRepository extends CrudRepository<User, Long> {

    User findOneByUsername(String username);

}
