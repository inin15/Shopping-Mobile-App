package com.example.shoppingprogram;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.shoppingprogram.adapter.AddressAdapter;
import com.example.shoppingprogram.entity.User;

import java.util.ArrayList;
import java.util.List;

public class AddressListActivity extends AppCompatActivity {
    private RecyclerView rcvAddress;
    private AddressAdapter addressAdapter;
    private List<User> luser;
    private Button addNewAddress;
    private ImageButton btnBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chooseaddress);
        rcvAddress = findViewById(R.id.rcv_address);
        addressAdapter = new AddressAdapter();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        rcvAddress.setLayoutManager(linearLayoutManager);
        rcvAddress.setFocusable(false);
        rcvAddress.setNestedScrollingEnabled(true);
        luser = new ArrayList<>();
//        //Get data
//        Intent rintent = getIntent();
//        //Get Bundle out of Intent
//        Bundle bundle = rintent.getBundleExtra("baddress");
//        if(bundle.getString("name") != null && bundle.getString("phonenumber") != null && bundle.getString("address") != null){
//            luser.add(new User(bundle.getString("name"), bundle.getString("phonenumber"), bundle.getString("address")));
//        }
        addressAdapter.setData(luser);
        rcvAddress.setAdapter(addressAdapter);
        //Add New Address
        addNewAddress = findViewById(R.id.btn_add_new_address);
        addNewAddress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Declare Explicit Intent
                Intent intent = new Intent(AddressListActivity.this, AddNewAddressActivity.class);
                startActivity(intent);
            }
        });
        //Back to previous page
        btnBack = findViewById(R.id.address_btn_back);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Exit Activity
                finish();
            }
        });

    }
}
