package androidx.tvz.hr.happyenvelope.ui.gifts.view;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.tvz.hr.happyenvelope.mock.main.Gift;

import android.view.View;

import android.tvz.hr.happyenvelope.R;
import android.widget.TextView;

public class GiftDetail extends AppCompatActivity {

    private TextView tw_gift_name;
    private TextView tw_gift_description;
    private TextView tw_gift_cost;
    private SimpleDraweeView gift_image;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Fresco.initialize(this);
        setContentView(R.layout.activity_gift_detail);
        Intent intent = getIntent();
        Gift importedGift = intent.getParcelableExtra(getString(R.string.gift));

        tw_gift_name = findViewById(R.id.gift_name);
        tw_gift_name.setText(importedGift.getName());

        tw_gift_description = findViewById(R.id.gift_description);
        tw_gift_description.setText(importedGift.getDescription());

        tw_gift_cost = findViewById(R.id.gift_cost);
        tw_gift_cost.setText(String.valueOf(importedGift.getCost())+" $");
        gift_image=findViewById(R.id.gift_image);

        Uri imageUri = Uri.parse(importedGift.getImageUrl());
        gift_image.setImageURI(imageUri);


    }
}