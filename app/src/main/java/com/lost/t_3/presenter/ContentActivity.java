package com.lost.t_3.presenter;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.lost.t_3.R;
import com.lost.t_3.domain.WeaponsContent;

public class ContentActivity  extends AppCompatActivity {

    ImageView imgGun;
    TextView nameGun;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_layout);

        imgGun = findViewById(R.id.content_img_gun);
        nameGun = findViewById(R.id.content_name_gun);

        WeaponsContent item = (WeaponsContent) getIntent().getExtras().getSerializable("WeaponsObj");

        loadWeaponsData(item);

    }

    private void loadWeaponsData(WeaponsContent item) {

        Glide.with(this)
                .load(item.getDrawableResourse())
                .into(imgGun);

    }
}
