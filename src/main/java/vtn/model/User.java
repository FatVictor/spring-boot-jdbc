package vtn.model;

import java.sql.ResultSet;
import java.sql.SQLException;

public class User {

    private long id;
    private String username;
    private String fullname;
    private String email;

    public User(ResultSet rs) throws RuntimeException {
        try {
            id = rs.getLong("user_id");
            username = rs.getString("user_name");
            fullname = rs.getString("full_name");
            email = rs.getString("email");
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    public long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getFullname() {
        return fullname;
    }

    public String getEmail() {
        return email;
    }

}
