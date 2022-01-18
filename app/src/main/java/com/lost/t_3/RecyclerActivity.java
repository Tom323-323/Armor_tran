package com.lost.t_3;

//import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
//import android.view.animation.AnimationUtils;
//import android.view.animation.LayoutAnimationController;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
//import android.widget.RatingBar;
//import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityOptionsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import androidx.core.util.Pair;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class RecyclerActivity extends AppCompatActivity implements WeaponsCallback{
    private RecyclerView recyclerView;
    private AdapterRecyclerView adapterRv;
    private List<WeaponsContent> mdata;


//    String s1[], s2[];
//    int image[] = {R.drawable.img_info_1,R.drawable.img_soviet_main,R.drawable.img_info_1,R.drawable.img_soviet_main,
//            R.drawable.img_ger_main,R.drawable.img_info_1,R.drawable.img_ger_main,R.drawable.img_soviet_main,
//            R.drawable.img_info_1,R.drawable.img_soviet_main,R.drawable.img_info_1,R.drawable.img_soviet_main,
//            R.drawable.img_ger_main};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recyclerview_weapons);

        initViews();
        initmdataWeapons();
        setupWeaponsAdapter();

//        s1 = getResources().getStringArray(R.array.recycler_test);
//        s2 = getResources().getStringArray(R.array.recycler_test2);



//        adapterRv = new AdapterRecyclerView(mdata);
//        recyclerView.setAdapter(adapterRv);


    }

    private void initmdataWeapons() {
        mdata = new ArrayList<>();
        mdata.add(new WeaponsContent(R.drawable.img_info_1));
        mdata.add(new WeaponsContent(R.drawable.img_ger_main));
        mdata.add(new WeaponsContent(R.drawable.img_soviet_main));
        mdata.add(new WeaponsContent(R.drawable.img_info_1));
        mdata.add(new WeaponsContent(R.drawable.img_ger_main));
        mdata.add(new WeaponsContent(R.drawable.img_info_1));
        mdata.add(new WeaponsContent(R.drawable.img_soviet_main));
        mdata.add(new WeaponsContent(R.drawable.img_ger_main));
        mdata.add(new WeaponsContent(R.drawable.img_ger_main));
        mdata.add(new WeaponsContent(R.drawable.img_soviet_main));
        mdata.add(new WeaponsContent(R.drawable.img_info_1));
        mdata.add(new WeaponsContent(R.drawable.img_ger_main));
        mdata.add(new WeaponsContent(R.drawable.img_soviet_main));
    }

    private void initViews() {
        recyclerView = findViewById(R.id.recyclerview_weapons);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
    }

    private void setupWeaponsAdapter(){
        adapterRv = new AdapterRecyclerView(mdata, this);
        recyclerView.setAdapter(adapterRv);
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public void onWeaponsCallback(int pos,
                                  ImageView imgBackgr,
                                  ImageView imgWeapons,
                                  TextView nameWeapons) {

        Intent intent = new Intent(this, ContentActivity.class);
        intent.putExtra("WeaponsObj", mdata.get(pos));

        Pair<View,String> p1 = Pair.create((View)imgBackgr,"background");
        Pair<View,String> p2 = Pair.create((View)imgWeapons,"image_gun");
        Pair<View,String> p3 = Pair.create((View)nameWeapons,"name_gun");


        ActivityOptionsCompat optionsCompat =
                ActivityOptionsCompat.makeSceneTransitionAnimation(this,p1,p2,p3);

        startActivity(intent, optionsCompat.toBundle());

    }
}
