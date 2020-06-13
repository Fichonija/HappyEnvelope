package androidx.tvz.hr.happyenvelope.ui.calculation.view;

import android.view.View;

public interface CalculationView {

    void initialize(View root);
    void initializeSalaryDropdown(View root);
    void initializeAttendingDropdown(View root);
    void initializeRelationshipDropdown(View root);
    void initializeFestivitiesDropdown(View root);
    void initializeLocaleDropdown(View root);
    void initializeEventDropdown(View root);
    void initializeSeasonDropdown(View root);
    void initializeSaveButton();
}
