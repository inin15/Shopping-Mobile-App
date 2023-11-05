package com.example.shoppingprogram;

import android.graphics.Rect;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.EditText;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.shoppingprogram.adapter.MessageAdapter;
import com.example.shoppingprogram.entity.Message;

import java.util.ArrayList;
import java.util.List;

public class MessageActivity extends AppCompatActivity {
    RecyclerView rcvMessage;
    MessageAdapter messageAdapter;
    private List<Message> lMessage;
    private EditText editMessage;
    private ImageButton send;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_messagetoshop);
        editMessage = findViewById(R.id.et_message);
        rcvMessage = findViewById(R.id.rcv_message);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        rcvMessage.setLayoutManager(linearLayoutManager);
        lMessage = new ArrayList<>();
        messageAdapter = new MessageAdapter();
        messageAdapter.setData(lMessage);
        rcvMessage.setAdapter(messageAdapter);
        send = findViewById(R.id.send_message);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendMessage();
            }
        });
        editMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkStatusKeyBroad();
            }
        });
    }
    public void sendMessage(){
        String sMessage = editMessage.getText().toString().trim();
        if(TextUtils.isEmpty(sMessage)){
            return;
        }
        lMessage.add(new Message(sMessage));
        messageAdapter.notifyDataSetChanged();
        rcvMessage.scrollToPosition(lMessage.size()-1);
        editMessage.setText("");
    }
    public void checkStatusKeyBroad(){
        final View activityMessageToShop = findViewById(R.id.activity_message_to_shop);
        activityMessageToShop.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                Rect rect = new Rect();
                //rect will be populated with the coordinates of your view that area still visible
                activityMessageToShop.getWindowVisibleDisplayFrame(rect);
                int heightDiff = activityMessageToShop.getRootView().getHeight() - rect.height();
                if(heightDiff > 0.25*activityMessageToShop.getRootView().getHeight()){
                    //Keybroad display
                    if(lMessage.size() > 0){
                        rcvMessage.scrollToPosition(lMessage.size()-1);
                        activityMessageToShop.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                    }
                }
            }
        });
    }
}
