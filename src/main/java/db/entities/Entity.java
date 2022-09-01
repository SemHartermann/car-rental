package db.entities;

import java.io.Serializable;

public abstract class Entity implements Serializable {

    private static final long serialVersionUID = 8466257860808346236L;

    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}