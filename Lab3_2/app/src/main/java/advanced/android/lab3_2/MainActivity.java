package advanced.android.lab3_2;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    public Button btnOpenMap, btnMakeCall, btnGo;
    private EditText editText;
    private Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        btnOpenMap = findViewById(R.id.btn_open_map);
        btnMakeCall = findViewById(R.id.btn_make_call);
        btnGo = findViewById(R.id.btn_go);
        editText = findViewById(R.id.search_edit_text);
//        editText.setText("www.oamk.fi/en");

        btnOpenMap.setOnClickListener(this);
        btnMakeCall.setOnClickListener(this);
        btnGo.setOnClickListener(this);
        addListenerOnSpinnerItemSelection();

    }

    private void addListenerOnSpinnerItemSelection() {
        spinner = findViewById(R.id.protocol_spinner);
        spinner.setOnItemSelectedListener(new CustomOnItemSelectedListener());
    }


    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.btn_open_map:
                Uri location = Uri.parse("geo:64.9995232,25.5116093?q=Kotkantie 1, Oulu, 90130"); // z param is zoom level
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, location);
                startActivity(mapIntent);
                break;

            case R.id.btn_make_call:
                Uri number = Uri.parse("tel:020 611 0200");
                Intent callIntent = new Intent(Intent.ACTION_DIAL, number);
                startActivity(callIntent);
                break;

            case R.id.btn_go:
                String protocol = String.valueOf(spinner.getSelectedItem());
                editText = findViewById(R.id.search_edit_text);
                String website;
                if (editText.getText().toString().equals("")) {
                    website = "www.oamk.fi/en";
                } else {
                    website = editText.getText().toString();
                }
                Uri webpage = Uri.parse(protocol + website);
                Intent webIntent = new Intent(Intent.ACTION_VIEW, webpage);
                startActivity(webIntent);
                break;
        }

    }

}
