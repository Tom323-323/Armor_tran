package com.lost.t_3.presenter.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.lost.t_3.domain.LandContent;
import com.lost.t_3.R;
import com.lost.t_3.presenter.RecyclerActivity;

import java.util.List;

public class AdapterRV extends RecyclerView.Adapter<AdapterRV.Numberholder>{


    private final int numbersHolder; // КОЛИЧЕСВТО ЭЛЕМЕНТОВ В СПИСКЕ - КОНЕЧНОЕ ЗНАЧЕНИЕ (50 ТАНКОВ, 45 САМОХОДОК, 30 ЗЕНИТОК... И Т.Д.)
    List <LandContent> land_content_data;
    public int indexLand = 12;

    public AdapterRV(List<LandContent> land_content_data, int numbers) {
        this.land_content_data = land_content_data;
        this.numbersHolder = numbers;

    }

    @NonNull
    @Override
    public Numberholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {    // СОЗДАНИЕ НОВОГО ХОЛДЕРА
        Context context = parent.getContext(); //контест - это объект recyclerView
        int layoutMaketHolder = R.layout.view_holder_tanks; // НАХОДИМ МАКЕТ ХОЛДЕРА
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(layoutMaketHolder, parent, false); // СОЗДАНЕНИЕ VIEW ДЛЯ ПОСЛЕДУЮЩЕГО ПОМЕЩЕНИЯ ЕГО В ОБЪЕКТ NUMBERHOLDER
        Numberholder holder = new Numberholder(view);

        return holder;

    }

    @Override
    public void onBindViewHolder(@NonNull final Numberholder holder, @SuppressLint("RecyclerView") final int position) {
        final LandContent content = land_content_data.get(position);
        holder.img_land.setImageResource(content.getImg_land());
        holder.title_text.setText(content.getTitle_text());
        holder.content_text.setText(content.getContent_text());
        holder.btnHolder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), RecyclerActivity.class);
                intent.putExtra("typeWeapons", indexLand);
                Log.d("ADD", String.valueOf(indexLand));
                v.getContext().startActivity(intent);

            }
        });
    }

    @Override
    public int getItemCount() {   // ВОЗВРАЩАЕТ ОБЩЕЕ КОЛИЧЕСТВО ЭЛЕМЕНТОВ
        return numbersHolder;
    }

    class Numberholder extends RecyclerView.ViewHolder{

        final TextView title_text, content_text;
        final ImageView img_land;
        final Button btnHolder;

        public Numberholder(@NonNull View itemView) {
            super(itemView);
            title_text = itemView.findViewById(R.id.tv_title_holder);
            content_text = itemView.findViewById(R.id.tv_opisanie_holder);
            img_land = itemView.findViewById(R.id.img_viewHolder);
            btnHolder = itemView.findViewById(R.id.btn_viewHolder);


        }
    }
}
