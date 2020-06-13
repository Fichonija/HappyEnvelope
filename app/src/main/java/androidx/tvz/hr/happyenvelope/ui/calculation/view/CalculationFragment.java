package androidx.tvz.hr.happyenvelope.ui.calculation.view;

import android.content.DialogInterface;
import android.os.Build;
import android.os.Bundle;
import android.tvz.hr.happyenvelope.R;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.tvz.hr.happyenvelope.mock.codebook.Event;
import androidx.tvz.hr.happyenvelope.mock.codebook.Locale;
import androidx.tvz.hr.happyenvelope.mock.codebook.Relationship;
import androidx.tvz.hr.happyenvelope.mock.codebook.Salary;
import androidx.tvz.hr.happyenvelope.mock.codebook.Season;
import androidx.tvz.hr.happyenvelope.mock.main.Calculation;
import androidx.tvz.hr.happyenvelope.mock.main.Wedding;
import androidx.tvz.hr.happyenvelope.services.codebook.CodebookService;
import androidx.tvz.hr.happyenvelope.services.codebook.MockCodebookService;
import androidx.tvz.hr.happyenvelope.services.wedding.MockWeddingService;
import androidx.tvz.hr.happyenvelope.services.wedding.WeddingService;
import androidx.tvz.hr.happyenvelope.ui.calculation.presenter.CalculationPresenter;
import androidx.tvz.hr.happyenvelope.ui.calculation.presenter.CalculationPresenterImpl;

import com.google.android.material.dialog.MaterialAlertDialogBuilder;

public class CalculationFragment extends Fragment implements CalculationView {

    private TextView tw_calculation_intro;
    private TextView tw_calculation_header_personal;
    private TextView tw_calculation_header_bridalparty;
    private TextView tw_calculation_header_event;

    private AutoCompleteTextView tw_calculation_salary_dropdown;
    private AutoCompleteTextView tw_calculation_attending_dropdown;
    private AutoCompleteTextView tw_calculation_relationship_dropdown;
    private AutoCompleteTextView tw_calculation_festivities_dropdown;
    private AutoCompleteTextView tw_calculation_locale_dropdown;
    private AutoCompleteTextView tw_calculation_event_dropdown;
    private AutoCompleteTextView tw_calculation_season_dropdown;

    private Button bt_calculation_save;

    private CodebookService codebookService;
    private WeddingService weddingService;
    private CalculationPresenter calculationPresenter;

    private Salary selectedSalary;
    private Relationship selectedRelationship;
    private Locale selectedLocale;
    private Event selectedEvent;
    private Season selectedSeason;
    private int selectedAttending;
    private int selectedFestivities;

    private Wedding selectedWedding;

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //todo Dodati button logiku -> na Calculate se izračuna amount i opcija pokazuje da se poveže sa Weddingom!
        // Inflate the layout for this fragment
        codebookService = new MockCodebookService();
        weddingService = new MockWeddingService();
        calculationPresenter = new CalculationPresenterImpl();

