package com.example.shoppingprogram;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

public class ProductDetailsActivity extends AppCompatActivity {
    TextView shopphone;
    ImageButton chatWithShop, contactstore;
    Button buy;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.product_details);
        //Contact Store by Phone
        contactstore = findViewById(R.id.contact_store);
        shopphone = findViewById(R.id.shop_phone);
        contactstore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Declare Implicit Intent
                Intent callStore = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + shopphone.getText().toString()));
                //Check Permission
                if(ActivityCompat.checkSelfPermission(ProductDetailsActivity.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED){
                    ActivityCompat.requestPermissions(ProductDetailsActivity.this, new String[]{Manifest.permission.CALL_PHONE}, 1);
                    return;
                }
                startActivity(callStore);
            }
        });
        //Click to Chat with shop
        chatWithShop = findViewById(R.id.chat_with_shop);
        chatWithShop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Declare Explicit Intent
                Intent intent = new Intent(ProductDetailsActivity.this, MessageActivity.class);
                startActivity(intent);
            }
        });
        //Click "Buy" Button
        buy = findViewById(R.id.btn_buy);
        buy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Declare Explicit Intent
                Intent intent = new Intent(ProductDetailsActivity.this, OrderActivity.class);
                startActivity(intent);
            }
        });
    }
}
