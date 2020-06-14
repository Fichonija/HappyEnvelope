package androidx.tvz.hr.happyenvelope.ui.weddings.view;

import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.tvz.hr.happyenvelope.mock.main.Gift;
import androidx.tvz.hr.happyenvelope.mock.main.Wedding;
import androidx.tvz.hr.happyenvelope.services.gift.GiftService;
import androidx.tvz.hr.happyenvelope.services.gift.MockGiftService;
import androidx.tvz.hr.happyenvelope.services.wedding.MockWeddingService;
import androidx.tvz.hr.happyenvelope.services.wedding.WeddingService;
import androidx.tvz.hr.happyenvelope.ui.weddings.presenter.WeddingsPresenter;
import androidx.tvz.hr.happyenvelope.ui.weddings.presenter.WeddingsPresenterImpl;

import android.tvz.hr.happyenvelope.R;
import android.widget.Toast;

public class WeddingsFragment extends Fragment implements WeddingsView {
    private TextView tw_weddings_intro;
    private TextView tw_weddings_form;
    private TextView tw_weddings_title;
    private TextView tw_weddings_description;
    private TextView tw_weddings_gift;
    private TextView tw_calculation_form;

    private Button save_button;
    private Button update_button;
    private Button new_button;

    private Gift selectedGift;
    private String selectedTitle;
    private String selectedDescription;

    private EditText ew_weddings_title;
    private EditText ew_weddings_description;
    private EditText ew_weddings_calculation;

    private AutoCompleteTextView tw_wedding_gift_dropdown;
    private WeddingService weddingService;
    private WeddingsPresenter weddingsPresenter;
    private GiftService giftService;
    private ListView listView;

