package androidx.tvz.hr.happyenvelope.ui.calculation.view;

import android.os.Bundle;
import android.tvz.hr.happyenvelope.R;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import org.w3c.dom.Text;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CalculationFragment extends Fragment implements CalculationView {

    private TextView tw_calculation_intro;
    private TextView tw_calculation_header_personal;
    private TextView tw_calculation_header_bridalparty;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_calculation, container, false);
        initialize(root);
        return root;
    }

    @Override
    public void initialize(View root) {
        //todo Koristiti stilove kako bi se odvojile sekcije forme (i textview...)!

        tw_calculation_intro = root.findViewById(R.id.tw_calculation_intro);
        tw_calculation_header_personal = root.findViewById(R.id.tw_calculation_header_personal);
        tw_calculation_header_bridalparty = root.findViewById(R.id.tw_calculation_header_bridalparty);

        tw_calculation_intro.setText(R.string.calculation_intro);
        tw_calculation_header_personal.setText(R.string.calculation_header_personal);
        tw_calculation_header_bridalparty.setText(R.string.calculation_header_bridalparty);
    }
}
