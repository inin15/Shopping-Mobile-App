package com.example.shoppingprogram.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.shoppingprogram.ProductDetailsActivity;
import com.example.shoppingprogram.R;
import com.example.shoppingprogram.entity.Product;

import java.util.List;
public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder>{
    private Context context;
    private List<Product> lProduct;
    public ProductAdapter(Context context, List<Product> lProduct) {
        this.context = context;
        this.lProduct = lProduct;
    }
    public void setData(List<Product> list){
        this.lProduct = list;
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_product, parent, false);
        return new ProductViewHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {
        Product product = lProduct.get(position);
        if(product == null){
            return;
        }
        holder.imgProduct.setImageResource(product.getProductId());
        holder.tvProductName.setText(product.getDescription());
        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClickGoDetail(product);
            }
        });

    }
    private void onClickGoDetail(Product product){
        Intent intent = new Intent(context, ProductDetailsActivity.class);
        context.startActivity(intent);
    }
    @Override
    public int getItemCount() {
        if(lProduct != null){
            return lProduct.size();
        }
        return 0;
    }
    public class ProductViewHolder extends RecyclerView.ViewHolder{
        private LinearLayout linearLayout;
        private ImageView imgProduct;
        private TextView tvProductName;
        public ProductViewHolder(@NonNull View itemView) {
            super(itemView);
            imgProduct = itemView.findViewById(R.id.img_product);
            tvProductName = itemView.findViewById(R.id.tv_productName);
            linearLayout = itemView.findViewById(R.id.layout_item);
        }
    }
}
