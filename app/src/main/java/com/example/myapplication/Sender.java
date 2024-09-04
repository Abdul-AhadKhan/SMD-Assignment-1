package com.example.myapplication;

import android.content.Intent;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import java.security.Key;

public class Sender extends AppCompatActivity {

    Button btnSend;
    EditText txtName, txtEmail, txtCountry, txtContact, txtAddress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sender);

        init();

        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String name = txtName.getText().toString().trim();
                String email = txtEmail.getText().toString().trim();
                String contact = txtContact.getText().toString().trim();
                String country = txtCountry.getText().toString().trim();
                String address = txtAddress.getText().toString().trim();

                if (email.isEmpty()){
                    Toast.makeText(Sender.this, R.string.empty_email_error, Toast.LENGTH_SHORT).show();
                    return;
                }
                if (name.isEmpty()){
                    Toast.makeText(Sender.this, R.string.empty_name_error, Toast.LENGTH_SHORT).show();
                    return;
                }
                if (contact.isEmpty()){
                    Toast.makeText(Sender.this, R.string.empty_contact_error, Toast.LENGTH_SHORT).show();
                    return;
                }
                if (country.isEmpty()){
                    Toast.makeText(Sender.this, R.string.empty_country_error, Toast.LENGTH_SHORT).show();
                    return;
                }
                if (address.isEmpty()){
                    Toast.makeText(Sender.this, R.string.empty_address_error, Toast.LENGTH_SHORT).show();
                    return;
                }


                Intent intent = new Intent(Sender.this, Receiver.class);
                intent.putExtra("senderName", name);
                intent.putExtra("senderEmail", email);
                intent.putExtra("senderContact", contact);
                intent.putExtra("senderCountry", country);
                intent.putExtra("senderAddress", address);
                startActivity(intent);
                finish();
            }
        });

//        txtEmail.setOnEditorActionListener(new TextView.OnEditorActionListener(){
//            @Override
//            public boolean onEditorAction(TextView v, int actionId, KeyEvent event){
//                if (actionId == EditorInfo.IME_ACTION_NEXT){
//                    txtName.requestFocus();
//                    return true;
//                }
//                return false;
//            }
//        });
//
//        txtName.setOnEditorActionListener(new TextView.OnEditorActionListener() {
//            @Override
//            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
//                if (i == EditorInfo.IME_ACTION_NEXT){
//                    txtContact.requestFocus();
//                    return true;
//                }
//                return false;
//            }
//        });
//
//        txtContact.setOnEditorActionListener(new TextView.OnEditorActionListener() {
//            @Override
//            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
//                if (i == EditorInfo.IME_ACTION_NEXT){
//                    txtCountry.requestFocus();
//                    return true;
//                }
//                return false;
//            }
//        });
//
//        txtCountry.setOnEditorActionListener(new TextView.OnEditorActionListener() {
//            @Override
//            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
//                if (i == EditorInfo.IME_ACTION_NEXT){
//                    txtAddress.requestFocus();
//                    return true;
//                }
//                return false;
//            }
//        });
    }


    private void init(){
        btnSend = findViewById(R.id.btnSenderNext);
        txtEmail = findViewById(R.id.txtSenderEmail);
        txtName = findViewById(R.id.txtSenderFullName);
        txtAddress = findViewById(R.id.txtSenderAddress);
        txtContact = findViewById(R.id.txtSenderContact);
        txtCountry = findViewById(R.id.txtSenderCountry);
    }
}