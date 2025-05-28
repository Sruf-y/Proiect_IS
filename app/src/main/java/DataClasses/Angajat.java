package DataClasses;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import java.util.Objects;


public class Angajat implements Parcelable {
    public String username;
    public String password;

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Angajat angajat = (Angajat) o;
        return Objects.equals(username, angajat.username) && Objects.equals(password, angajat.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, password);
    }

    public Angajat(String username, String password){

        if(username!=null && password!=null)
            if(!username.isBlank() && !password.isBlank() ) {
                this.username = username;
                this.password = password;
            }

    }

    protected Angajat(Parcel in) {
        username = in.readString();
        password = in.readString();
    }

    public static final Creator<Angajat> CREATOR = new Creator<Angajat>() {
        @Override
        public Angajat createFromParcel(Parcel in) {
            return new Angajat(in);
        }

        @Override
        public Angajat[] newArray(int size) {
            return new Angajat[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeString(username);
        parcel.writeString(password);
    }
}
