package com.lost.t_3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {


    private ImageView imageView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = findViewById(R.id.imageView2);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //v.startAnimation(AnimationUtils.loadAnimation(MainActivity.this, R.anim.anim_click_img_land_main)); АНИМАЦИЯ КНОПКИ!!!!!
                onClickImage();
            }
        });




    }

    public void onClickImage(){

        Intent intent = new Intent (this,RecyclerActivity.class);
        startActivity (intent);
    }


}
