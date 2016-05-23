package com.energizeglobal.mongo;

import com.energizeglobal.mongo.model.User;
import com.energizeglobal.mongo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Company: WeDooApps
 * Date: 5/22/16
 * <p/>
 * Created by Adam Madoyan.
 */

@SpringBootApplication
public class Launcher implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    public static void main(String[] args) {
        SpringApplication.run(Launcher.class, args);
    }

    @Override
    public void run(String... strings) throws Exception {
        userRepository.deleteAll();
        String email = "admin@mail.ru";
        userRepository.save(new User(email));

        System.out.println(userRepository.findByEmail(email));

    }
}
