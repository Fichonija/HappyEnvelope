package androidx.tvz.hr.happyenvelope.mock.main;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class Wedding implements Parcelable {
    public int id;
    public String title;
    public String description;
    public Calculation calculation;
    public Gift gift;

    public Wedding(int id, String title, String description, Calculation calculation, Gift gift) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.calculation = calculation;
        this.gift = gift;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Calculation getCalculation() {
        return calculation;
    }

    public void setCalculation(Calculation calculation) {
        this.calculation = calculation;
    }

    public Gift getGift() {
        return gift;
    }

    public void setGift(Gift gift) {
        this.gift = gift;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.id);
        dest.writeString(this.title);
        dest.writeString(this.description);
        dest.writeParcelable(this.calculation, flags);
        dest.writeParcelable(this.gift, flags);
    }

    protected Wedding(Parcel in) {
        this.id = in.readInt();
        this.title = in.readString();
        this.description = in.readString();
        this.calculation = in.readParcelable(Calculation.class.getClassLoader());
        this.gift = in.readParcelable(Gift.class.getClassLoader());
    }

    public static final Creator<Wedding> CREATOR = new Creator<Wedding>() {
        @Override
        public Wedding createFromParcel(Parcel source) {
            return new Wedding(source);
        }

        @Override
        public Wedding[] newArray(int size) {
            return new Wedding[size];
        }
    };
    @NonNull
    @Override
    public String toString() {
        return this.title;
    }
}
