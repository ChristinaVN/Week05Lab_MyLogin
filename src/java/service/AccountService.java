
package service;

import models.User;

public class AccountService {

    public User login(String username, String password) {
        if (username.equalsIgnoreCase("adam") || username.equalsIgnoreCase("betty"))    {
            if (password.equalsIgnoreCase("password"))
                return new User(username, null);
        }

        return null;
    }    
}
