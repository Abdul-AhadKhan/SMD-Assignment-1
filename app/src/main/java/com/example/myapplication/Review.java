package com.example.myapplication;

import android.content.Intent;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class Review extends AppCompatActivity {

    TextView tvSenderName, tvSenderCountry, tvSenderAddress, tvSenderContact;
    TextView tvReceiverName, tvReceiverCountry, tvReceiverAddress, tvReceiverContact;
    FloatingActionButton fabbtnNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review);
        init();
        Intent intent = getIntent();
        if (intent != null) {

            tvSenderName.setText(intent.getStringExtra("senderName"));
            tvSenderCountry.setText(intent.getStringExtra("senderCountry"));
            tvSenderAddress.setText(intent.getStringExtra("senderAddress"));
            tvSenderContact.setText(intent.getStringExtra("senderContact"));

            tvReceiverName.setText(intent.getStringExtra("receiverName"));
            tvReceiverCountry.setText(intent.getStringExtra("receiverCountry"));
            tvReceiverAddress.setText(intent.getStringExtra("receiverAddress"));
            tvReceiverContact.setText(intent.getStringExtra("receiverContact"));

        }

        fabbtnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Review.this, Sender.class);
                startActivity(intent);
                finish();
            }
        });
    }

    private void init(){
        tvSenderName = findViewById(R.id.trtxtSenderName);
        tvSenderCountry = findViewById(R.id.trtxtCSenderountry);
        tvSenderAddress = findViewById(R.id.trtxtSenderAddress);
        tvSenderContact = findViewById(R.id.trtxtSenderContactInfo);

        tvReceiverName = findViewById(R.id.trtxtReceiverName);
        tvReceiverCountry = findViewById(R.id.trtxtReceiverCountry);
        tvReceiverAddress = findViewById(R.id.trtxtReceiverAddress);
        tvReceiverContact = findViewById(R.id.trtxtReceiverContactInfor);

        fabbtnNext = findViewById(R.id.fabbtnNext);

    }
}