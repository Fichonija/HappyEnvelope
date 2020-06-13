package androidx.tvz.hr.happyenvelope.services.wedding;

import androidx.tvz.hr.happyenvelope.mock.main.Calculation;
import androidx.tvz.hr.happyenvelope.mock.main.Gift;
import androidx.tvz.hr.happyenvelope.mock.main.Wedding;

import java.util.List;

public interface WeddingService {
    public List<Wedding> getWeddings();
    public void saveWedding(Wedding wedding);
    public void addCalculationToWedding(Calculation calculation, Wedding wedding);
}
