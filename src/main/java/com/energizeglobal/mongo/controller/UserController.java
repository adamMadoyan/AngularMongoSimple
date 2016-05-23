package com.energizeglobal.mongo.controller;

import com.energizeglobal.mongo.exception.DatabaseException;
import com.energizeglobal.mongo.exception.EntityNotFoundException;
import com.energizeglobal.mongo.model.User;
import com.energizeglobal.mongo.service.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.HttpStatus.*;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * Company: WeDooApps
 * Date: 5/23/16
 * <p/>
 * Created by Adam Madoyan.
 */

@RestController
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(method = POST, consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<String> save(@RequestBody User user) {
        try {
            userService.add(user);
        } catch (DuplicateKeyException e) {
            return new ResponseEntity<>(CONFLICT);
        } catch (DatabaseException e) {
            return new ResponseEntity<>(INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(OK);
    }

    @RequestMapping(method = GET)
    public ResponseEntity<User> get(@RequestParam String email) {
        try {
            return new ResponseEntity<>(userService.getByEmail(email), OK);
        } catch (EntityNotFoundException e) {
            return new ResponseEntity<>(NOT_FOUND);
        } catch (DatabaseException e) {
            return new ResponseEntity<>(INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/", method = GET)
    public ResponseEntity<List<User>> getAll() {
        try {
            return new ResponseEntity<>(userService.getAll(), OK);
        } catch (DatabaseException e) {
            return new ResponseEntity<>(INTERNAL_SERVER_ERROR);
        }
    }


}
