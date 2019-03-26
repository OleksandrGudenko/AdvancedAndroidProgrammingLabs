package advanced.android.lab3_2;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class MainActivity extends AppCompatActivity {

    public Button btnOpenMap, btnMakeCall, btnGo;
    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnOpenMap = findViewById(R.id.btn_open_map);
        btnMakeCall = findViewById(R.id.btn_make_call);
        btnGo = findViewById(R.id.btn_go);
        editText = findViewById(R.id.search_edit_text);
        editText.setText("https://www.oamk.fi/en");

        btnOpenMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Uri location = Uri.parse("geo:64.9995232,25.5116093?q=Kotkantie 1, Oulu, 90130"); // z param is zoom level
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, location);
                startActivity(mapIntent);

            }
        });

        btnMakeCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri number = Uri.parse("tel:020 611 0200");
                Intent callIntent = new Intent(Intent.ACTION_DIAL, number);
                startActivity(callIntent);
            }
        });

        btnGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText = findViewById(R.id.search_edit_text);
                String website = editText.getText().toString();
                Uri webpage = Uri.parse(website);
                Intent webIntent = new Intent(Intent.ACTION_VIEW, webpage);
                startActivity(webIntent);
            }
        });
    }


}
