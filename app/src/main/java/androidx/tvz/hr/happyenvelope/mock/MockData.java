package androidx.tvz.hr.happyenvelope.mock;

import android.os.Build;

import androidx.annotation.RequiresApi;
import androidx.tvz.hr.happyenvelope.mock.codebook.Event;
import androidx.tvz.hr.happyenvelope.mock.codebook.Locale;
import androidx.tvz.hr.happyenvelope.mock.codebook.Relationship;
import androidx.tvz.hr.happyenvelope.mock.codebook.Salary;
import androidx.tvz.hr.happyenvelope.mock.codebook.Season;
import androidx.tvz.hr.happyenvelope.mock.main.Calculation;
import androidx.tvz.hr.happyenvelope.mock.main.Gift;
import androidx.tvz.hr.happyenvelope.mock.main.Wedding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RequiresApi(api = Build.VERSION_CODES.N)
public class MockData {

    public List<Salary> salaries = new ArrayList<>(Arrays.asList(
            new Salary(0, "Unemployed"),
            new Salary(1, "Minimal Wage"),
            new Salary(2, "Average Wage"),
            new Salary(3, "Above Average Wage"),
            new Salary(4, "Wealthy")
    ));
    public List<Relationship> relationships = new ArrayList<>(Arrays.asList(
            new Relationship(0, "Immediate Family"),
            new Relationship(1, "Relatives"),
            new Relationship(2, "Best Man"),
            new Relationship(3, "Close Friend"),
            new Relationship(4, "Casual Friend"),
            new Relationship(5, "Friend of the Family")
    ));
    public List<Locale> locales = new ArrayList<>(Arrays.asList(
            new Locale(0, "Central Croatia"),
            new Locale(1, "Slavonija"),
            new Locale(2, "Dalmacija"),
            new Locale(3, "Istra"),
            new Locale(4, "Hercegovina")
    ));
    public List<Event> events = new ArrayList<>(Arrays.asList(
            new Event(0, "Club Party"),
            new Event(1, "Garden Party"),
            new Event(2, "Casual Restaurant"),
            new Event(3, "Fancy Restaurant")
    ));
    public List<Season> seasons = new ArrayList<>(Arrays.asList(
            new Season(0, "Peak (Spring/Summer)"),
            new Season(1, "Off-Peak (Autumn/Winter)")
    ));

    public List<Gift> gifts = new ArrayList<>(Arrays.asList(
            new Gift(0, "Painting", "A painting gift cultural newlyweds.", 80, "https://upload.wikimedia.org/wikipedia/commons/thumb/e/ec/Mona_Lisa%2C_by_Leonardo_da_Vinci%2C_from_C2RMF_retouched.jpg/1200px-Mona_Lisa%2C_by_Leonardo_da_Vinci%2C_from_C2RMF_retouched.jpg"),
            new Gift(1, "Video Game", "A video game gift for nerdy newlyweds.", 100, "https://upload.wikimedia.org/wikipedia/en/thumb/5/51/Minecraft_cover.png/220px-Minecraft_cover.png"),
            new Gift(2, "Exotic Plant", "Exotic plants are a perfect present if you want to save some money.", 50, "https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcQ_IfVaHRHJoYNIXqNJaeqTLwNUhlAqlCGdLhtSbevAMauxw9PF&usqp=CAU"),
            new Gift(3, "Karaoke Set", "A brand new Karaoke set is a great present if newlyweds love music.", 150, "https://muzikercdn.com/uploads/products/2758/275815/thumb_d_gallery_base_c8c73a9c.jpeg"),
            new Gift(4, "Pasta Machine", "A pasta machine will keep the newlyweds well fed with delicious pasta.", 200, "https://img.topchinasupplier.com/file/upload/2019/04/11/150mm-Home-Use-Fresh-Noodle-Making-Machine119190.jpg")
    ));

    public List<Calculation> calculations = new ArrayList<>(Arrays.asList(
       new Calculation(
               0,
               salaries.stream().filter(s -> s.name == "Unemployed").findFirst().get(),
               1,
               relationships.stream().filter(r -> r.name == "Close Friend").findFirst().get(),
               1,
               locales.stream().filter(l -> l.name == "Central Croatia").findFirst().get(),
               events.stream().filter(e -> e.name == "Garden Party").findFirst().get(),
               seasons.stream().filter(s -> s.name == "Peak (Spring/Summer)").findFirst().get(),
               0)
    ));

    public List<Wedding> weddings = new ArrayList<>(Arrays.asList(
            new Wedding(0, "Filip & Daria", "Filip and Daria's wedding.", calculations.get(0), gifts.stream().filter(g -> g.name == "Karaoke Set").findFirst().get())
    ));
}
