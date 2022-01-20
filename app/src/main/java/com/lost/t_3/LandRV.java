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
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class LandRV extends AppCompatActivity {

    private CardView mCardView;
    public int indexLand;
    public String [] title_arr, content_arr, land_arr;

    private RecyclerView rvTanks;
    List<LandContent> land_content_data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main1);

        title_arr = getResources().getStringArray(R.array.land_title);
        content_arr = getResources().getStringArray(R.array.land_content);
        land_arr = getResources().getStringArray(R.array.land_name_title);

        rvTanks = findViewById(R.id.rv_tanks);
        TextView title_land = findViewById(R.id.title_land);
        ImageView img_land_title = findViewById(R.id.imgLandWeapons);

        final LinearLayoutManager linerMang = new LinearLayoutManager(LandRV.this, LinearLayoutManager.HORIZONTAL, false); // создаем менеджер для отображения элементов в списке по горизонтали
        rvTanks.setLayoutManager(linerMang);
        rvTanks.setHasFixedSize(true);

        land_content_data = new ArrayList<>();
        AdapterRV adapterRv = new AdapterRV(land_content_data, 6);

        Intent intent = getIntent();
        indexLand = intent.getIntExtra("index_main", 1);

        switch (indexLand){
            case 1:
                rvTanks.setAdapter(adapterRv);
                setInitData1();
                title_land.setText(land_arr[0]);
                title_land.setTextSize(24);
                img_land_title.setImageResource(R.drawable.img_main_gb);
                break;
            case 2:
                setInitData2();
                rvTanks.setAdapter(adapterRv);
                title_land.setText(land_arr[1]);
                img_land_title.setImageResource(R.drawable.img_main_fr);
                break;
            case 3:
                setInitData3();
                rvTanks.setAdapter(adapterRv);
                title_land.setText(land_arr[2]);
                img_land_title.setImageResource(R.drawable.img_main_ger);
                break;
            case 4:
                setInitData4();
                rvTanks.setAdapter(adapterRv);
                title_land.setText(land_arr[3]);
                img_land_title.setImageResource(R.drawable.img_main_usa);
                break;
            case 5:
                setInitData5();
                rvTanks.setAdapter(adapterRv);
                title_land.setText(land_arr[4]);
                img_land_title.setImageResource(R.drawable.img_main_fin);
                break;
            case 6:
                setInitData6();
                rvTanks.setAdapter(adapterRv);
                title_land.setText(land_arr[5]);
                img_land_title.setImageResource(R.drawable.img_main_jp);
                break;
            case 7:
                setInitData7();
                rvTanks.setAdapter(adapterRv);
                title_land.setText(land_arr[6]);
                img_land_title.setImageResource(R.drawable.img_main_ussr);
                break;
            case 8:
                setInitData8();
                rvTanks.setAdapter(adapterRv);
                title_land.setText(land_arr[7]);
                img_land_title.setImageResource(R.drawable.img_main_ital);
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
        land_content_data.add(new LandContent(title_arr[0], content_arr[0],R.drawable.img_ger_main));
        land_content_data.add(new LandContent(title_arr[1],content_arr[1],R.drawable.img_it_main));
        land_content_data.add(new LandContent(title_arr[2],content_arr[2],R.drawable.img_fr_main));
        land_content_data.add(new LandContent(title_arr[3],content_arr[3],R.drawable.img_gb_main));
        land_content_data.add(new LandContent(title_arr[4],content_arr[4],R.drawable.img_jp_main));
        land_content_data.add(new LandContent(title_arr[5],content_arr[5],R.drawable.img_soviet_main));
    }

    public void setInitData2(){
        land_content_data.add(new LandContent(title_arr[0], content_arr[0],R.drawable.img_ger_main));
        land_content_data.add(new LandContent(title_arr[1],content_arr[1],R.drawable.img_it_main));
        land_content_data.add(new LandContent(title_arr[2],content_arr[2],R.drawable.img_fr_main));
        land_content_data.add(new LandContent(title_arr[3],content_arr[3],R.drawable.img_gb_main));
        land_content_data.add(new LandContent(title_arr[4],content_arr[4],R.drawable.img_jp_main));
        land_content_data.add(new LandContent(title_arr[5],content_arr[5],R.drawable.img_soviet_main));
    }

    public void setInitData3(){
        land_content_data.add(new LandContent(title_arr[0], content_arr[0],R.drawable.img_ger_main));
        land_content_data.add(new LandContent(title_arr[1],content_arr[1],R.drawable.img_it_main));
        land_content_data.add(new LandContent(title_arr[2],content_arr[2],R.drawable.img_fr_main));
        land_content_data.add(new LandContent(title_arr[3],content_arr[3],R.drawable.img_gb_main));
        land_content_data.add(new LandContent(title_arr[4],content_arr[4],R.drawable.img_jp_main));
        land_content_data.add(new LandContent(title_arr[5],content_arr[5],R.drawable.img_soviet_main));
    }

    public void setInitData4(){
        land_content_data.add(new LandContent(title_arr[0], content_arr[0],R.drawable.img_ger_main));
        land_content_data.add(new LandContent(title_arr[1],content_arr[1],R.drawable.img_it_main));
        land_content_data.add(new LandContent(title_arr[2],content_arr[2],R.drawable.img_fr_main));
        land_content_data.add(new LandContent(title_arr[3],content_arr[3],R.drawable.img_gb_main));
        land_content_data.add(new LandContent(title_arr[4],content_arr[4],R.drawable.img_jp_main));
        land_content_data.add(new LandContent(title_arr[5],content_arr[5],R.drawable.img_soviet_main));
    }

    public void setInitData5(){
        land_content_data.add(new LandContent(title_arr[0], content_arr[0],R.drawable.img_ger_main));
        land_content_data.add(new LandContent(title_arr[1],content_arr[1],R.drawable.img_it_main));
        land_content_data.add(new LandContent(title_arr[2],content_arr[2],R.drawable.img_fr_main));
        land_content_data.add(new LandContent(title_arr[3],content_arr[3],R.drawable.img_gb_main));
        land_content_data.add(new LandContent(title_arr[4],content_arr[4],R.drawable.img_jp_main));
        land_content_data.add(new LandContent(title_arr[5],content_arr[5],R.drawable.img_soviet_main));
    }

    public void setInitData6(){
        land_content_data.add(new LandContent(title_arr[0], content_arr[0],R.drawable.img_ger_main));
        land_content_data.add(new LandContent(title_arr[1],content_arr[1],R.drawable.img_it_main));
        land_content_data.add(new LandContent(title_arr[2],content_arr[2],R.drawable.img_fr_main));
        land_content_data.add(new LandContent(title_arr[3],content_arr[3],R.drawable.img_gb_main));
        land_content_data.add(new LandContent(title_arr[4],content_arr[4],R.drawable.img_jp_main));
        land_content_data.add(new LandContent(title_arr[5],content_arr[5],R.drawable.img_soviet_main));
    }

    public void setInitData7(){
        land_content_data.add(new LandContent(title_arr[0], content_arr[0],R.drawable.img_ger_main));
        land_content_data.add(new LandContent(title_arr[1],content_arr[1],R.drawable.img_it_main));
        land_content_data.add(new LandContent(title_arr[2],content_arr[2],R.drawable.img_fr_main));
        land_content_data.add(new LandContent(title_arr[3],content_arr[3],R.drawable.img_gb_main));
        land_content_data.add(new LandContent(title_arr[4],content_arr[4],R.drawable.img_jp_main));
        land_content_data.add(new LandContent(title_arr[5],content_arr[5],R.drawable.img_soviet_main));
    }

    public void setInitData8(){
        land_content_data.add(new LandContent(title_arr[0], content_arr[0],R.drawable.img_ger_main));
        land_content_data.add(new LandContent(title_arr[1],content_arr[1],R.drawable.img_it_main));
        land_content_data.add(new LandContent(title_arr[2],content_arr[2],R.drawable.img_fr_main));
        land_content_data.add(new LandContent(title_arr[3],content_arr[3],R.drawable.img_gb_main));
        land_content_data.add(new LandContent(title_arr[4],content_arr[4],R.drawable.img_jp_main));
        land_content_data.add(new LandContent(title_arr[5],content_arr[5],R.drawable.img_soviet_main));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        finish();
    }

}