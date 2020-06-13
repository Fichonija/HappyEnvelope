package androidx.tvz.hr.happyenvelope.ui.weddings.view;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.tvz.hr.happyenvelope.mock.main.Gift;
import androidx.tvz.hr.happyenvelope.mock.main.Wedding;
import androidx.tvz.hr.happyenvelope.services.gift.MockGiftService;
import androidx.tvz.hr.happyenvelope.services.wedding.MockWeddingService;
import androidx.tvz.hr.happyenvelope.ui.gifts.view.GiftDetail;

import android.tvz.hr.happyenvelope.R;

import java.util.List;

public class WeddingsFragment extends Fragment implements WeddingsView {
    private TextView tw_weddings_intro;
    private TextView tw_weddings_form;
    private TextView tw_weddings_title;
    private TextView tw_weddings_description;
    private MockWeddingService weddingService;
    private ListView listView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        weddingService = new MockWeddingService();

        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_weddings, container, false);
        tw_weddings_intro = root.findViewById(R.id.tw_weddings_intro);
        tw_weddings_intro.setText(R.string.weddings_intro);

        tw_weddings_form = root.findViewById(R.id.tw_weddings_form);
        tw_weddings_form.setText(R.string.weddings_form);

        tw_weddings_title = root.findViewById(R.id.tw_title_form);
        tw_weddings_title.setText(R.string.tw_title_form);

        tw_weddings_description = root.findViewById(R.id.tw_description_form);
        tw_weddings_description.setText(R.string.tw_description_form);
        return root;
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public void initialize(View root) {
        listView=root.findViewById(R.id.gift_listview);
        initializeGiftsList(root);

    }
    @RequiresApi(api = Build.VERSION_CODES.N)
    public void initializeGiftsList(View root) {

        ArrayAdapter<Wedding> adapter = new ArrayAdapter<Wedding>(getActivity(), android.R.layout.simple_list_item_1,weddingService.getWeddings() );
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i=new Intent(getActivity(), GiftDetail.class);
                i.putExtra(getString(R.string.gift),weddingService.getWeddings().get(position));
                startActivity(i);
            }
        });
    }
}