package androidx.tvz.hr.happyenvelope.mock.codebook;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class Salary implements Parcelable {
    public int id;
    public String name;

    public Salary(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.id);
        dest.writeString(this.name);
    }

    protected Salary(Parcel in) {
        this.id = in.readInt();
        this.name = in.readString();
    }

    public static final Parcelable.Creator<Salary> CREATOR = new Parcelable.Creator<Salary>() {
        @Override
        public Salary createFromParcel(Parcel source) {
            return new Salary(source);
        }

        @Override
        public Salary[] newArray(int size) {
            return new Salary[size];
        }
    };

    @NonNull
    @Override
    public String toString() {
        return this.name;
    }
}
