package androidx.tvz.hr.happyenvelope.ui.weddings.presenter;

import androidx.tvz.hr.happyenvelope.mock.main.Calculation;
import androidx.tvz.hr.happyenvelope.mock.main.Gift;

public interface WeddingsPresenter {
    void saveWedding(String title, String description, Calculation calculation, Gift gift);
}
