package com.energizeglobal.mongo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.index.TextIndexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.Objects;

/**
 * Company: WeDooApps
 * Date: 5/22/16
 * <p/>
 * Created by Adam Madoyan.
 */

@Document(collection = "User")
@TypeAlias(User.TYPE_ALIAS)
public class User implements Serializable {

    public static final String TYPE_ALIAS = "d1a871c0-bc01-11e4-be53-dc85dec5863a";

    @Id
    private String id;

    @Indexed(unique = true, dropDups = true)
    @TextIndexed(weight = 1)
    private String email;

    public User() {
    }

    public User(String email) {
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id) &&
                Objects.equals(email, user.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, email);
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
