package com.lost.t_3;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class AdapterRV extends RecyclerView.Adapter<AdapterRV.Numberholder>{

    private final int numbersHolder; // КОЛИЧЕСВТО ЭЛЕМЕНТОВ В СПИСКЕ - КОНЕЧНОЕ ЗНАЧЕНИЕ (50 ТАНКОВ, 45 САМОХОДОК, 30 ЗЕНИТОК... И Т.Д.)

    public AdapterRV(int numbers) {
        numbersHolder = numbers;
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
    public void onBindViewHolder(@NonNull Numberholder holder, int position) {   // ПЕРЕСОЗДАНИЕ ХОЛДЕРОВ С НОВЫМИ ЗНАЧЕНИЯМИ

    }

    @Override
    public int getItemCount() {   // ВОЗВРАЩАЕТ ОБЩЕЕ КОЛИЧЕСТВО ЭЛЕМЕНТОВ
        return numbersHolder;
    }

    class Numberholder extends RecyclerView.ViewHolder {

        TextView nameTanks, textTanks;
        ImageView imgHolder;
        Button btnHolder;

        public Numberholder(@NonNull View itemView) {
            super(itemView);
            nameTanks = itemView.findViewById(R.id.tv_title_holder);
            textTanks = itemView.findViewById(R.id.tv_opisanie_holder);
            imgHolder = itemView.findViewById(R.id.img_viewHolder);
            btnHolder = itemView.findViewById(R.id.btn_viewHolder);

        }
    }
}
