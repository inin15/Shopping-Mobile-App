package com.example.shoppingprogram;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;


import androidx.appcompat.app.AppCompatActivity;

public class AddNewAddressActivity extends AppCompatActivity {
    private ImageButton btnBack;
    private Button add;
    private EditText name, phoneNumber, province, street;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addnewaddress);
        name = findViewById(R.id.add_name);
        phoneNumber = findViewById(R.id.add_phone);
        province = findViewById(R.id.add_province);
        street = findViewById(R.id.add_street);
        //Back to previous page
        btnBack = findViewById(R.id.add_new_address_btn_back);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Exit Activity
                finish();
            }
        });
        //Add new address
        add = findViewById(R.id.btn_add_new_address);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Declare Explicit Intent
                Intent intent = new Intent(AddNewAddressActivity.this, AddressListActivity.class);
                String sname = name.getText().toString();
                String sphoneNumber = phoneNumber.getText().toString();
                String saddress = street.getText().toString() + " " + province.getText().toString();
                //Data packaging
                Bundle bundle = new Bundle();
                bundle.putString("name", sname);
                bundle.putString("phonenumber", sphoneNumber);
                bundle.putString("address", saddress);
                //Put into Intent
                intent.putExtra("baddress", bundle);
                startActivity(intent);
            }
        });
    }
}
