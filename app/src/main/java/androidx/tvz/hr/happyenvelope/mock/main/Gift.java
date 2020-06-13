package androidx.tvz.hr.happyenvelope.mock.main;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class Gift implements Parcelable {
    public int id;
    public String name;
    public String description;
    public double cost;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Gift(int id, String name, String description, double cost, String imageUrl) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.cost = cost;
        this.imageUrl = imageUrl;
    }

    public String imageUrl;

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.id);
        dest.writeString(this.name);
        dest.writeString(this.description);
        dest.writeDouble(this.cost);
        dest.writeString(this.imageUrl);
    }

    protected Gift(Parcel in) {
        this.id = in.readInt();
        this.name = in.readString();
        this.description = in.readString();
        this.cost = in.readDouble();
        this.imageUrl = in.readString();
    }

    public static final Parcelable.Creator<Gift> CREATOR = new Parcelable.Creator<Gift>() {
        @Override
        public Gift createFromParcel(Parcel source) {
            return new Gift(source);
        }

        @Override
        public Gift[] newArray(int size) {
            return new Gift[size];
        }
    };
    @NonNull
    @Override
    public String toString() {
        return this.name;
    }
}