        View root = inflater.inflate(R.layout.fragment_calculation, container, false);
        setViews(root);
        initialize(root);
        return root;
    }

    private void setViews(View root) {
        tw_calculation_intro = root.findViewById(R.id.tw_calculation_intro);
        tw_calculation_header_personal = root.findViewById(R.id.tw_calculation_header_personal);
        tw_calculation_header_bridalparty = root.findViewById(R.id.tw_calculation_header_bridalparty);
        tw_calculation_header_event = root.findViewById(R.id.tw_calculation_header_event);

        tw_calculation_salary_dropdown = root.findViewById(R.id.tw_calculation_salary_dropdown);
        tw_calculation_attending_dropdown = root.findViewById(R.id.tw_calculation_attending_dropdown);
        tw_calculation_event_dropdown = root.findViewById(R.id.tw_calculation_event_dropdown);
        tw_calculation_festivities_dropdown = root.findViewById(R.id.tw_calculation_festivities_dropdown);
        tw_calculation_locale_dropdown = root.findViewById(R.id.tw_calculation_locale_dropdown);
        tw_calculation_relationship_dropdown = root.findViewById(R.id.tw_calculation_relationship_dropdown);
        tw_calculation_season_dropdown = root.findViewById(R.id.tw_calculation_season_dropdown);

        bt_calculation_save = root.findViewById(R.id.bt_calculation_save);
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public void initialize(View root) {
        //todo Koristiti stilove kako bi se odvojile sekcije forme (i textview...)!
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

        initializeSaveButton();
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public void initializeSalaryDropdown(View root) {
        ArrayAdapter<Salary> adapter =
                new ArrayAdapter<Salary>(getActivity(), R.layout.calculation_dropdownitem, codebookService.getSalaries());
        tw_calculation_salary_dropdown.setAdapter(adapter);
        tw_calculation_salary_dropdown.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                selectedSalary = (Salary) tw_calculation_salary_dropdown.getAdapter().getItem(position);
            }
        });
    }
    @Override
    public void initializeAttendingDropdown(View root) {
        ArrayAdapter<CharSequence> adapter =
                ArrayAdapter.createFromResource(getActivity(), R.array.attending, R.layout.calculation_dropdownitem);
        tw_calculation_attending_dropdown.setAdapter(adapter);
        tw_calculation_attending_dropdown.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedAttendingText = (String) tw_calculation_attending_dropdown.getAdapter().getItem(position);
                switch (selectedAttendingText){
                    case "Yes":
                        selectedAttending = 1;
                        break;
                    case "No":
                        selectedAttending = 0;
                        break;
                }
            }
        });
    }
    @Override
    public void initializeRelationshipDropdown(View root) {
        ArrayAdapter<Relationship> adapter =
                new ArrayAdapter<Relationship>(getActivity(), R.layout.calculation_dropdownitem, codebookService.getRelationships());
        tw_calculation_relationship_dropdown.setAdapter(adapter);
        tw_calculation_relationship_dropdown.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                selectedRelationship = (Relationship) tw_calculation_relationship_dropdown.getAdapter().getItem(position);
            }
        });
    }
    @Override
    public void initializeFestivitiesDropdown(View root) {
        ArrayAdapter<CharSequence> adapter =
                ArrayAdapter.createFromResource(getActivity(), R.array.festivities, R.layout.calculation_dropdownitem);
        tw_calculation_festivities_dropdown.setAdapter(adapter);
        tw_calculation_festivities_dropdown.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedFestivitiesText = (String) tw_calculation_festivities_dropdown.getAdapter().getItem(position);
                switch (selectedFestivitiesText){
                    case "Yes":
                        selectedFestivities = 1;
                        break;
                    case "No":
                        selectedFestivities = 0;
                        break;
                }
            }
        });
    }
    @Override
    public void initializeLocaleDropdown(View root) {
        ArrayAdapter<Locale> adapter =
                new ArrayAdapter<Locale>(getActivity(), R.layout.calculation_dropdownitem, codebookService.getLocales());
        tw_calculation_locale_dropdown.setAdapter(adapter);
        tw_calculation_locale_dropdown.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                selectedLocale = (Locale) tw_calculation_locale_dropdown.getAdapter().getItem(position);
            }
        });
    }
    @Override
    public void initializeEventDropdown(View root) {
        ArrayAdapter<Event> adapter =
                new ArrayAdapter<Event>(getActivity(), R.layout.calculation_dropdownitem, codebookService.getEvents());
        tw_calculation_event_dropdown.setAdapter(adapter);
        tw_calculation_event_dropdown.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                selectedEvent = (Event) tw_calculation_event_dropdown.getAdapter().getItem(position);
            }
        });
    }
    @Override
    public void initializeSeasonDropdown(View root) {
        ArrayAdapter<Season> adapter =
                new ArrayAdapter<Season>(getActivity(), R.layout.calculation_dropdownitem, codebookService.getSeasons());
        tw_calculation_season_dropdown.setAdapter(adapter);
        tw_calculation_season_dropdown.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                selectedSeason = (Season) tw_calculation_season_dropdown.getAdapter().getItem(position);
            }
        });
    }
    @Override
    public void initializeSaveButton() {
        bt_calculation_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calculation calculation = calculationPresenter.calculate(selectedSalary, selectedAttending, selectedRelationship, selectedFestivities, selectedLocale, selectedEvent, selectedSeason);

                ArrayAdapter<Wedding> adapter =
                        new ArrayAdapter<Wedding>(getActivity(), R.layout.calculation_dropdownitem, weddingService.getWeddings());
                MaterialAlertDialogBuilder dialogBuilder = new MaterialAlertDialogBuilder(getActivity());
                dialogBuilder
                        .setTitle("Select Wedding and click Save to add calculation. Calculation sum: " + calculation.calculationSum)
                        .setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        })
                        .setPositiveButton("Save", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                if (selectedWedding == null){
                                    Toast.makeText(getActivity(), "No Wedding selected!", Toast.LENGTH_SHORT).show();
                                }
                                else{
                                    calculationPresenter.saveCalculationToWedding(calculation, selectedWedding);
                                    Toast.makeText(getActivity(), "Calculation sum of " + calculation.calculationSum + " added to Wedding " + selectedWedding + ".", Toast.LENGTH_SHORT).show();
                                }
                            }
                        })
                        .setSingleChoiceItems(adapter, -1, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                selectedWedding = adapter.getItem(which);
                                Toast.makeText(getActivity(), "Click Save to add calculation to " + adapter.getItem(which).getTitle() + " wedding!", Toast.LENGTH_SHORT).show();
                            }
                        })
                        .show();
            }
        });
    }
}
