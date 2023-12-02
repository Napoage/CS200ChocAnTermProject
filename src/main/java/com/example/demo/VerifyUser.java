package com.example.demo;

import java.sql.*;
import java.util.HashMap;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * This class is responsible for verifying user login credentials.
 */
@RestController
public class VerifyUser {

    Statement stmt;
    Connection conn;
    ResultSet resultSet;

    /**
     * Represents the login data provided by the user.
     */
    public static class LoginData{
        public String username;
        public String password;
    }

    // Starts as zero for each instance
    int loginAttempts = 0;

    
    /**
     * Handles the login request and verifies the user's credentials.
     * @param loginData The login data provided by the user.
     * @return A ResponseEntity containing the login result.
     */
    @PostMapping("/enterLogin")
    public ResponseEntity<Map<String, Integer>> enterLogin(@RequestBody LoginData loginData) {
        Integer result;
        if (loginAttempts >= 3) {
            result = -2;
        } else if (!verifyUsername(loginData.username)) {
            result = 0;
        } else if (!verifyPassword(loginData.password, loginData.username)) {
            loginAttempts++;
            result = -1;
        } else {
            loginAttempts = 0;
            result = 1;
        }
    
        Map<String, Integer> responseBody = new HashMap<>();
        responseBody.put("loginResult", result);
    
        return new ResponseEntity<>(responseBody, HttpStatus.OK);
    }

    private boolean verifyUsername(String username) {
        if (userQuery(username) != true) {
            return false;
        }
        return true;
    }

    /**
     * Verifies the password for a given username.
     * 
     * @param password the password to be verified
     * @param username the username associated with the password
     * @return true if the password is verified, false otherwise
     */
    private boolean verifyPassword(String password, String username) {
        if (passQuery(password, username) != true) {
            return false;
        }
        return true;
    }

    /**
     * Checks if a user exists in the EmployeeInfo table based on the given username.
     * 
     * @param username the username to be checked
     * @return true if the user exists, false otherwise
     */
    private boolean userQuery(String username) {
        int exists = 0;
        try {
            stmt = conn.createStatement();
            String query = "SELECT EXISTS(SELECT * FROM EmployeeInfo WHERE username == " + username + ");";
            exists = stmt.executeUpdate(query);
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            // Close the connection
        }
        if (exists == 1) {
            return true;
        }
        return false;
    }

    /**
     * Checks if the provided password matches the password associated with the given username.
     *
     * @param password The password to be verified.
     * @param username The username associated with the password.
     * @return true if the password matches the associated username, false otherwise.
     */
    private boolean passQuery(String password, String username) {
        String userPass = "";
        try {
            stmt = conn.createStatement();
            String query = "SELECT password FROM EmployeeInfo WHERE username == " + username + ";";
            resultSet = stmt.executeQuery(query);

            if (resultSet.next()) {
                userPass = resultSet.getString("password");
            }
        } 
        catch (SQLException e) {
            System.out.println(e);
        } 
        finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                }
                catch (SQLException e) {
                    System.out.println(e);
                }
                try {
                    resultSet.close();
                }
                catch (SQLException e) {
                    System.out.println(e);
                }
            }
            if (stmt != null) {
                try {
                    stmt.close();
                } 
                catch (SQLException e) {
                    System.out.println(e);
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } 
                catch (SQLException e) {
                    System.out.println(e);
                }
            }
        }
        if (password.equals(userPass)) {
            return true;
        }
        return false;
    }
}