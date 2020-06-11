package android.tvz.hr.happyenvelope.ui.calculation.view;

import android.os.Bundle;
import android.tvz.hr.happyenvelope.R;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class CalculationFragment extends Fragment implements CalculationView {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_calculation, container, false);
        final TextView textView = root.findViewById(R.id.tw_calc);
        textView.setText("HELLO WORLD!");

        return root;
    }
}
