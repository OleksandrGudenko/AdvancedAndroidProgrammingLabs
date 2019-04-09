package advanced.android.lab4_1_volley;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class StockMonitorV2 extends AppCompatActivity {

    private String[] companies = { "AAPL", "GOOGL", "FB", "NOK" };
    public EditText stockName, stockId;
    private RequestQueue mQueue;
    private String fullName;
    private String price;
    private JSONObject companyName;
    public ListView listView;
    public ArrayAdapter<String> aa;
    public ArrayList<String> stockToDisplay;
    Button btnAdd;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.stock_monitor_main_v2);

        mQueue = VolleySingleton.getInstance(this).getmRequestQueue();

        stockName = findViewById(R.id.edit_text_stock_name);
        stockId = findViewById(R.id.edit_text_stock_id);
        btnAdd = (findViewById(R.id.btnAdd));

        stockToDisplay = new ArrayList<>();

        aa = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, stockToDisplay);


        getMyStock();

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String companyNickName = stockName.getText().toString();
                String companyStockId = stockId.getText().toString();

                addNewStock(companyNickName, companyStockId);

            }
        });

    }

    private void getMyStock(){

        for (int i = 0; i < companies.length; i++) {
            final String company = companies[i];
            String url = "https://financialmodelingprep.com/api/company/price/"+ company +"?datatype=json";

            JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {

                @Override
                public void onResponse(JSONObject response) {

                    if (company.equals("NOK")){
                        fullName = "Nokia";
                    }
                    if (company.equals("AAPL")) {
                        fullName = "Apple";
                    }
                    if (company.equals("FB")){
                        fullName = "Facebook";
                    }
                    if (company.equals("GOOGL")) {
                        fullName = "Google";
                    }

                    try {
                        companyName = response.getJSONObject(company);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                    try {
                        price = String.valueOf(companyName.get("price"));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                    stockToDisplay.add(fullName + ": " + price + " USD");

                    if(stockToDisplay.size() > 0){
                        populateList();
                    }


                    Log.d("getMyStock", fullName + ": " + price + " USD");
                }
            }, new Response.ErrorListener() {

                @Override
                public void onErrorResponse(VolleyError error) {
                    error.printStackTrace();
                }
            });

            mQueue.add(jsonObjectRequest);

        }

    }

    private void populateList() {
        listView = findViewById(R.id.list_view);

        Log.d("getMyStock", "stockToDisplay size = "+ stockToDisplay.size());
        listView.setAdapter(aa);

    }

    private void addNewStock(String name, final String id){

        fullName = name;

        String url = "https://financialmodelingprep.com/api/company/price/"+ id +"?datatype=json";

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {

            @Override
            public void onResponse(JSONObject response) {


                try {
                    companyName = response.getJSONObject(id);
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                try {
                    price = String.valueOf(companyName.get("price"));
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                stockToDisplay.add(fullName + ": " + price + " USD");

                if(stockToDisplay.size() > 0){
                    populateList();
                }


                Log.d("getMyStock", fullName + ": " + price + " USD");
            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });

        mQueue.add(jsonObjectRequest);

    }
}
