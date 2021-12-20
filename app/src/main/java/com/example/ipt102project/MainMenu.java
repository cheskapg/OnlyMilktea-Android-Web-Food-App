package com.example.ipt102project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.ornach.nobobutton.NoboButton;

public class MainMenu extends AppCompatActivity {


    //DECLARE ALL COMPONENTS
    NoboButton NoboButton_CreateOrder;
    NoboButton NoboButton_OrdersMade;
    NoboButton NoboButton_About;
    NoboButton NoboButton_CustomerDetails;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getSupportActionBar().hide();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        NoboButton_CreateOrder = findViewById(R.id.NoboButton_MenuCreateOrder);
        NoboButton_OrdersMade = findViewById(R.id.NoboButton_OrdersMade);
        NoboButton_About = findViewById(R.id.NoboButton_About);
        NoboButton_CustomerDetails = findViewById(R.id.NoboButton_CustomerDetails);

        NoboButton_CreateOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CustomerDetailsWindow();

            }
            public  void CustomerDetailsWindow(){
                Intent movetoCustomerDetails = new Intent(MainMenu.this, CustomerDetails.class);
                startActivity(movetoCustomerDetails);
            }


        });

        NoboButton_About.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AboutWindow();

            }
            public  void AboutWindow(){
                Intent movetoAbout = new Intent(MainMenu.this, About.class);
                startActivity(movetoAbout);
            }

        });
        NoboButton_CustomerDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CustomerDetailsWindow();

            }
            public  void CustomerDetailsWindow(){
                Intent movetoCustomerDetails = new Intent(MainMenu.this, CustomerDetails.class);
                startActivity(movetoCustomerDetails);
            }

        });
    }
}