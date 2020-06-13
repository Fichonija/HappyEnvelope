package androidx.tvz.hr.happyenvelope.ui.gifts.view;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.tvz.hr.happyenvelope.R;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.tvz.hr.happyenvelope.mock.codebook.Salary;
import androidx.tvz.hr.happyenvelope.mock.main.Gift;
import androidx.tvz.hr.happyenvelope.services.gift.MockGiftService;


import java.util.ArrayList;
import java.util.List;

public class GiftsFragment extends Fragment implements GiftsView {

        private ListView listView;
        private MockGiftService giftService;

    @RequiresApi(api = Build.VERSION_CODES.N)
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_gifts, container, false);
        giftService = new MockGiftService();
        initialize(root);

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

        ArrayAdapter<Gift> adapter = new ArrayAdapter<Gift>(getActivity(), android.R.layout.simple_list_item_1,giftService.getGifts() );
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i=new Intent(getActivity(),GiftDetail.class);
                i.putExtra(getString(R.string.gift),giftService.getGifts().get(position));
                startActivity(i);
            }
        });
    }
}