package com.hotel.stocksystem;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class productViewHolder extends RecyclerView.ViewHolder {
    public TextView Name;
    public TextView status;
    public TextView type1;
    public TextView type2;
    public TextView type3;
    public TextView specifications;
    public TextView desiredprice;
    public TextView details;
    public TextView date;
    public ImageView image;
    public LinearLayout post;

    public productViewHolder(@NonNull View itemView) {
        super(itemView);

        Name=itemView.findViewById(R.id.Name);
        status=itemView.findViewById(R.id.status);
        image=itemView.findViewById(R.id.image);
        type1=itemView.findViewById(R.id.type1);
        type2=itemView.findViewById(R.id.type2);
        type3=itemView.findViewById(R.id.type3);
        specifications=itemView.findViewById(R.id.specifications);
        desiredprice=itemView.findViewById(R.id.desiredprice);
        details=itemView.findViewById(R.id.details);
        date=itemView.findViewById(R.id.date);
        post=itemView.findViewById(R.id.post);


    }
}
