package com.example.shoppingprogram;
import android.content.Intent;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class OrderActivity extends AppCompatActivity {
    ImageButton btnBack, chooseAddress;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        //Back to previous page
        btnBack = findViewById(R.id.order_btn_back);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Exit Activity
                finish();
            }
        });
        //Choose Address
        chooseAddress = findViewById(R.id.choose_address);
        chooseAddress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Declare Explicit Intent
                Intent intent = new Intent(OrderActivity.this, AddressListActivity.class);
                startActivity(intent);
            }
        });
    }
}
