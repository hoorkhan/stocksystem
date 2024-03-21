package com.hotel.stocksystem;

import static android.widget.Toast.LENGTH_SHORT;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.gson.Gson;
import com.hotel.stocksystem.databinding.ActivityMain2Binding;

public class MainActivity2 extends AppCompatActivity {
    ActivityMain2Binding binding;
    Productitem productitem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        binding = ActivityMain2Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        productitem = new Gson().fromJson(getIntent().getStringExtra("data"), Productitem.class);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(productitem.getName());
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
        binding.Name.setText(productitem.getName());
        binding.specifications.setText(productitem.getSpecifications());
        binding.status.setText(productitem.getStatus());
        binding.Name.setText(productitem.getType1());
        binding.Name.setText(productitem.getType2());
        binding.Name.setText(productitem.getType3());
        binding.desiredprice.setText(productitem.getDesiredprice());
        binding.soldAt.setText(productitem.getSoldAt());
        binding.updatedAt.setText(productitem.getUpdatedAt());
        binding.details.setText(productitem.getDescription());
        binding.edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity2.this, AddproductitemActivity.class).putExtra("data", new Gson().toJson(productitem)));
                finish();
            }
        });
        binding.delete.setOnClickListener(new View.OnClickListener() {




            @Override
            public void onClick(View v) {
                AlertDialog.Builder alert;
                alert = new AlertDialog.Builder(MainActivity2.this);
                alert.setTitle(" sure to delete the product?");
                alert.setMessage("Are you sure you want to delete ");
                alert.setCancelable(false);
                alert.setPositiveButton("Yes,delete",(dialog, which) ->{
                    StockDatabase.getDatabase(MainActivity2.this).productDuo().delete(productitem);
                    Toast.makeText(MainActivity2.this,"Deleted",Toast.LENGTH_SHORT).show();
                    finish();

                } );
                alert.setNegativeButton(android.R.string.no, (dialog, which) -> {

                    dialog.dismiss();

                });
                alert.show();}
            });

    }
}