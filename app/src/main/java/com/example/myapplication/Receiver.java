package com.example.myapplication;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class Receiver extends AppCompatActivity {

    Button btnSend;
    EditText txtName, txtEmail, txtContact, txtCountry, txtAddress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receiver);

        init();

        btnSend.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){

                Intent intent = getIntent();



                String senderName = intent.getStringExtra("senderName");
                String senderEmail = intent.getStringExtra("senderEmail");
                String senderContact = intent.getStringExtra("senderContact");
                String senderCountry = intent.getStringExtra("senderCountry");
                String senderAddress = intent.getStringExtra("senderAddress");

                String receiverName = txtName.getText().toString().trim();
                String receiverEmail = txtEmail.getText().toString().trim();
                String receiverContact = txtContact.getText().toString().trim();
                String receiverCountry = txtCountry.getText().toString().trim();
                String receiverAddress = txtAddress.getText().toString().trim();

                if (receiverEmail.isEmpty()){
                    Toast.makeText(Receiver.this, R.string.empty_email_error, Toast.LENGTH_SHORT).show();
                    return;
                }
                if (receiverName.isEmpty()){
                    Toast.makeText(Receiver.this, R.string.empty_name_error, Toast.LENGTH_SHORT).show();
                    return;
                }
                if (receiverContact.isEmpty()){
                    Toast.makeText(Receiver.this, R.string.empty_contact_error, Toast.LENGTH_SHORT).show();
                    return;
                }
                if (receiverCountry.isEmpty()){
                    Toast.makeText(Receiver.this, R.string.empty_country_error, Toast.LENGTH_SHORT).show();
                    return;
                }
                if (receiverAddress.isEmpty()){
                    Toast.makeText(Receiver.this, R.string.empty_address_error, Toast.LENGTH_SHORT).show();
                    return;
                }

                intent = new Intent(Receiver.this, Review.class);
                intent.putExtra("senderName", senderName);
                intent.putExtra("senderCountry", senderCountry);
                intent.putExtra("senderAddress", senderAddress);
                intent.putExtra("senderContact", senderContact);
                intent.putExtra("receiverName", receiverName);
                intent.putExtra("receiverCountry", receiverCountry);
                intent.putExtra("receiverAddress", receiverAddress);
                intent.putExtra("receiverContact", receiverContact);
                startActivity(intent);
                finish();
            }
        });


    }

    private void init(){
        btnSend = findViewById(R.id.btnReceiverNext);
        txtName = findViewById(R.id.txtReceiverFullName);
        txtEmail = findViewById(R.id.txtReceiverEmail);
        txtContact = findViewById(R.id.txtReceiverContact);
        txtAddress = findViewById(R.id.txtReceiverAddress);
        txtCountry = findViewById(R.id.txtReceiverCountry);
    }
}