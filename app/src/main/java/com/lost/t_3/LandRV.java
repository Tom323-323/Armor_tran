package com.lost.t_3;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SnapHelper;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.AccelerateInterpolator;

public class LandRV extends AppCompatActivity {

    private CardView mCardView;

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


        adapterRv = new AdapterRV(10);

        rvTanks.setAdapter(adapterRv);
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
                //ConstraintLayout cons = viewHolder.itemView.findViewById(R.id.consrL);
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

    }
}