package com.lost.t_3;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import java.lang.reflect.Array;
import java.util.Random;

public class SplashScreen extends AppCompatActivity {


    public TextView text_content;
    private ConstraintLayout splashScreen;
    Random random;
    public int imageLenght, text;
    private String[] textContent;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen);
        init();
    }



    public void init(){
        text_content = findViewById(R.id.tv_content_splash);
        splashScreen = findViewById(R.id.splash_screen);

        textContent = getResources().getStringArray(R.array.splash_screen_text_content);
        int textLenght = text_content.length();
        int i = random.nextInt(textLenght);
        text_content.setText(i);


        final int [] imageContent = {(R.drawable.img_it_main), (R.drawable.img_jp_main), (R.drawable.img_main_ger), (R.drawable.img_fr_main), (R.drawable.img_main_fin)};
        imageLenght = imageContent.length;
        random = new Random();
        int r = random.nextInt(imageLenght);
        splashScreen.setBackgroundResource(imageContent[r]);


    }




}
