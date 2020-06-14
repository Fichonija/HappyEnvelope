package androidx.tvz.hr.happyenvelope.ui.home;

import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.tvz.hr.happyenvelope.services.gift.MockGiftService;
import androidx.tvz.hr.happyenvelope.services.wedding.MockWeddingService;
import androidx.tvz.hr.happyenvelope.ui.weddings.presenter.WeddingsPresenterImpl;

import android.tvz.hr.happyenvelope.R;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.view.SimpleDraweeView;

public class HomeFragment extends Fragment {

    private TextView tw_home_intro;
    private TextView tw_steps;
    private TextView tw_home_title;
    private SimpleDraweeView wedding_image;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        tw_home_intro = root.findViewById(R.id.tw_home_intro);
        tw_home_intro.setText(R.string.tw_home_intro);
        tw_home_title=root.findViewById(R.id.tw_home_title);
        tw_home_title.setText(R.string.title);
        tw_steps=root.findViewById(R.id.tw_home_steps);
        tw_steps.setText(R.string.steps);

        wedding_image=root.findViewById(R.id.wedding_image);
        Uri imageUri = Uri.parse("https://i2-prod.plymouthherald.co.uk/incoming/article3325790.ece/ALTERNATES/s810/0_Gwel-an-Mor-Resort-Wedding-Venue-Cornwall-Coastal-02.jpg");
        wedding_image.setImageURI(imageUri);


        return root;
    }

}