package com.example.ipt102project;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.text.GetChars;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.ornach.nobobutton.NoboButton;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import com.shawnlin.numberpicker.NumberPicker;

import org.w3c.dom.Text;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class ListOrders extends AppCompatActivity {

    TextView textView_TotalValue;
    NoboButton NoboButton_CreateOrder;
    String OrderIdSub;


    String OrderListAll;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getSupportActionBar().hide();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_orders);
        NoboButton_CreateOrder = findViewById(R.id.NoboButton_CreateOrder);
        textView_TotalValue = findViewById(R.id.textView_Totaltext);

        GetOrderId();
//        Intent intent = getIntent();


        NukeSSLCerts.nuke();
        String ChocoMaltAdded, JavaChipAdded, GreenAppleAdded, TaroAdded;
        double ChocoMaltTotal, JavaChipTotal, GreenAppleTotal, TaroTotal;
        boolean ChocoMaltChecked, JavaChipChecked, GreenAppleChecked, TaroChecked;
        int ChocoMaltQty, JavaChipQty, GreenAppleQty, TaroQty;


        NoboButton_CreateOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                showOrderPlaced();
                Toast.makeText(getApplicationContext(), "PRESSED", Toast.LENGTH_SHORT).show();

            }

            private void showOrderPlaced() {
//        Toast.makeText(getApplicationContext(),
//                " save button pressed", Toast.LENGTH_SHORT).show();

                String url = "https://192.168.254.112/FoodApp/insert/InsertOrder.php";

                RequestQueue requestQueue = Volley.newRequestQueue(ListOrders.this);
                StringRequest stringRequest = new StringRequest(Request.Method.POST,
                        url, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        if (response.equals("Order")) {
                            Toast.makeText(getApplicationContext(), " Wassup, " +
                                    " your data has been successfully saved", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(getApplicationContext(), " ERROR", Toast.LENGTH_SHORT).show();

                        }
                    }
                },
                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                            }
                        }) {
                    @Nullable
                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError {
                        HashMap<String, String> map = new HashMap<>();
                        map.put("OrderId", OrderIdSub);
                        map.put("OrderList", OrderListAll);
                        return map;
                    }
                };

                requestQueue.add(stringRequest);
            }


        });
        OrderListAll = getIntent().getExtras().getString("OrderListAll");

//        int ChocoMaltImg;
        ChocoMaltAdded = getIntent().getExtras().getString("ChocoMaltAdded");
        ChocoMaltTotal = getIntent().getExtras().getDouble("ChocoMaltTotal");
        ChocoMaltChecked = getIntent().getExtras().getBoolean("ChocoMaltChecked");
        ChocoMaltQty = getIntent().getExtras().getInt("ChocoMaltQty");

        JavaChipAdded = getIntent().getExtras().getString("JavaChipAdded");
        JavaChipTotal = getIntent().getExtras().getDouble("JavaChipTotal");
        JavaChipChecked = getIntent().getExtras().getBoolean("JavaChipChecked");
        JavaChipQty = getIntent().getExtras().getInt("JavaChipQty");

        GreenAppleAdded = getIntent().getExtras().getString("GreenAppleAdded");
        GreenAppleTotal = getIntent().getExtras().getDouble("GreenAppleTotal");
        GreenAppleChecked = getIntent().getExtras().getBoolean("GreenAppleChecked");
        GreenAppleQty = getIntent().getExtras().getInt("GreenAppleQty");

        TaroAdded = getIntent().getExtras().getString("TaroAdded");
        TaroTotal = getIntent().getExtras().getDouble("TaroTotal");
        TaroChecked = getIntent().getExtras().getBoolean("TaroChecked");
        TaroQty = getIntent().getExtras().getInt("TaroQty");

//        ChocoMaltImg = getIntent().getExtras().getInt("img_ChocoMalt");

//        ListOrdersData(String FoodMenu_foodname, int imgID, double FoodMenu_foodprice, double SubtotalValue, boolean itemHasPearls, int quantity);


            ListOrdersData[] myListData = new ListOrdersData[]{
                    new ListOrdersData(
                            "Chocomalt Cream Puff",
                            50.00,
                            ChocoMaltTotal,
                            ChocoMaltChecked, ChocoMaltQty),
                    new ListOrdersData(
                            "Java Chip Frappe",
                            60.00,
                            JavaChipTotal,
                            JavaChipChecked, JavaChipQty),
                    new ListOrdersData(
                            "Green Apple Fruit Tea",
                            40.00,
                            GreenAppleTotal,
                            GreenAppleChecked, GreenAppleQty),
                    new ListOrdersData(
                            "Taro Rock Salt Cheese",
                            30.00,
                            TaroTotal,
                            TaroChecked, TaroQty)
            };

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.RecyclerView_FoodMenu);
        ListOrdersAdapter adapter = new ListOrdersAdapter(myListData);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        textView_TotalValue = findViewById(R.id.textView_TotalValue);

        double Ordertotal = ChocoMaltTotal + JavaChipTotal + GreenAppleTotal + TaroTotal;

        textView_TotalValue.setText(Double.toString(Ordertotal));


    }

    private void GetOrderId() {
        String url = "https://192.168.254.112/FoodApp/insert/GetLastOrder.php";
        Toast.makeText(getApplicationContext(),
                " GetOrder", Toast.LENGTH_SHORT).show();

        RequestQueue requestQueue2 = Volley.newRequestQueue(ListOrders.this);
        StringRequest stringRequest2 = new StringRequest(Request.Method.GET,
                url, new Response.Listener<String>() {
            @Override
            public void onResponse(String responses) {
                OrderIdSub = (responses.toString());
                /*   textView_TotalValue.setText(responses)*/;
            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                // TODO: Handle error

            }

        });
        requestQueue2.add(stringRequest2);
    }}

// TODO : SEND INTENT DATA TO RECYCLERVIEW