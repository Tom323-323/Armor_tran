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

        final Intent intent = new Intent (this,RecyclerActivity.class);
        final Intent intent2 = new Intent (this,LandRV.class);

        imageView = findViewById(R.id.imgLandWeapons);
        imageView2 = findViewById(R.id.imageView1);

        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.imgLandWeapons:
                        i=1;
                        intent.putExtra("index_main",i);
                        startActivity (intent);
                        break;
                    case R.id.imageView1:
                        i=2;
                        intent2.putExtra("index_main",i);
                        startActivity (intent2);
                        break;
                }
            }
        };
        imageView.setOnClickListener(onClickListener);
        imageView2.setOnClickListener(onClickListener);
    }

}
