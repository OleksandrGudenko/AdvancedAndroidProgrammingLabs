package advanced.android.lab4_1_volley;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText link;
    TextView textViewMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        link = findViewById(R.id.edit_text_link);
        textViewMain = findViewById(R.id.textViewMain);

    }


    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnGo) {
            // Instantiate the RequestQueue.
            RequestQueue queue = Volley.newRequestQueue(MainActivity.this);
            String url = link.getText().toString();
            if (url.equals("")) {
                url = "https://google.com";
            }

            // Request a string response from the provided URL.
            StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            // Display the first 500 characters of the response string.
                            textViewMain.setText("Response is: " + response.substring(0, 5000));
                        }
                    }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    textViewMain.setText("That didn't work!");
                }
            });

            // Add the request to the RequestQueue.
            queue.add(stringRequest);
        }

        if (v.getId() == R.id.btnStockMonitor) {

            Intent intent = new Intent(MainActivity.this, StockMonitor.class);
            startActivity(intent);

        }
    }
}
