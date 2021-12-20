package com.example.ipt102project;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDialogFragment;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class OrderConfirmDialog extends AppCompatDialogFragment {

    String extraName = "DAFUQ";
    String OrderListAll = "Ordersample";
    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Confirm Order")
                .setMessage("Are you ready to place your order?").setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                showOrderPlaced();


            }

        });
        setCancelable(false);
        return builder.create();
    }

    private void showOrderPlaced() {
//        Toast.makeText(getApplicationContext(),
//                " save button pressed", Toast.LENGTH_SHORT).show();

        String url = "https://192.168.254.109/FoodApp/insert/InsertOrder.php";

        RequestQueue requestQueue = Volley.newRequestQueue(getActivity().getApplicationContext());
        StringRequest stringRequest = new StringRequest(Request.Method.POST,
                url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if (response.equals("success")) {
                    Toast.makeText(getActivity(), " Wassup, " +
                            " your data has been successfully saved", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getActivity(), " ERROR", Toast.LENGTH_SHORT).show();

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
                map.put("OrderId", extraName);
                map.put("OrderList", OrderListAll);
                return map;
            }
        };
        requestQueue.add(stringRequest);
    }
}



