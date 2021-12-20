package com.example.ipt102project;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.ornach.nobobutton.NoboButton;
import com.shawnlin.numberpicker.NumberPicker;

import java.util.Set;

public class SetOrders extends AppCompatActivity {

    NoboButton NoboButton_AddChocoMalt, NoboButton_AddJavaFrappe, NoboButton_AddGreenApple, NoboButton_AddTaro, NoboButton_ReviewOrder;
    NumberPicker number_picker_ChocoMaltValue, number_picker_JavaChipValue, number_picker_GreenAppleValue, number_picker_TaroValue;

    TextView textView_ChocoMaltPrice, textView_JavaChipPrice, textView_GreenApplePrice, textView_TaroPrice;
    CheckBox checkBox_ChocoMaltPearls, checkBox_JavaChipPearls, checkBox_GreenApplePearls, checkBox_TaroPearls;

    //STRING FOR ORDERLIST DATABASE
    String orderChocomalt = "";
    String orderJava ="";
    String orderGreenApple = "";
    String orderTaro = "";
    ImageView imageView_OnlyMilktea;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_orders);
        getSupportActionBar().hide();



        imageView_OnlyMilktea = findViewById(R.id.imageView_OnlyMilktea);

        NoboButton_AddChocoMalt = findViewById(R.id.NoboButton_AddChocoMalt);
        NoboButton_AddJavaFrappe = findViewById(R.id.NoboButton_AddJavaFrappe);
        NoboButton_AddGreenApple = findViewById(R.id.NoboButton_AddGreenApple);
        NoboButton_AddTaro = findViewById(R.id.NoboButton_AddTaro);
        NoboButton_ReviewOrder = findViewById(R.id.NoboButton_ReviewOrder);

        number_picker_ChocoMaltValue = findViewById(R.id.number_picker_ChocoMaltValue);
        number_picker_JavaChipValue = findViewById(R.id.number_picker_JavaChipValue);
        number_picker_GreenAppleValue = findViewById(R.id.number_picker_GreenAppleValue);
        number_picker_TaroValue = findViewById(R.id.number_picker_TaroValue);

        textView_ChocoMaltPrice = findViewById(R.id.textView_ChocoMaltPrice);
        textView_JavaChipPrice = findViewById(R.id.textView_JavaChipPrice);
        textView_GreenApplePrice = findViewById(R.id.textView_GreenApplePrice);
        textView_TaroPrice = findViewById(R.id.textView_TaroPrice);


        checkBox_ChocoMaltPearls = findViewById(R.id.checkBox_ChocoMaltPearls);
        checkBox_JavaChipPearls = findViewById(R.id.checkBox_JavaChipPearls);
        checkBox_GreenApplePearls = findViewById(R.id.checkBox_GreenApplePearls);
        checkBox_TaroPearls = findViewById(R.id.checkBox_TaroPearls);

        NoboButton_AddChocoMalt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (NoboButton_AddChocoMalt.getText().equalsIgnoreCase("Add")) {
                    NoboButton_AddChocoMalt.setText("Remove");
                    NoboButton_AddChocoMalt.setBackgroundColor(Color.RED);

                    number_picker_ChocoMaltValue.setVisibility(View.VISIBLE);

                    checkBox_ChocoMaltPearls.setVisibility(View.VISIBLE);

                } else {
                    NoboButton_AddChocoMalt.setText("Add");
                    NoboButton_AddChocoMalt.setBackgroundColor(Color.rgb(0, 174, 240));

                    number_picker_ChocoMaltValue.setValue(0);
                    number_picker_ChocoMaltValue.setVisibility(View.INVISIBLE);

                    checkBox_ChocoMaltPearls.setVisibility(View.INVISIBLE);
                }
            }
        });
        NoboButton_AddJavaFrappe.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                if (NoboButton_AddJavaFrappe.getText().toString().equalsIgnoreCase("Add")) {
                    NoboButton_AddJavaFrappe.setText("Remove");
                    NoboButton_AddJavaFrappe.setBackgroundColor(Color.RED);

                    number_picker_JavaChipValue.setVisibility(View.VISIBLE);

                    checkBox_JavaChipPearls.setVisibility(View.VISIBLE);

                } else {
                    NoboButton_AddJavaFrappe.setText("Add");
                    NoboButton_AddJavaFrappe.setBackgroundColor(Color.rgb(0, 174, 240));

                    number_picker_JavaChipValue.setValue(0);
                    number_picker_JavaChipValue.setVisibility(View.INVISIBLE);

                    checkBox_JavaChipPearls.setVisibility(View.INVISIBLE);
                }
            }
        });
        NoboButton_AddGreenApple.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (NoboButton_AddGreenApple.getText().toString().equalsIgnoreCase("Add")) {
                    NoboButton_AddGreenApple.setText("Remove");
                    NoboButton_AddGreenApple.setBackgroundColor(Color.RED);

                    number_picker_GreenAppleValue.setVisibility(View.VISIBLE);

                    checkBox_GreenApplePearls.setVisibility(View.VISIBLE);
                } else {
                    NoboButton_AddGreenApple.setText("Add");
                    NoboButton_AddGreenApple.setBackgroundColor(Color.rgb(0, 174, 240));

                    number_picker_GreenAppleValue.setValue(0);
                    number_picker_GreenAppleValue.setVisibility(View.INVISIBLE);

                    checkBox_GreenApplePearls.setVisibility(View.INVISIBLE);
                }
            }
        });
        NoboButton_AddTaro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (NoboButton_AddTaro.getText().toString().equalsIgnoreCase("Add")) {
                    NoboButton_AddTaro.setText("Remove");
                    NoboButton_AddTaro.setBackgroundColor(Color.RED);

                    number_picker_TaroValue.setVisibility(View.VISIBLE);

                    checkBox_TaroPearls.setVisibility(View.VISIBLE);
                } else {
                    NoboButton_AddTaro.setText("Add");
                    NoboButton_AddTaro.setBackgroundColor(Color.rgb(0, 174, 240));

                    number_picker_TaroValue.setValue(0);
                    number_picker_TaroValue.setVisibility(View.INVISIBLE);

                    checkBox_TaroPearls.setVisibility(View.INVISIBLE);
                }
            }
        });


        NoboButton_ReviewOrder.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View view) {

                Bundle bundle = new Bundle();

                int getChocoMaltQty = number_picker_ChocoMaltValue.getValue();
                double ChocoMaltPrice = Double.parseDouble(textView_ChocoMaltPrice.getText().toString());

                double ChocoMaltTotal = 0;


                if (NoboButton_AddChocoMalt.getText().toString().equalsIgnoreCase("Remove")) {
                    if (checkBox_ChocoMaltPearls.isChecked() && NoboButton_AddChocoMalt.getText().toString().equalsIgnoreCase("Remove")) {
                        ChocoMaltTotal = (getChocoMaltQty * ChocoMaltPrice) + 15;
                        orderChocomalt= "ChocomaltPEARL - " + getChocoMaltQty +  "\n";
                    } else {
                        ChocoMaltTotal = getChocoMaltQty * ChocoMaltPrice;
                        orderChocomalt= "ChocomaltNOPRL - " + getChocoMaltQty +  "\n";
                    }

                }

                bundle.putString("ChocoMaltAdded", String.valueOf(R.id.NoboButton_AddChocoMalt));
                bundle.putInt("img_ChocoMalt", R.id.imageView_ChocoMalt);
                bundle.putDouble("ChocoMaltTotal", ChocoMaltTotal);
                bundle.putInt("ChocoMaltQty", getChocoMaltQty);
                bundle.putDouble("ChocoMaltPrice", ChocoMaltPrice);
                bundle.putBoolean("ChocoMaltChecked", checkBox_ChocoMaltPearls.isChecked());

                int getJavaChipQty = number_picker_JavaChipValue.getValue();
                double JavaChipPrice = Double.parseDouble(textView_JavaChipPrice.getText().toString());

                double JavaChipTotal = 0;

                if (NoboButton_AddJavaFrappe.getText().toString().equalsIgnoreCase("Remove")) {
                    if (checkBox_JavaChipPearls.isChecked() && NoboButton_AddJavaFrappe.getText().toString().equalsIgnoreCase("Remove")) {
                        JavaChipTotal = (getJavaChipQty * JavaChipPrice) + 15;
                        orderJava= "JavaPEARL - " + getJavaChipQty +  "\n";
                    } else {
                        JavaChipTotal = getJavaChipQty * JavaChipPrice;
                        orderJava= "JavaNOPRL - " + getJavaChipQty +  "\n";
                    }
                }

                bundle.putString("JavaChipAdded", String.valueOf(R.id.NoboButton_AddJavaFrappe));
                bundle.putInt("img_JavaChip", R.id.imageView_JavaChip);
                bundle.putDouble("JavaChipTotal", JavaChipTotal);
                bundle.putInt("JavaChipQty", getJavaChipQty);
                bundle.putDouble("JavaChipPrice", JavaChipPrice);
                bundle.putBoolean("JavaChipChecked", checkBox_JavaChipPearls.isChecked());


                int getGreenAppleQty = number_picker_GreenAppleValue.getValue();
                double GreenApplePrice = Double.parseDouble(textView_GreenApplePrice.getText().toString());

                double GreenAppleTotal = 0;

                if (NoboButton_AddGreenApple.getText().toString().equalsIgnoreCase("Remove")) {
                    if (checkBox_GreenApplePearls.isChecked() && NoboButton_AddGreenApple.getText().toString().equalsIgnoreCase("Remove")) {
                        GreenAppleTotal = (getGreenAppleQty * GreenApplePrice) + 15;
                        orderGreenApple = "GreenApplePEARL - " +getGreenAppleQty  + "\n";

                    } else {
                        GreenAppleTotal = getGreenAppleQty * GreenApplePrice;
                        orderGreenApple = "GreenAppleNOPRL - " +getGreenAppleQty  + "\n";
                    }
                }

                bundle.putString("GreenAppleAdded", String.valueOf(R.id.NoboButton_AddGreenApple));
                bundle.putInt("img_GreenApple", R.id.imageView_GreenApple);
                bundle.putDouble("GreenAppleTotal", GreenAppleTotal);
                bundle.putInt("GreenAppleQty", getGreenAppleQty);
                bundle.putDouble("GreenApplePrice", GreenApplePrice);
                bundle.putBoolean("GreenAppleChecked", checkBox_GreenApplePearls.isChecked());

                int getTaroQty = number_picker_TaroValue.getValue();
                double TaroPrice = Double.parseDouble(textView_TaroPrice.getText().toString());

                double TaroTotal = 0;

                if (NoboButton_AddTaro.getText().toString().equalsIgnoreCase("Remove")) {
                    if (checkBox_TaroPearls.isChecked() && NoboButton_AddTaro.getText().toString().equalsIgnoreCase("Remove")) {
                        TaroTotal = (getTaroQty * GreenApplePrice) + 15;
                        orderTaro = "TaroPEARL" + getTaroQty +"\n";
                    } else {
                        TaroTotal = getTaroQty * TaroPrice;
                        orderTaro = "TaroNOPRL" + getTaroQty + "\n";
                    }
                }

                if (NoboButton_AddChocoMalt.getText().equalsIgnoreCase("Add") &&
                        NoboButton_AddJavaFrappe.getText().equalsIgnoreCase("Add") &&
                        NoboButton_AddGreenApple.getText().equalsIgnoreCase("Add") &&
                        NoboButton_AddTaro.getText().equalsIgnoreCase("Add")) {

                    recreate();
                    NoOrdersSelectedDialog noOrdersSelectedDialog = new NoOrdersSelectedDialog();
                    noOrdersSelectedDialog.show(getSupportFragmentManager(), "noOrdersSelectedDialog");

                }

                bundle.putString("TaroAdded", String.valueOf(R.id.NoboButton_AddTaro));
                bundle.putInt("img_Taro", R.id.imageView_Taro);
                bundle.putDouble("TaroTotal", TaroTotal);
                bundle.putInt("TaroQty", getTaroQty);
                bundle.putDouble("TaroPrice", TaroPrice);
                bundle.putBoolean("TaroChecked", checkBox_TaroPearls.isChecked());

                String OrderListAll = orderChocomalt + orderJava  + orderTaro + orderGreenApple;

                bundle.putString("OrderListAll",OrderListAll);

                Intent intent = new Intent(getApplicationContext(), ListOrders.class);
                intent.putExtras(bundle);

                if (NoboButton_AddChocoMalt.getText().equalsIgnoreCase("Add") &&
                        NoboButton_AddJavaFrappe.getText().equalsIgnoreCase("Add") &&
                        NoboButton_AddGreenApple.getText().equalsIgnoreCase("Add") &&
                        NoboButton_AddTaro.getText().equalsIgnoreCase("Add")) {
                    recreate();
                    NoOrdersSelectedDialog noOrdersSelectedDialog = new NoOrdersSelectedDialog();
                    noOrdersSelectedDialog.show(getSupportFragmentManager(), "noOrdersSelectedDialog");

                }else{
                    startActivity(intent);
                }


            }
        });

        imageView_OnlyMilktea.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent movetoMainMenu = new Intent(getApplicationContext(), MainMenu.class);
                startActivity(movetoMainMenu);
            }
        });

    }
}