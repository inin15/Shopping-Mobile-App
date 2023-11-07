package com.example.shoppingprogram.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.shoppingprogram.R;
import com.example.shoppingprogram.entity.UserAddress;

import java.util.List;

public class AddressAdapter extends RecyclerView.Adapter<AddressAdapter.AddressViewHolder> {
    private List<UserAddress> luseraddress;
    public void setData(List<UserAddress> list){
        this.luseraddress = list;
        //Update the data again when the content of that List changes
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public AddressAdapter.AddressViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_address, parent, false);
        return new AddressViewHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull AddressAdapter.AddressViewHolder holder, int position) {
        UserAddress userAddress = luseraddress.get(position);
        if(userAddress == null){
            return;
        }
        holder.username.setText(userAddress.getUserName());
        holder.phonenumber.setText(userAddress.getPhoneNumber());
        holder.address.setText(userAddress.getAddress());
    }
    @Override
    public int getItemCount() {
        if(luseraddress != null){
            return luseraddress.size();
        }
        return 0;
    }
    public class AddressViewHolder extends RecyclerView.ViewHolder{
        private LinearLayout linearLayout;
        private TextView username;
        private TextView phonenumber;
        private TextView address;
        public AddressViewHolder(@NonNull View itemView) {
            super(itemView);
            username = itemView.findViewById(R.id.address_list_customer_name);
            phonenumber = itemView.findViewById(R.id.address_list_customer_phone);
            address = itemView.findViewById(R.id.address_list_customer_address);
            linearLayout = itemView.findViewById(R.id.item_address);
        }
    }
}
