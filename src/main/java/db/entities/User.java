package db.entities;

public class User extends Entity {

    private static final long serialVersionUID = 8088807085555319274L;

    private int id;

    private String email;

    private String password;

    private boolean status;

    private int roleId;

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }


    @Override
    public int getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public boolean isStatus() {
        return status;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}