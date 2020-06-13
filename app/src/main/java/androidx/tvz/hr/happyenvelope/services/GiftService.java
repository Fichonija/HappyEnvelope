package androidx.tvz.hr.happyenvelope.services;

import android.os.Build;

import androidx.annotation.RequiresApi;
import androidx.tvz.hr.happyenvelope.mock.MockData;
import androidx.tvz.hr.happyenvelope.mock.main.Gift;

import java.util.List;

public class GiftService {
    @RequiresApi(api = Build.VERSION_CODES.N)
    public List<Gift> getGifts(){
        return MockData.gifts;
    };
}
