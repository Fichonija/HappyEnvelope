package androidx.tvz.hr.happyenvelope.services.wedding;

import android.os.Build;

import androidx.annotation.RequiresApi;
import androidx.tvz.hr.happyenvelope.mock.MockData;
import androidx.tvz.hr.happyenvelope.mock.main.Calculation;
import androidx.tvz.hr.happyenvelope.mock.main.Gift;
import androidx.tvz.hr.happyenvelope.mock.main.Wedding;

import java.util.List;

public class MockWeddingService implements WeddingService{

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public List<Wedding> getWeddings() {
        return MockData.weddings;
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public void saveWedding(Wedding wedding) {
        MockData.weddings.add(wedding);
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public void addCalculationToWedding(Calculation calculation, Wedding wedding) {
        MockData.weddings.stream().filter(w -> w.id == wedding.id).findFirst().get().setCalculation(calculation);
    }
}
