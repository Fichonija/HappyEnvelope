package androidx.tvz.hr.happyenvelope.ui.calculation.presenter;

import androidx.tvz.hr.happyenvelope.mock.codebook.Event;
import androidx.tvz.hr.happyenvelope.mock.codebook.Locale;
import androidx.tvz.hr.happyenvelope.mock.codebook.Relationship;
import androidx.tvz.hr.happyenvelope.mock.codebook.Salary;
import androidx.tvz.hr.happyenvelope.mock.codebook.Season;
import androidx.tvz.hr.happyenvelope.mock.main.Calculation;
import androidx.tvz.hr.happyenvelope.mock.main.Wedding;
import androidx.tvz.hr.happyenvelope.services.wedding.MockWeddingService;
import androidx.tvz.hr.happyenvelope.services.wedding.WeddingService;

public class CalculationPresenterImpl implements CalculationPresenter {

    private WeddingService weddingService;

    public CalculationPresenterImpl(){
        weddingService = new MockWeddingService();
    }

    @Override
    public Calculation calculate(Salary salary, int attending, Relationship relationship, int festivities, Locale locale, Event event, Season season){
        //todo Implementirati logiku izracuna poklona
        int x = 100;
        return new Calculation(1, salary, attending, relationship, festivities, locale, event, season, 999);
    }

    @Override
    public void saveCalculationToWedding(Calculation calculation, Wedding wedding) {
        weddingService.addCalculationToWedding(calculation, wedding);
    }
}
