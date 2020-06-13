package androidx.tvz.hr.happyenvelope.ui.calculation.presenter;

import androidx.tvz.hr.happyenvelope.mock.codebook.Event;
import androidx.tvz.hr.happyenvelope.mock.codebook.Locale;
import androidx.tvz.hr.happyenvelope.mock.codebook.Relationship;
import androidx.tvz.hr.happyenvelope.mock.codebook.Salary;
import androidx.tvz.hr.happyenvelope.mock.codebook.Season;
import androidx.tvz.hr.happyenvelope.mock.main.Calculation;
import androidx.tvz.hr.happyenvelope.mock.main.Wedding;

public interface CalculationPresenter {
    Calculation calculate(Salary salary, int attending, Relationship relationship, int festivities, Locale locale, Event event, Season season);
    void saveCalculationToWedding(Calculation calculation, Wedding wedding);
}
