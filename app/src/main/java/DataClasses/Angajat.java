package DataClasses;

import androidx.annotation.NonNull;

public class Angajat {
    public String username;
    public String password;

    public Angajat(String username, String password){

        if(username!=null && password!=null)
            if(!username.isBlank() && !password.isBlank() ) {
                this.username = username;
                this.password = password;
            }

    }
}
