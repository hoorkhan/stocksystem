package com.hotel.stocksystem;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
RecyclerView recycle;
productAdapter adapter;


List<Productitem> data=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
adapter=new productAdapter(this,data);
recycle=findViewById(R.id.recycle);
        GridLayoutManager gridLayoutManager=new GridLayoutManager(this,2,GridLayoutManager.VERTICAL,false);

recycle.setLayoutManager(gridLayoutManager);
recycle.hasFixedSize();
recycle.setAdapter(adapter);


findViewById(R.id.addFab).setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        startActivity(new Intent(MainActivity.this, AddproductitemActivity.class));
    }
});
//@Override
//
//protected void onResume(){
//            super.onResume();
//            data.clear();
//            data.addAll(StockDatabase.getDatabase(this).productDuo().getAll());
//            adapter.notifyDataSetChanged();
//        }
}
    @Override
    protected void onResume(){
        super.onResume();
        data.clear();
        data.addAll(StockDatabase.getDatabase(this).productDuo().getAll());
        adapter.notifyDataSetChanged();

    }

    }

