package com.lost.t_3;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private ImageView imageView, imageView2;
    private int i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = findViewById(R.id.imgLandWeapons);
        imageView2 = findViewById(R.id.imageView1);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //v.startAnimation(AnimationUtils.loadAnimation(MainActivity.this, R.anim.anim_click_img_land_main)); АНИМАЦИЯ КНОПКИ!!!!!
                onClickImage();
            }
        });
        imageView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //v.startAnimation(AnimationUtils.loadAnimation(MainActivity.this, R.anim.anim_click_img_land_main)); АНИМАЦИЯ КНОПКИ!!!!!
                onClickImage2();
            }
        });

    }

    public void onClickImage(){
        Intent intent = new Intent (this,RecyclerActivity.class);
        i=1;
        intent.putExtra("index_main",i);
        startActivity (intent);
    }

    public void onClickImage2(){
        Intent intent = new Intent (this,LandRV.class);
        i=2;
        intent.putExtra("index_main",i);
        startActivity (intent);
    }

}
