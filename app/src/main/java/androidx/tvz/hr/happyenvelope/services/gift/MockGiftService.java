package androidx.tvz.hr.happyenvelope.services.gift;

import android.os.Build;

import androidx.annotation.RequiresApi;
import androidx.tvz.hr.happyenvelope.mock.MockData;
import androidx.tvz.hr.happyenvelope.mock.main.Gift;

import java.util.List;

public class MockGiftService implements GiftService {
    @Override
    @RequiresApi(api = Build.VERSION_CODES.N)
    public List<Gift> getGifts(){
        return MockData.gifts;
    };
}
