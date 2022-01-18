package ansarker.github.io.houserent.model;

import android.support.annotation.NonNull;

public class Account {
    private int id;
    private String username;
    private String password;


    public Account(int id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    @NonNull
    @Override
    public String toString() {
        return id +" "+username+" "+password;
    }
}
