package com.lost.t_3.presenter.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.lost.t_3.R;
import com.lost.t_3.domain.WeaponsCallback;
import com.lost.t_3.domain.WeaponsContent;

import java.util.List;

public class AdapterRecyclerView extends RecyclerView.Adapter<AdapterRecyclerView.MyViewHolder> {

   List <WeaponsContent> mdata;

    WeaponsCallback callback;

    public AdapterRecyclerView(List<WeaponsContent> mdata, WeaponsCallback callback) {       // Добавить массивы с текстовыми и графическими данными в holder
       this.mdata = mdata;
       this.callback = callback;

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.view_holder, parent, false);


        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

            Glide
                    .with(holder.itemView.getContext())
                    .load(mdata.get(position).getDrawableResourse())
                    .transforms(new CenterCrop(), new RoundedCorners(16))
                    .into(holder.image1);

    }

    @Override
    public int getItemCount() {
                return mdata.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        TextView name, calibr, razrab,constr;
        ImageView image1,backgr;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);


            calibr = itemView.findViewById(R.id.holder_calibr_gun);
            razrab = itemView.findViewById(R.id.razrab_year);
            constr = itemView.findViewById(R.id.constructor_men);

            image1 = itemView.findViewById(R.id.holder_img_gun);    //_______________Transition View
            backgr = itemView.findViewById(R.id.background);
            name = itemView.findViewById(R.id.holder_name_gun);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    callback.onWeaponsCallback(getAbsoluteAdapterPosition(),
                            backgr,
                            image1,
                            name
                            );
                }
            });
        }
    }
}
