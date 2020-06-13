package androidx.tvz.hr.happyenvelope.mock.main;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.tvz.hr.happyenvelope.mock.codebook.Event;
import androidx.tvz.hr.happyenvelope.mock.codebook.Locale;
import androidx.tvz.hr.happyenvelope.mock.codebook.Relationship;
import androidx.tvz.hr.happyenvelope.mock.codebook.Salary;
import androidx.tvz.hr.happyenvelope.mock.codebook.Season;

public class Calculation implements Parcelable {
    public int id;
    public Salary salary;
    public int attending;
    public Relationship relationship;
    public int festivities;
    public Locale locale;
    public Event event;
    public Season season;
    public double calculationSum;

    public Calculation() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Salary getSalary() {
        return salary;
    }

    public void setSalary(Salary salary) {
        this.salary = salary;
    }

    public int getAttending() {
        return attending;
    }

    public void setAttending(int attending) {
        this.attending = attending;
    }

    public Relationship getRelationship() {
        return relationship;
    }

    public void setRelationship(Relationship relationship) {
        this.relationship = relationship;
    }

    public int getFestivities() {
        return festivities;
    }

    public void setFestivities(int festivities) {
        this.festivities = festivities;
    }

    public Locale getLocale() {
        return locale;
    }

    public void setLocale(Locale locale) {
        this.locale = locale;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public Season getSeason() {
        return season;
    }

    public void setSeason(Season season) {
        this.season = season;
    }

    public double getCalculationSum() {
        return calculationSum;
    }

    public void setCalculationSum(double calculationSum) {
        this.calculationSum = calculationSum;
    }

    public Calculation(int id, Salary salary, int attending, Relationship relationship, int festivities, Locale locale, Event event, Season season, double calculationSum) {
        this.id = id;
        this.salary = salary;
        this.attending = attending;
        this.relationship = relationship;
        this.festivities = festivities;
        this.locale = locale;
        this.event = event;
        this.season = season;
        this.calculationSum = calculationSum;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.id);
        dest.writeParcelable(this.salary, flags);
        dest.writeInt(this.attending);
        dest.writeParcelable(this.relationship, flags);
        dest.writeInt(this.festivities);
        dest.writeParcelable(this.locale, flags);
        dest.writeParcelable(this.event, flags);
        dest.writeParcelable(this.season, flags);
        dest.writeDouble(this.calculationSum);
    }

    protected Calculation(Parcel in) {
        this.id = in.readInt();
        this.salary = in.readParcelable(Salary.class.getClassLoader());
        this.attending = in.readInt();
        this.relationship = in.readParcelable(Relationship.class.getClassLoader());
        this.festivities = in.readInt();
        this.locale = in.readParcelable(Locale.class.getClassLoader());
        this.event = in.readParcelable(Event.class.getClassLoader());
        this.season = in.readParcelable(Season.class.getClassLoader());
        this.calculationSum = in.readDouble();
    }

    public static final Creator<Calculation> CREATOR = new Creator<Calculation>() {
        @Override
        public Calculation createFromParcel(Parcel source) {
            return new Calculation(source);
        }

        @Override
        public Calculation[] newArray(int size) {
            return new Calculation[size];
        }
    };
}
