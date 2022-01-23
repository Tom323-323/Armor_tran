package com.lost.t_3;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.core.content.res.ResourcesCompat;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AdapterRV extends RecyclerView.Adapter<AdapterRV.Numberholder>{


    private final int numbersHolder; // КОЛИЧЕСВТО ЭЛЕМЕНТОВ В СПИСКЕ - КОНЕЧНОЕ ЗНАЧЕНИЕ (50 ТАНКОВ, 45 САМОХОДОК, 30 ЗЕНИТОК... И Т.Д.)
    List <LandContent> land_content_data;

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
    public void onBindViewHolder(@NonNull Numberholder holder, int position) {
        LandContent content = land_content_data.get(position);
        holder.img_land.setImageResource(content.getImg_land());
        holder.title_text.setText(content.getTitle_text());
        holder.content_text.setText(content.getContent_text());
        holder.btnHolder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("MyLog", "click lllllllllllllll");
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

//        @Override
//        public void onClick(View v) {
//            int position = getAdapterPosition();
//            if(position != RecyclerView.NO_POSITION)btnClickLand (position);
//        }
//
//        private void btnClickLand(int position) {
//            Intent intent = new Intent(itemView.getContext(), RecyclerActivity.class);
//            switch (position){
//                case 0:
//                    itemView.getContext().startActivity(intent);
//                    Toast.makeText(itemView.getContext(), "111111", Toast.LENGTH_SHORT).show();
//                    break;
//                case 1:
//                    itemView.getContext().startActivity(intent);
//                    Toast.makeText(itemView.getContext(), "2222", Toast.LENGTH_SHORT).show();
//                    break;
//                case 2:
//                    itemView.getContext().startActivity(intent);
//                    Toast.makeText(itemView.getContext(), "333333", Toast.LENGTH_SHORT).show();
//                    break;
//                case 3:
//                    itemView.getContext().startActivity(intent);
//                    Toast.makeText(itemView.getContext(), "44444", Toast.LENGTH_SHORT).show();
//                    break;
//                case 4:
//                    Toast.makeText(itemView.getContext(), "5555", Toast.LENGTH_SHORT).show();
//                    itemView.getContext().startActivity(intent);
//                    break;
//                case 5:
//                    Toast.makeText(itemView.getContext(), "6666", Toast.LENGTH_SHORT).show();
//                    itemView.getContext().startActivity(intent);
//                    break;
//
//            }
//        }
    }
}
