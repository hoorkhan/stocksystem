package com.hotel.stocksystem;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;

import java.util.List;

public class productAdapter extends RecyclerView.Adapter<productViewHolder> {
    Context context;
    List<Productitem> data;

    public productAdapter(Context context, List<Productitem> data) {
        this.context = context;
        this.data = data;
    }

    @NonNull
    @Override
    public productViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.item,parent,false);
        return new productViewHolder(view) ;
    }

    @Override
    public void onBindViewHolder(@NonNull productViewHolder holder, int position) {
Productitem productitem=data.get(position);

holder.Name.setText(productitem.getName());
holder.status.setText(productitem.getStatus());
holder.type1.setText(productitem.getType1());
holder.type2.setText(productitem.getType2());
holder.type3.setText(productitem.getType3());
holder.specifications.setText(productitem.getSpecifications());
holder.desiredprice.setText(productitem.getDesiredprice());
holder.details.setText(productitem.getDescription());
holder.date.setText(productitem.getSoldAt());
holder.image.setImageResource(productitem.getImage());
holder.post.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent intent=new Intent(context, MainActivity2.class);
intent.putExtra("data",new Gson().toJson(productitem));
context.startActivity(intent);
    }
});
    }

    @Override
    public int getItemCount() {
return data.size();
    }
}
