package com.example.shoppingprogram.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
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
        holder.product_img.setImageResource(product.getImgProduct());
        holder.productName.setText(product.getProductName());
        holder.productPrice.setText(product.getProductPrice());
        //holder.add_to_cart.setImageResource(product.getAddToCartButton());
        holder.relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClickGoDetail();
            }
        });
    }
    public void onClickGoDetail(){
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
    public void setData(List<Product> list){
        this.lProduct = list;
        //Update the data again when the content of that List changes
        notifyDataSetChanged();
    }
    public class ProductViewHolder extends RecyclerView.ViewHolder{
        private RelativeLayout relativeLayout;
        private ImageView product_img;
        private TextView productName;
        private TextView productPrice;
        private ImageButton add_to_cart;
        public ProductViewHolder(@NonNull View itemView) {
            super(itemView);
            product_img = itemView.findViewById(R.id.product_img);
            productName = itemView.findViewById(R.id.product_name);
            productPrice = itemView.findViewById(R.id.product_price);
            add_to_cart = itemView.findViewById(R.id.add_to_cart_in_list);
            relativeLayout = itemView.findViewById(R.id.item_product);
        }
    }
}
