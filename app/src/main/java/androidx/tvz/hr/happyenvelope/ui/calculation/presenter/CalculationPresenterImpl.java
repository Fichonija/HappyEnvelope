package androidx.tvz.hr.happyenvelope.ui.calculation.presenter;

import androidx.tvz.hr.happyenvelope.mock.codebook.Event;
import androidx.tvz.hr.happyenvelope.mock.codebook.Locale;
import androidx.tvz.hr.happyenvelope.mock.codebook.Relationship;
import androidx.tvz.hr.happyenvelope.mock.codebook.Salary;
import androidx.tvz.hr.happyenvelope.mock.codebook.Season;

public class CalculationPresenterImpl implements CalculationPresenter {

    @Override
    public double calculate(Salary salary, int attending, Relationship relationship, int festivities, Locale locale, Event event, Season season){
        //todo Implementirati logiku izracuna poklona
        int x = 100;
        return x;
    }
}
