package androidx.tvz.hr.happyenvelope.ui.calculation.view;

import android.os.Build;
import android.os.Bundle;
import android.tvz.hr.happyenvelope.R;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.tvz.hr.happyenvelope.mock.MockData;
import androidx.tvz.hr.happyenvelope.mock.codebook.Salary;

public class CalculationFragment extends Fragment implements CalculationView {

    private TextView tw_calculation_intro;
    private TextView tw_calculation_header_personal;
    private TextView tw_calculation_header_bridalparty;
    private TextView tw_calculation_header_event;

    private MockData mockData;

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //todo Dodati button logiku -> na Calculate se izračuna amount i opcija pokazuje da se poveže sa Weddingom!
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_calculation, container, false);

        this.mockData = new MockData();
        initialize(root);

        return root;
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public void initialize(View root) {
        //todo Koristiti stilove kako bi se odvojile sekcije forme (i textview...)!

        tw_calculation_intro = root.findViewById(R.id.tw_calculation_intro);
        tw_calculation_header_personal = root.findViewById(R.id.tw_calculation_header_personal);
        tw_calculation_header_bridalparty = root.findViewById(R.id.tw_calculation_header_bridalparty);
        tw_calculation_header_event = root.findViewById(R.id.tw_calculation_header_event);

        tw_calculation_intro.setText(R.string.calculation_intro);
        tw_calculation_header_personal.setText(R.string.calculation_header_personal);
        tw_calculation_header_bridalparty.setText(R.string.calculation_header_bridalparty);
        tw_calculation_header_event.setText(R.string.calculation_header_event);
        
        initializeSalaryDropdown(root);
        initializeAttendingDropdown(root);
        initializeRelationshipDropdown(root);
        initializeFestivitiesDropdown(root);
        initializeLocaleDropdown(root);
        initializeEventDropdown(root);
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public void initializeSalaryDropdown(View root) {
//        ArrayAdapter<CharSequence> adapter =
//                ArrayAdapter.createFromResource(getActivity(), R.array.salary, R.layout.calculation_dropdownitem);

        ArrayAdapter<Salary> adapter = new ArrayAdapter<Salary>(getActivity(), R.layout.calculation_dropdownitem, mockData.salaries);

        AutoCompleteTextView editTextFilledExposedDropdown =
                root.findViewById(R.id.tw_calculation_salary_dropdown);
        editTextFilledExposedDropdown.setAdapter(adapter);
    }
    @Override
    public void initializeAttendingDropdown(View root) {
        ArrayAdapter<CharSequence> adapter =
                ArrayAdapter.createFromResource(getActivity(), R.array.attending, R.layout.calculation_dropdownitem);

        AutoCompleteTextView editTextFilledExposedDropdown =
                root.findViewById(R.id.tw_calculation_attending_dropdown);
        editTextFilledExposedDropdown.setAdapter(adapter);
    }
    @Override
    public void initializeRelationshipDropdown(View root) {
        ArrayAdapter<CharSequence> adapter =
                ArrayAdapter.createFromResource(getActivity(), R.array.relationship, R.layout.calculation_dropdownitem);

        AutoCompleteTextView editTextFilledExposedDropdown =
                root.findViewById(R.id.tw_calculation_relationship_dropdown);
        editTextFilledExposedDropdown.setAdapter(adapter);
    }
    @Override
    public void initializeFestivitiesDropdown(View root) {
        ArrayAdapter<CharSequence> adapter =
                ArrayAdapter.createFromResource(getActivity(), R.array.festivities, R.layout.calculation_dropdownitem);

        AutoCompleteTextView editTextFilledExposedDropdown =
                root.findViewById(R.id.tw_calculation_festivities_dropdown);
        editTextFilledExposedDropdown.setAdapter(adapter);
    }
    @Override
    public void initializeLocaleDropdown(View root) {
        ArrayAdapter<CharSequence> adapter =
                ArrayAdapter.createFromResource(getActivity(), R.array.locale, R.layout.calculation_dropdownitem);

        AutoCompleteTextView editTextFilledExposedDropdown =
                root.findViewById(R.id.tw_calculation_locale_dropdown);
        editTextFilledExposedDropdown.setAdapter(adapter);
    }
    @Override
    public void initializeEventDropdown(View root) {
        ArrayAdapter<CharSequence> adapter =
                ArrayAdapter.createFromResource(getActivity(), R.array.event, R.layout.calculation_dropdownitem);

        AutoCompleteTextView editTextFilledExposedDropdown =
                root.findViewById(R.id.tw_calculation_event_dropdown);
        editTextFilledExposedDropdown.setAdapter(adapter);
    }
    @Override
    public void initializeSeasonDropdown(View root) {
        ArrayAdapter<CharSequence> adapter =
                ArrayAdapter.createFromResource(getActivity(), R.array.season, R.layout.calculation_dropdownitem);

        AutoCompleteTextView editTextFilledExposedDropdown =
                root.findViewById(R.id.tw_calculation_season_dropdown);
        editTextFilledExposedDropdown.setAdapter(adapter);
    }
}
