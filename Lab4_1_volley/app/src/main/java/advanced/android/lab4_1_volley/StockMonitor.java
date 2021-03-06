package advanced.android.lab4_1_volley;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;


public class StockMonitor extends AppCompatActivity implements View.OnClickListener {

    private String[] companies = { "AAPL", "GOOGL", "FB", "NOK" };
    private RequestQueue mQueue;
    private String fullName;
    private String price;
    private JSONObject companyName;
    public ListView listView;
    public ArrayAdapter<String> aa;
    public ArrayList<String> stockToDisplay;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.stock_monitor_main);

        mQueue = VolleySingleton.getInstance(this).getmRequestQueue();

        stockToDisplay = new ArrayList<>();

        aa = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, stockToDisplay);


        getMyStock();
    }

    @Override
    public void onClick(View v) {
            if (v.getId() == R.id.btnStockMonitorV2) {
                Intent intent = new Intent(StockMonitor.this, StockMonitorV2.class);
                startActivity(intent);
            }
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

}
