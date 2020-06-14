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

        double calculationSum = 0;
        switch (salary.name){
            case "Unemployed":
                calculationSum += 10;
                break;
            case "Minimal Wage":
                calculationSum += 20;
                break;
            case "Average Wage":
                calculationSum += 30;
                break;
            case "Above Average Wage":
                calculationSum += 40;
                break;
            case "Wealthy":
                calculationSum += 70;
                break;
        }

        if (attending == 1){
            calculationSum += 30;
        }

        switch (relationship.name){
            case "Friend of the Family":
                calculationSum += 10;
                break;
            case "Casual Friend":
                calculationSum += 20;
                break;
            case "Close Friend":
                calculationSum += 40;
                break;
            case "Best Man":
                calculationSum += 50;
                break;
            case "Relatives":
                calculationSum += 50;
                break;
            case "Immediate Family":
                calculationSum += 60;
                break;
        }

        if (festivities == 1){
            calculationSum += 15;
        }

        switch (locale.name){
            case "Central Croatia":
                calculationSum += 10;
                break;
            case "Slavonija":
                calculationSum += 15;
                break;
            case "Dalmacija":
                calculationSum += 20;
                break;
            case "Istra":
                calculationSum += 25;
                break;
            case "Hercegovina":
                calculationSum += 30;
                break;
        }

        switch (event.name){
            case "Club Party":
                calculationSum += 15;
                break;
            case "Garden Party":
                calculationSum += 20;
                break;
            case "Casual Restaurant":
                calculationSum += 30;
                break;
            case "Fancy Restaurant":
                calculationSum += 50;
                break;
        }

        if (season.name == "Peak (Spring/Summer)"){
            calculationSum += 20;
        }

        return new Calculation(1, salary, attending, relationship, festivities, locale, event, season, calculationSum);
    }

    @Override
    public void saveCalculationToWedding(Calculation calculation, Wedding wedding) {
        weddingService.addCalculationToWedding(calculation, wedding);
    }
}
