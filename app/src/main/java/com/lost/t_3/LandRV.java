package com.lost.t_3;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SnapHelper;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.widget.Toast;

public class LandRV extends AppCompatActivity {

    private CardView mCardView;
    public int indexLand;

    private RecyclerView rvTanks;
    private AdapterRV adapterRv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main1);

        rvTanks = findViewById(R.id.rv_tanks);

        final LinearLayoutManager linerMang = new LinearLayoutManager(LandRV.this, LinearLayoutManager.HORIZONTAL, false); // создаем менеджер для отображения элементов в списке по горизонтали
        rvTanks.setLayoutManager(linerMang);

        rvTanks.setHasFixedSize(true);// Оптимизируем список ограниченным количеством элементов

        adapterRv = new AdapterRV(6);

        // adapterRv2 = new AdapterRV2(numbers:7) ....
        // ИЗМЕНЯТЬ ЛОГИКУ АДАПТЕРОВ ДЛЯ ОДНОГО RECYCLER VIEW!!!!!!!
        Intent intent = getIntent();
        indexLand = intent.getIntExtra("index_main", 1);
        switch (indexLand){
            case 1://rvTanks.setAdapter(adapterRv);
                    //adapterRv = new AdapterRV(6);

            case 2://rvTanks.setAdapter(adapterRv2);
                //adapterRv = new AdapterRV(6);
                Toast.makeText(this, "index 2", Toast.LENGTH_SHORT).show();
            case 3://rvTanks.setAdapter(adapterRv3);
                //adapterRv = new AdapterRV(6);
            case 4://rvTanks.setAdapter(adapterRv4);
                //adapterRv = new AdapterRV(6);
            case 5://rvTanks.setAdapter(adapterRv5);
                //adapterRv = new AdapterRV(6);
            case 6://rvTanks.setAdapter(adapterRv6);
                //adapterRv = new AdapterRV(6);
            case 7://rvTanks.setAdapter(adapterRv7);
               // adapterRv = new AdapterRV(6);
            case 8://rvTanks.setAdapter(adapterRv8);
                // adapterRv = new AdapterRV(6);
        }
        rvTanks.setAdapter(adapterRv);


        //__________________________________________________________________________________________________________________________________
        rvTanks.setPadding(110,0,110,0);
        final SnapHelper shapHelper = new LinearSnapHelper();
        shapHelper.attachToRecyclerView(rvTanks);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                RecyclerView.ViewHolder viewHolder = rvTanks.findViewHolderForPosition(0);
                CardView card = viewHolder.itemView.findViewById(R.id.consrL);
                card.animate().setDuration(250).scaleX(1).scaleY(1).setInterpolator(new AccelerateInterpolator()).start();
            }
        },80);

        rvTanks.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                View v = shapHelper.findSnapView(linerMang);
                int pos = linerMang.getPosition(v);
                RecyclerView.ViewHolder viewHolder = rvTanks.findViewHolderForPosition(pos);
                CardView card = viewHolder.itemView.findViewById(R.id.consrL);
                if(newState == RecyclerView.SCROLL_STATE_IDLE){
                    card.animate().setDuration(250).scaleX(1).scaleY(1).setInterpolator(new AccelerateInterpolator()).start();
                } else {
                    card.animate().setDuration(250).scaleX(0.85f).scaleY(0.85f).setInterpolator(new AccelerateInterpolator()).start();
                }
            }

            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
            }
        });
        //------------------------------------------------------------------------------------------------------------------------------------
    }
}