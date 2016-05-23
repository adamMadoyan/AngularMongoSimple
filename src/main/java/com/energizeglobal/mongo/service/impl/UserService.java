package com.energizeglobal.mongo.service.impl;


import com.energizeglobal.mongo.exception.DatabaseException;
import com.energizeglobal.mongo.exception.EntityNotFoundException;
import com.energizeglobal.mongo.model.User;
import com.energizeglobal.mongo.repository.UserRepository;
import com.energizeglobal.mongo.service.IUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * User service class
 */

@Service
public class UserService implements IUserService {

    private final Logger logger = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UserRepository userRepository;

    @Override
    public User get(String id) throws DatabaseException {
        try {
            return userRepository.findOne(id);
        } catch (RuntimeException e) {
            logger.error("Unable to get user by id : " + id, e);
            throw new DatabaseException("Unable to get user by id : " + id);
        }
    }

    @Override
    public User getByEmail(String email) throws DatabaseException {
        try {
            User user = userRepository.findByEmail(email);
            if (user == null) {
                throw new EntityNotFoundException("Entity not found by this email : " + email);
            }
            return user;
        } catch (RuntimeException e) {
            logger.error("Unable to get user by email : " + email, e);
            throw new DatabaseException("Unable to get user by email : " + email);
        }
    }

    public void add(User user) throws DatabaseException {
        try {
            userRepository.save(user);
        } catch (DuplicateKeyException e) {
            logger.error(e.getMessage());
            throw e;
        } catch (RuntimeException e) {
            logger.error(e.getMessage());
            throw new DatabaseException("Unable to add user");
        }
    }

    public List<User> getAll() throws DatabaseException {
        try {
            return userRepository.findAll();
        } catch (RuntimeException e) {
            logger.error(e.getMessage());
            throw new DatabaseException("Unable to get users");
        }
    }
}
