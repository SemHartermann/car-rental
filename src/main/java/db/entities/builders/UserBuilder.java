package db.entities.builders;

import db.entities.User;


public class UserBuilder {
    private final User user;

    
    public UserBuilder() {
        this.user = new User();
    }
        
    public UserBuilder withId(int id) {
        this.user.setId(id);
        return this;
    }
    public UserBuilder withEmail(String login) {
        this.user.setEmail(login);
        return this;
    }
    
    public UserBuilder withPassword(String password) {
        this.user.setPassword(password);
        return this;
    }
    
    /*public UserBuilder withRole(Role role) {
        this.user.set(role);
        return this;
    }*/
    
    public User getUser() {
        return user;
    }
    
}
