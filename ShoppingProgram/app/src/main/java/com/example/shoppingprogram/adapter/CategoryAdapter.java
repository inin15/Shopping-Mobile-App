package com.example.shoppingprogram.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.shoppingprogram.ListProductActivity;
import com.example.shoppingprogram.R;
import com.example.shoppingprogram.entity.Category;
import com.example.shoppingprogram.ui.home.HomeViewModel;

import java.util.List;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder>{
    private List<Category> lCategory;
    private Context context;
    public CategoryAdapter(Context context, List<Category> lCategory) {
        this.context = context;
        this.lCategory = lCategory;
    }
    public void setData(List<Category> lCategory){
        this.lCategory = lCategory;
        //Update the data again when the content of that List changes
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_category, parent, false);
        return new CategoryViewHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder holder, int position) {
        Category category = lCategory.get(position);
        if(category == null){
            return;
        }
        holder.imgCategory.setImageResource(category.getImgCategory());
        holder.nameCategory.setText(category.getNameCategory());
        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClickGoDetail();
            }
        });
    }
    public void onClickGoDetail(){
        Intent intent = new Intent(context, ListProductActivity.class);
        context.startActivity(intent);
    }
    @Override
    public int getItemCount(){
        if(lCategory != null){
            return lCategory.size();
        }
        return 0;
    }
    public class CategoryViewHolder extends RecyclerView.ViewHolder{
        private LinearLayout linearLayout;
        private ImageView imgCategory;
        private TextView nameCategory;
        public CategoryViewHolder(@NonNull View itemView){
            super(itemView);
            imgCategory = itemView.findViewById(R.id.img_category);
            nameCategory = itemView.findViewById(R.id.name_category);
            linearLayout = itemView.findViewById(R.id.item_category);
        }
    }
}
