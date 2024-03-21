package com.hotel.stocksystem;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.gson.Gson;
import com.hotel.stocksystem.databinding.ActivityAddproductitem2Binding;

import java.text.SimpleDateFormat;
import java.util.Date;


public class AddproductitemActivity extends AppCompatActivity {
    ActivityAddproductitem2Binding binding;
    Productitem productitem = new Productitem();
    boolean isForEdit = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addproductitem2);
        binding = ActivityAddproductitem2Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setTitle("Edit products");
        }
        if (getIntent().hasExtra("data")) {
            productitem = new Gson().fromJson(getIntent().getStringExtra("data"), Productitem.class);
            isForEdit = true;
            binding.Name.setText(productitem.getName());
            binding.type1.setText(productitem.getType1());
            binding.type2.setText(productitem.getType2());
            binding.type3.setText(productitem.getType3());
            binding.specifications.setText(productitem.getSpecifications());
            binding.desiredprice.setText(productitem.getDesiredprice());
            binding.status.setText(productitem.getStatus());

        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_add_items, menu);
        return true;

    }

    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.save) {
            if (binding.type1.isChecked()) {
                item.setTitle("laptop");
            }
            if (binding.type2.isChecked()) {
                item.setTitle("tablet");
            }
            if (binding.type3.isChecked()) {
                item.setTitle("mobile");

            }
            if (binding.Name.getText().toString().isEmpty() && binding .details.getText().toString().isEmpty() && binding.specifications.getText().toString().isEmpty() && binding.desiredprice.getText().toString().isEmpty() && binding.type1.getText().toString().isEmpty() && binding.type2.getText().toString().isEmpty() && binding.type3.getText().toString().isEmpty()) {
                Toast.makeText(this, "They are all empty", Toast.LENGTH_SHORT).show();
                return true;
            }
            productitem.setName(binding.Name.getText().toString());
            productitem.setType1(binding.type1.getText().toString());
            productitem.setType2(binding.type2.getText().toString());
            productitem.setType3(binding.type3.getText().toString());
            productitem.setSpecifications(binding.specifications.getText().toString());
            productitem.setDesiredprice(binding.desiredprice.getText().toString());
            productitem.setStatus(binding.status.getText().toString());
            productitem.setDescription(binding.details.getText().toString());
            if(!isForEdit)
                productitem.setSoldAt(new SimpleDateFormat("yyyy-MM-dd HH:mm a").format(new Date()));
            productitem.setUpdatedAt(new SimpleDateFormat("yyyy-MM-dd HH:mm a").format(new Date()));
StockDatabase.getDatabase(this).productDuo().insertorreplace(productitem);
            Toast.makeText(this, "Product saved successfully", Toast.LENGTH_SHORT).show();
            finish();
            return true;






        }
        if(item.getItemId()==android.R.id.home){
            finish();
            return true;
        }

return super.onOptionsItemSelected(item);
    }
}





