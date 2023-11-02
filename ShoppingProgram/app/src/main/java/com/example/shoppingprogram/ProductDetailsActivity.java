package com.example.shoppingprogram;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

public class ProductDetailsActivity extends AppCompatActivity {
    TextView shopphone;
    ImageButton contactstore;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.product_details);
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
    }
}
