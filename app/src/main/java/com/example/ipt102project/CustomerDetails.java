package com.example.ipt102project;

import androidx.annotation.ArrayRes;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.AdapterView;
    import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.ornach.nobobutton.NoboButton;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CustomerDetails extends AppCompatActivity {

    NoboButton NoboButton_AddressOK,NoboButton_AddressCancel;
    EditText etFirstName1,etLastName,etStreetAddress,etContactNumber,etPaymentCCGC;
    Spinner spnrBaranggay, spnrPayment;
    String spnrPaymentvalue;
    String FirstName, LastName, StreetAddress, ContactNo, Payment, PaymentMethod, Baranggay;
    TextView txtPayment;

    private ArrayAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_details);

        NukeSSLCerts.nuke();

        txtPayment = findViewById(R.id.txtPayment);
        NoboButton_AddressCancel = findViewById(R.id.NoboButton_AddressCancel);
        NoboButton_AddressOK = findViewById(R.id.NoboButton_AddressOK);
        etFirstName1 = (EditText) findViewById(R.id.etFirstName);
        etLastName = (EditText)findViewById(R.id.etLastName);
        etStreetAddress = (EditText)findViewById(R.id.etStreetAddress);
        etContactNumber = (EditText)findViewById(R.id.etContactNumber);
        etPaymentCCGC= (EditText)findViewById(R.id.etPaymentCCGC);
        spnrPayment =  (Spinner) findViewById(R.id.spnrPayment);
        spnrBaranggay=  (Spinner) findViewById(R.id.spnrBaranggay);




   /*     String FirstName = "ff";
        String LastName = "ddd";
        String StreetAddress = "dfsdsf";
        String ContactNo ="343";*/


/*        spnrPayment.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                spnrPaymentvalue = spnrPayment.getSelectedItem().toString();

                if ((spnrPaymentvalue.equals("Gcash")) || (spnrPaymentvalue.equals("Credit Card"))) {
                    etPaymentCCGC.setVisibility(View.VISIBLE);
                }
            }
        });*/

        NoboButton_AddressOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PaymentMethod = etPaymentCCGC.getText().toString();
                FirstName = etFirstName1.getText().toString();
                LastName = etLastName.getText().toString();
                StreetAddress = etStreetAddress.getText().toString();
                ContactNo = etContactNumber.getText().toString();
                Payment = spnrPayment.getSelectedItem().toString() + PaymentMethod;
                Baranggay = spnrBaranggay.getSelectedItem().toString();


                DeliverySaved();
                CreateOrderWindow();
            }

                private void CreateOrderWindow() {
                    Intent movetoSetorders = new Intent(CustomerDetails.this, SetOrders.class);
                    startActivity(movetoSetorders);

                }





/*                if (etFirstName.getText().equals("")) {
                    Toast.makeText(getApplicationContext(), "plz enter your name ", Toast.LENGTH_SHORT).show();
                    return;
                }*/



                private void DeliverySaved() {
                 Toast.makeText(getApplicationContext(),
               " ok button pressed", Toast.LENGTH_SHORT).show();

                    String url = "https://192.168.254.112/FoodApp/insert/InsertDeliveryInfo.php";

                    RequestQueue requestQueue = Volley.newRequestQueue(CustomerDetails.this);
                    StringRequest stringRequest = new StringRequest(Request.Method.POST,
                            url, new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            if (response.equals("DONE")) {
                                Toast.makeText(getApplicationContext(), " DAMN , " +
                                        " your delivery info has been successfully saved", Toast.LENGTH_SHORT).show();
                            } else {
                                Toast.makeText(getApplicationContext(), " tf ERROR", Toast.LENGTH_SHORT).show();

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
                            map.put("FirstName", FirstName);
                            map.put("LastName", LastName);
                            map.put("Barangay", Baranggay);
                            map.put("StreetAddress", StreetAddress);
                            map.put("ContactNo", ContactNo);
                            map.put("PaymentMethod", Payment);
                            return map;
                        }
                    };

                    requestQueue.add(stringRequest);
                }

        });
    }

}