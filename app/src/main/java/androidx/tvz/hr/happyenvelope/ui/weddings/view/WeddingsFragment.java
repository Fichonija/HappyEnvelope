package androidx.tvz.hr.happyenvelope.ui.weddings.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import android.tvz.hr.happyenvelope.R;

public class WeddingsFragment extends Fragment {
    private TextView tw_weddings_intro;
    private TextView tw_weddings_form;
    private TextView tw_weddings_title;
    private TextView tw_weddings_description;
    String items []= new String[]{"Prvo vjenjacnje","Drugo","Trece","Cetvrto","Peto"};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_weddings, container, false);
        ListView listView= (ListView) root.findViewById(R.id.listview);
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(getContext(),android.R.layout.simple_list_item_1,items);
        listView.setAdapter(adapter);
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
}