package com.lost.t_3;

import androidx.appcompat.app.AppCompatActivity;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;


public class MainActivity extends AppCompatActivity {

    private int i;
    public ImageButton btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Скрыть нижную панель навигации_________________
        getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);

        init();
    }

    public void init(){
        final Intent intent = new Intent (this,LandRV.class);


        btn1 = findViewById(R.id.imageView1);
        btn2 = findViewById(R.id.imageView2);
        btn3 = findViewById(R.id.imageView3);
        btn4 = findViewById(R.id.imageView4);
        btn5 = findViewById(R.id.imageView5);
        btn6 = findViewById(R.id.imageView6);
        btn7 = findViewById(R.id.imageView7);
        btn8 = findViewById(R.id.imageView8);

        View.OnClickListener onClickListener = new View.OnClickListener() {
            @SuppressLint("NonConstantResourceId")
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.imageView1:
                        i=1;
                        intent.putExtra("index_main",i);
                        startActivity (intent);
                        break;
                    case R.id.imageView2:
                        i=2;
                        intent.putExtra("index_main",i);
                        startActivity (intent);
                        break;
                    case R.id.imageView3:
                        i=3;
                        intent.putExtra("index_main",i);
                        startActivity (intent);
                        break;
                    case R.id.imageView4:
                        i=4;
                        intent.putExtra("index_main",i);
                        startActivity (intent);
                        break;
                    case R.id.imageView5:
                        i=5;
                        intent.putExtra("index_main",i);
                        startActivity (intent);
                        break;
                    case R.id.imageView6:
                        i=6;
                        intent.putExtra("index_main",i);
                        startActivity (intent);
                        break;
                    case R.id.imageView7:
                        i=7;
                        intent.putExtra("index_main",i);
                        startActivity (intent);
                        break;
                    case R.id.imageView8:
                        i=8;
                        intent.putExtra("index_main",i);
                        startActivity (intent);
                        break;
                }
            }
        };
        btn1.setOnClickListener(onClickListener);
        btn2.setOnClickListener(onClickListener);
        btn3.setOnClickListener(onClickListener);
        btn4.setOnClickListener(onClickListener);
        btn5.setOnClickListener(onClickListener);
        btn6.setOnClickListener(onClickListener);
        btn7.setOnClickListener(onClickListener);
        btn8.setOnClickListener(onClickListener);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        finish();
    }

}
