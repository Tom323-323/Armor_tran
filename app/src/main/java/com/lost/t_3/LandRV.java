package com.lost.t_3;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SnapHelper;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.AccelerateInterpolator;

import java.util.ArrayList;
import java.util.List;

public class LandRV extends AppCompatActivity {

    private CardView mCardView;
    public int indexLand;

    private RecyclerView rvTanks;
    private AdapterRV adapterRv;
    private List<LandContent> land_content_data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main1);

        rvTanks = findViewById(R.id.rv_tanks);

        final LinearLayoutManager linerMang = new LinearLayoutManager(LandRV.this, LinearLayoutManager.HORIZONTAL, false); // создаем менеджер для отображения элементов в списке по горизонтали
        rvTanks.setLayoutManager(linerMang);

//        rvTanks.setHasFixedSize(true);// Оптимизируем список ограниченным количеством элементов



        // adapterRv2 = new AdapterRV2(numbers:7) ....
        // ИЗМЕНЯТЬ ЛОГИКУ АДАПТЕРОВ ДЛЯ ОДНОГО RECYCLER VIEW!!!!!!!
        Intent intent = getIntent();
        indexLand = intent.getIntExtra("index_main", 1);
        switch (indexLand){
            case 1:adapterRv = new AdapterRV(16);
                rvTanks.setAdapter(adapterRv);
                setInitData1();
                // ПРОПИСАТЬ ИЗМЕНЕНИЕ ИКОНКИ И НАЗВАНИЯ СТРАНЫ В TITLE
                //setInitData иницилизируем списки!!!!!!!!!!!!!!!!!!!!
                break;
            case 2:
                setInitData2();
                adapterRv = new AdapterRV(6);
                rvTanks.setAdapter(adapterRv);
                break;
            case 3:
                setInitData3();
                adapterRv = new AdapterRV(26);
                rvTanks.setAdapter(adapterRv);
                break;
            case 4:
                setInitData4();
                adapterRv = new AdapterRV(9);
                rvTanks.setAdapter(adapterRv);
                break;
            case 5:
                setInitData5();
                adapterRv = new AdapterRV(5);
                rvTanks.setAdapter(adapterRv);
                break;
            case 6:
                setInitData6();
                adapterRv = new AdapterRV(8);
                rvTanks.setAdapter(adapterRv);
                break;
            case 7:
                setInitData7();
                adapterRv = new AdapterRV(7);
                rvTanks.setAdapter(adapterRv);
                break;
            case 8:
                setInitData8();
                adapterRv = new AdapterRV(6);
                rvTanks.setAdapter(adapterRv);
                break;
        }



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


    public void setInitData1(){
        land_content_data = new ArrayList<>();
        land_content_data.add(new LandContent(R.string.land_title_1,R.string.land_content_1,R.drawable.img_ger_main));
        land_content_data.add(new LandContent(R.string.land_title_2,R.string.land_content_2,R.drawable.img_it_main));
        land_content_data.add(new LandContent(R.string.land_title_3,R.string.land_content_3,R.drawable.img_fr_main));
        land_content_data.add(new LandContent(R.string.land_title_4,R.string.land_content_4,R.drawable.img_gb_main));
        land_content_data.add(new LandContent(R.string.land_title_5,R.string.land_content_5,R.drawable.img_jp_main));
        land_content_data.add(new LandContent(R.string.land_title_6,R.string.land_content_6,R.drawable.img_soviet_main));
    }

    public void setInitData2(){
        land_content_data = new ArrayList<>();
        land_content_data.add(new LandContent(R.string.land_title_1,R.string.land_content_1,R.drawable.img_it_main));
        land_content_data.add(new LandContent(R.string.land_title_2,R.string.land_content_2,R.drawable.img_ger_main));
        land_content_data.add(new LandContent(R.string.land_title_3,R.string.land_content_3,R.drawable.img_fr_main));
        land_content_data.add(new LandContent(R.string.land_title_4,R.string.land_content_4,R.drawable.img_gb_main));
        land_content_data.add(new LandContent(R.string.land_title_5,R.string.land_content_5,R.drawable.img_jp_main));
        land_content_data.add(new LandContent(R.string.land_title_6,R.string.land_content_6,R.drawable.img_soviet_main));
    }

    public void setInitData3(){
        land_content_data = new ArrayList<>();
        land_content_data.add(new LandContent(R.string.land_title_1,R.string.land_content_1,R.drawable.img_soviet_main));
        land_content_data.add(new LandContent(R.string.land_title_2,R.string.land_content_2,R.drawable.img_it_main));
        land_content_data.add(new LandContent(R.string.land_title_3,R.string.land_content_3,R.drawable.img_fr_main));
        land_content_data.add(new LandContent(R.string.land_title_4,R.string.land_content_4,R.drawable.img_gb_main));
        land_content_data.add(new LandContent(R.string.land_title_5,R.string.land_content_5,R.drawable.img_jp_main));
        land_content_data.add(new LandContent(R.string.land_title_6,R.string.land_content_6,R.drawable.img_soviet_main));
    }

    public void setInitData4(){
        land_content_data = new ArrayList<>();
        land_content_data.add(new LandContent(R.string.land_title_1,R.string.land_content_1,R.drawable.img_gb_main));
        land_content_data.add(new LandContent(R.string.land_title_2,R.string.land_content_2,R.drawable.img_it_main));
        land_content_data.add(new LandContent(R.string.land_title_3,R.string.land_content_3,R.drawable.img_fr_main));
        land_content_data.add(new LandContent(R.string.land_title_4,R.string.land_content_4,R.drawable.img_gb_main));
        land_content_data.add(new LandContent(R.string.land_title_5,R.string.land_content_5,R.drawable.img_jp_main));
        land_content_data.add(new LandContent(R.string.land_title_6,R.string.land_content_6,R.drawable.img_soviet_main));
    }

    public void setInitData5(){
        land_content_data = new ArrayList<>();
        land_content_data.add(new LandContent(R.string.land_title_1,R.string.land_content_1,R.drawable.img_jp_main));
        land_content_data.add(new LandContent(R.string.land_title_2,R.string.land_content_2,R.drawable.img_it_main));
        land_content_data.add(new LandContent(R.string.land_title_3,R.string.land_content_3,R.drawable.img_fr_main));
        land_content_data.add(new LandContent(R.string.land_title_4,R.string.land_content_4,R.drawable.img_gb_main));
        land_content_data.add(new LandContent(R.string.land_title_5,R.string.land_content_5,R.drawable.img_jp_main));
        land_content_data.add(new LandContent(R.string.land_title_6,R.string.land_content_6,R.drawable.img_soviet_main));
    }

    public void setInitData6(){
        land_content_data = new ArrayList<>();
        land_content_data.add(new LandContent(R.string.land_title_1,R.string.land_content_1,R.drawable.img_fr_main));
        land_content_data.add(new LandContent(R.string.land_title_2,R.string.land_content_2,R.drawable.img_it_main));
        land_content_data.add(new LandContent(R.string.land_title_3,R.string.land_content_3,R.drawable.img_fr_main));
        land_content_data.add(new LandContent(R.string.land_title_4,R.string.land_content_4,R.drawable.img_gb_main));
        land_content_data.add(new LandContent(R.string.land_title_5,R.string.land_content_5,R.drawable.img_jp_main));
        land_content_data.add(new LandContent(R.string.land_title_6,R.string.land_content_6,R.drawable.img_soviet_main));
    }

    public void setInitData7(){
        land_content_data = new ArrayList<>();
        land_content_data.add(new LandContent(R.string.land_title_1,R.string.land_content_1,R.drawable.img_usa_main));
        land_content_data.add(new LandContent(R.string.land_title_2,R.string.land_content_2,R.drawable.img_it_main));
        land_content_data.add(new LandContent(R.string.land_title_3,R.string.land_content_3,R.drawable.img_fr_main));
        land_content_data.add(new LandContent(R.string.land_title_4,R.string.land_content_4,R.drawable.img_gb_main));
        land_content_data.add(new LandContent(R.string.land_title_5,R.string.land_content_5,R.drawable.img_jp_main));
        land_content_data.add(new LandContent(R.string.land_title_6,R.string.land_content_6,R.drawable.img_soviet_main));
    }

    public void setInitData8(){
        land_content_data = new ArrayList<>();
        land_content_data.add(new LandContent(R.string.land_title_1,R.string.land_content_1,R.drawable.img_fr_main));
        land_content_data.add(new LandContent(R.string.land_title_2,R.string.land_content_2,R.drawable.img_it_main));
        land_content_data.add(new LandContent(R.string.land_title_3,R.string.land_content_3,R.drawable.img_fr_main));
        land_content_data.add(new LandContent(R.string.land_title_4,R.string.land_content_4,R.drawable.img_gb_main));
        land_content_data.add(new LandContent(R.string.land_title_5,R.string.land_content_5,R.drawable.img_jp_main));
        land_content_data.add(new LandContent(R.string.land_title_6,R.string.land_content_6,R.drawable.img_soviet_main));
    }


}