package androidx.tvz.hr.happyenvelope.services.codebook;

import androidx.tvz.hr.happyenvelope.mock.codebook.Event;
import androidx.tvz.hr.happyenvelope.mock.codebook.Locale;
import androidx.tvz.hr.happyenvelope.mock.codebook.Relationship;
import androidx.tvz.hr.happyenvelope.mock.codebook.Salary;
import androidx.tvz.hr.happyenvelope.mock.codebook.Season;

import java.util.List;

public interface CodebookService {
    public List<Salary> getSalaries();

    public List<Event> getEvents();

    public List<Locale> getLocales();

    public List<Relationship> getRelationships();

    public List<Season> getSeasons();
}