    private Integer weddingId;

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_weddings, container, false);
        weddingService = new MockWeddingService();
        giftService= new MockGiftService();
        weddingsPresenter=new WeddingsPresenterImpl();

        initialize(root);
        return root;
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public void initialize(View root) {
        ew_weddings_description=root.findViewById(R.id.ew_weddings_description);
        save_button =root.findViewById(R.id.save_button);
        update_button=root.findViewById(R.id.update_button);
        new_button=root.findViewById(R.id.new_button);
        ew_weddings_calculation=root.findViewById(R.id.ew_weddings_calculation);
        ew_weddings_title=root.findViewById(R.id.ew_weddings_title);
        tw_weddings_gift=root.findViewById(R.id.tw_gift_form);
        tw_weddings_intro = root.findViewById(R.id.tw_weddings_intro);
        tw_weddings_form = root.findViewById(R.id.tw_weddings_form);
        tw_weddings_title = root.findViewById(R.id.tw_title_form);
        tw_calculation_form=root.findViewById(R.id.tw_calculation_form);
        tw_weddings_description = root.findViewById(R.id.tw_description_form);
        tw_wedding_gift_dropdown=root.findViewById(R.id.tw_wedding_gift_dropdown);
        listView=root.findViewById(R.id.wedding_list);
        update_button.setVisibility(View.INVISIBLE);
        new_button.setVisibility(View.INVISIBLE);

        tw_weddings_gift.setText(R.string.gift_form);
        tw_weddings_intro.setText(R.string.weddings_intro);
        tw_weddings_form.setText(R.string.weddings_form);
        tw_weddings_title.setText(R.string.tw_title_form);
        tw_weddings_description.setText(R.string.tw_description_form);
        tw_calculation_form.setText(R.string.calculation_form);

        initializeWeddingList(root);
        initializeGiftDropdown(root);
        initializeSaveButton();
        initializeUpdateButton();
        initializeNewButton();

    }
    @RequiresApi(api = Build.VERSION_CODES.N)
    public void initializeWeddingList(View root) {

        ArrayAdapter<Wedding> adapter = new ArrayAdapter<Wedding>(getActivity(), android.R.layout.simple_list_item_1,weddingService.getWeddings() );
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                weddingId=weddingService.getWeddings().get(position).id;
                tw_weddings_form.setVisibility(View.INVISIBLE);
                update_button.setVisibility(View.VISIBLE);
                new_button.setVisibility(View.VISIBLE);
                save_button.setVisibility(View.INVISIBLE);
                ew_weddings_title.setText(weddingService.getWeddings().get(position).getTitle());
                ew_weddings_description.setText(weddingService.getWeddings().get(position).getDescription());
                if(weddingService.getWeddings().get(position).getGift()!=null)
                    tw_wedding_gift_dropdown.setText(weddingService.getWeddings().get(position).getGift().toString());
                else
                    tw_wedding_gift_dropdown.setText("");
                if(weddingService.getWeddings().get(position).getCalculation()!=null)
                    ew_weddings_calculation.setText(weddingService.getWeddings().get(position).getCalculation().toString());
                else
                    ew_weddings_calculation.setText("");
                selectedGift=weddingService.getWeddings().get(position).getGift();

            }
        });
    }

    @RequiresApi(api = Build.VERSION_CODES.N)

    public void initializeGiftDropdown(View root) {
        ArrayAdapter<Gift> adapter = new ArrayAdapter<Gift>(getActivity(), R.layout.calculation_dropdownitem,giftService.getGifts() );
        tw_wedding_gift_dropdown.setAdapter(adapter);
        tw_wedding_gift_dropdown.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                selectedGift = (Gift) tw_wedding_gift_dropdown.getAdapter().getItem(position);
            }
        });

    }
    private void initializeSaveButton() {
        save_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //double calculation = calculationPresenter.calculate(selectedSalary, selectedAttending, selectedRelationship, selectedFestivities, selectedLocale, selectedEvent, selectedSeason);
                selectedTitle=ew_weddings_title.getText().toString();
                selectedDescription=ew_weddings_description.getText().toString();

                if(selectedGift==null)
                {
                    weddingsPresenter.saveWedding(selectedTitle,selectedDescription,null,null);
                    ArrayAdapter<Wedding> adapter = new ArrayAdapter<Wedding>(getActivity(), android.R.layout.simple_list_item_1,weddingService.getWeddings() );
                    listView.setAdapter(adapter);

                    Toast.makeText(getActivity(), "Saved wedding with null calc and null gift",Toast.LENGTH_LONG).show();
                }
                else
                {
                    weddingsPresenter.saveWedding(selectedTitle,selectedDescription,null,selectedGift);
                    Toast.makeText(getActivity(), "Saved wedding with null calc and "+ selectedGift.toString(),Toast.LENGTH_LONG).show();
                }


            }
        });
    }
    private void initializeUpdateButton() {
        update_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectedTitle=ew_weddings_title.getText().toString();
                selectedDescription=ew_weddings_description.getText().toString();

                if(selectedGift==null)
                {

                    weddingsPresenter.updateWedding(weddingId,selectedTitle,selectedDescription,null);
                    ArrayAdapter<Wedding> adapter = new ArrayAdapter<Wedding>(getActivity(), android.R.layout.simple_list_item_1,weddingService.getWeddings() );
                    listView.setAdapter(adapter);

                    Toast.makeText(getActivity(), "Update-an wedding "+selectedTitle+" sa null gift",Toast.LENGTH_LONG).show();
                }
                else
                {
                    ArrayAdapter<Wedding> adapter = new ArrayAdapter<Wedding>(getActivity(), android.R.layout.simple_list_item_1,weddingService.getWeddings() );
                    listView.setAdapter(adapter);
                    weddingsPresenter.updateWedding(weddingId,selectedTitle,selectedDescription,selectedGift);
                    Toast.makeText(getActivity(), "Update-an wedding "+selectedTitle+selectedGift.toString(),Toast.LENGTH_LONG).show();
                }


            }
        });
    }
    private void initializeNewButton() {
        new_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ew_weddings_title.setText("");
                ew_weddings_description.setText("");
                ew_weddings_calculation.setText("");
                tw_wedding_gift_dropdown.setText("");
                update_button.setVisibility(View.INVISIBLE);
                new_button.setVisibility(View.INVISIBLE);
                save_button.setVisibility(View.VISIBLE);
                tw_weddings_form.setVisibility(View.VISIBLE);
            }
        });
    }
}