package androidx.tvz.hr.happyenvelope.services.codebook;

import android.os.Build;

import androidx.annotation.RequiresApi;
import androidx.tvz.hr.happyenvelope.mock.MockData;
import androidx.tvz.hr.happyenvelope.mock.codebook.Event;
import androidx.tvz.hr.happyenvelope.mock.codebook.Locale;
import androidx.tvz.hr.happyenvelope.mock.codebook.Relationship;
import androidx.tvz.hr.happyenvelope.mock.codebook.Salary;
import androidx.tvz.hr.happyenvelope.mock.codebook.Season;

import java.util.List;

public class MockCodebookService implements CodebookService {
    @Override
    @RequiresApi(api = Build.VERSION_CODES.N)
    public List<Salary> getSalaries(){
        return MockData.salaries;
    }

    @Override
    @RequiresApi(api = Build.VERSION_CODES.N)
    public List<Event> getEvents(){
        return MockData.events;
    }

    @Override
    @RequiresApi(api = Build.VERSION_CODES.N)
    public List<Locale> getLocales(){
        return MockData.locales;
    }

    @Override
    @RequiresApi(api = Build.VERSION_CODES.N)
    public List<Relationship> getRelationships(){
        return MockData.relationships;
    }

    @Override
    @RequiresApi(api = Build.VERSION_CODES.N)
    public List<Season> getSeasons(){
        return MockData.seasons;
    }
}
