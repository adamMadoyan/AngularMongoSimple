package com.energizeglobal.mongo.repository;

import com.energizeglobal.mongo.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Company: WeDooApps
 * Date: 5/22/16
 * <p/>
 * Created by Adam Madoyan.
 */

public interface UserRepository extends MongoRepository<User, String> {

    User findByEmail(String email);

}
