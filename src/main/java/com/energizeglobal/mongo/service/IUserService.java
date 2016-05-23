package com.energizeglobal.mongo.service;


import com.energizeglobal.mongo.exception.DatabaseException;
import com.energizeglobal.mongo.model.User;

public interface IUserService {

    User get(String id) throws DatabaseException;

    User getByEmail(String email) throws DatabaseException;

    void add(User user) throws DatabaseException;

}
