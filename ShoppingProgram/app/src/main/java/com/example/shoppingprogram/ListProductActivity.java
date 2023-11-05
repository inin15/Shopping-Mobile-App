package com.example.shoppingprogram;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.shoppingprogram.adapter.ProductAdapter;
import com.example.shoppingprogram.entity.Product;

import java.util.ArrayList;
import java.util.List;

public class ListProductActivity extends AppCompatActivity {
    private RecyclerView rcvProduct;
    private ProductAdapter productAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listproduct);
        rcvProduct = findViewById(R.id.rcv_product);
        productAdapter = new ProductAdapter(this, getListProduct());
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        rcvProduct.setLayoutManager(linearLayoutManager);
        rcvProduct.setFocusable(false);
        rcvProduct.setNestedScrollingEnabled(true);
        productAdapter.setData(getListProduct());
        rcvProduct.setAdapter(productAdapter);
    }
    public List<Product> getListProduct(){
        List<Product> list = new ArrayList<>();
        list.add(new Product(R.drawable.product, "Product 1", "1000$"));
        list.add(new Product(R.drawable.product, "Product 1", "1000$"));
        list.add(new Product(R.drawable.product, "Product 1", "1000$"));
        list.add(new Product(R.drawable.product, "Product 1", "1000$"));
        list.add(new Product(R.drawable.product, "Product 1", "1000$"));
        list.add(new Product(R.drawable.product, "Product 1", "1000$"));
        return list;
    }
}
