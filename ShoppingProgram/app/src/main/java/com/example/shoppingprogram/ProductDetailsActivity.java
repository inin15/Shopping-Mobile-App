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

import java.util.Random;

public class ProductDetailsActivity extends AppCompatActivity {
    private static final String[] areaCodes = {"123", "456", "789", "321", "654", "987"}; // Danh sách mã vùng mẫu
    TextView shopphone;
    ImageButton contactstore;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.product_details);
        contactstore = findViewById(R.id.contact_store);
        shopphone = findViewById(R.id.shop_phone);
//        contactstore.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                //Declare Implicit Intent
//                Intent callStore = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + shopphone.getText().toString()));
//                //Check Permission
//                if(ActivityCompat.checkSelfPermission(ProductDetailsActivity.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED){
//                    ActivityCompat.requestPermissions(ProductDetailsActivity.this, new String[]{Manifest.permission.CALL_PHONE}, 1);
//                    return;
//                }
//                startActivity(callStore);
//            }
//        });
        // Khởi tạo ngẫu nhiên một số điện thoại và hiển thị nó
        String randomPhoneNumber = generateRandomPhoneNumber();
        shopphone.setText(randomPhoneNumber);
        contactstore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:098" + randomPhoneNumber));
                startActivity(intent);
            }
        });
    }
        // Hàm tạo số điện thoại ngẫu nhiên
        private String generateRandomPhoneNumber() {
            Random random = new Random();
            String areaCode = areaCodes[random.nextInt(areaCodes.length)]; // Lựa chọn mã vùng ngẫu nhiên
            String localNumber = String.format("%04d", random.nextInt(10000)); // Số điện thoại cục bộ ngẫu nhiên
            return "098" + areaCode + localNumber;
        }
    }

