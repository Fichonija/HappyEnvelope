package androidx.tvz.hr.happyenvelope.ui.weddings.presenter;

import android.os.Build;

import androidx.annotation.RequiresApi;
import androidx.tvz.hr.happyenvelope.mock.main.Calculation;
import androidx.tvz.hr.happyenvelope.mock.main.Gift;
import androidx.tvz.hr.happyenvelope.mock.main.Wedding;
import androidx.tvz.hr.happyenvelope.services.wedding.MockWeddingService;
import androidx.tvz.hr.happyenvelope.services.wedding.WeddingService;

public class WeddingsPresenterImpl implements WeddingsPresenter {
    private WeddingService mockWeddingService;



    public WeddingsPresenterImpl(){
        mockWeddingService=new MockWeddingService();
    }
    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public void saveWedding(String title, String description, Calculation calculation, Gift gift) {
        Wedding tmp= new Wedding(10,title,description,calculation,gift);
        mockWeddingService.saveWedding(tmp);


    }

    @RequiresApi(api = Build.VERSION_CODES.N)

    public void updateWedding(Integer id,String title, String description, Gift gift) {
        mockWeddingService.getWeddings().stream().filter(wedding -> wedding.getId()==id).findFirst().get().setTitle(title);
        mockWeddingService.getWeddings().stream().filter(wedding -> wedding.getId()==id).findFirst().get().setDescription(description);
        mockWeddingService.getWeddings().stream().filter(wedding -> wedding.getId()==id).findFirst().get().setGift(gift);

    }
}
