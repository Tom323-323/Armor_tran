package com.lost.t_3.presenter;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.lost.t_3.R;
import java.util.Random;

public class SplashScreen extends AppCompatActivity {

    public TextView text_content;
    Random random1;
    public int textLenght;
    public String[] textContent;
    boolean singleBack = false;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Скрыть нижную панель навигации_________________
        getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);

        setContentView(R.layout.splash_screen);
        init();
        nextSplash();
    }

    public void init(){
        text_content = findViewById(R.id.tv_content_splash);

        // Установка рандомной цитаты
        textContent = getResources().getStringArray(R.array.splash_screen_text_content);
        textLenght = textContent.length;
        random1 = new Random();
        int i = random1.nextInt(textLenght);
        text_content.setText(textContent[i]);

    }

    @Override
    public void onBackPressed() {
        // Двойной БЭК для выхода с подсказкой!!!
        if (singleBack) {
            super.onBackPressed();
            return;
        }
        this.singleBack = true;
        Toast.makeText(this, "Нажмите кнопку НАЗАД еще раз, чтобы выйти из приложения", Toast.LENGTH_SHORT).show(); // Перевод на английский язык!!!!!!!!!!!!!!!!!!
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                singleBack=false;
            }
        }, 2000);
    }

    //Функция переход из SplashScreen
    private void nextSplash() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {Thread.sleep(4500);} catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Intent i = new Intent(SplashScreen.this, MainActivity.class);
                startActivity(i);
                finish();
            }
        }).start();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        finish();
    }

}
