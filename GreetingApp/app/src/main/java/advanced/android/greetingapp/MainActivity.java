package advanced.android.greetingapp;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView name = null;
    TextView instatantName = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = findViewById(R.id.name);
        instatantName = findViewById(R.id.instantUpdate);


        final Button englishBtn = (Button) findViewById(R.id.english);
        final Button svenskaBtn = (Button) findViewById(R.id.svenska);
        final Button suomeksiBtn = (Button) findViewById(R.id.suomeksi);
        final Button surpriseBtn = (Button) findViewById(R.id.surprise);

        englishBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               englishBtnPressed();
                InputMethodManager inputManager = (InputMethodManager)
                        getSystemService(Context.INPUT_METHOD_SERVICE);

                inputManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(),
                        InputMethodManager.HIDE_NOT_ALWAYS);
            }
        });

        svenskaBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               svenskaBtnPressed();
                InputMethodManager inputManager = (InputMethodManager)
                        getSystemService(Context.INPUT_METHOD_SERVICE);

                inputManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(),
                        InputMethodManager.HIDE_NOT_ALWAYS);
            }
        });

        suomeksiBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                suomeksiBtnPressed();
                InputMethodManager inputManager = (InputMethodManager)
                        getSystemService(Context.INPUT_METHOD_SERVICE);

                inputManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(),
                        InputMethodManager.HIDE_NOT_ALWAYS);
            }
        });

        surpriseBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                surpriseBtnPressed();
                InputMethodManager inputManager = (InputMethodManager)
                        getSystemService(Context.INPUT_METHOD_SERVICE);

                inputManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(),
                        InputMethodManager.HIDE_NOT_ALWAYS);
            }
        });

        TextWatcher inputTextWatcher = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                String updatedName = name.getText().toString();
                instatantName.setText(updatedName);

            }
        };
        name.addTextChangedListener(inputTextWatcher);
    }



    private void englishBtnPressed() {
        String perName = name.getText().toString();
        TextView textView = findViewById(R.id.greeting_text);

        textView.setText("Greetings " + perName + "!");

    }

    private void svenskaBtnPressed(){
        String perName = name.getText().toString();
        TextView textView = findViewById(R.id.greeting_text);
        textView.setText("Hejsan " + perName + "!");
    }

    private void suomeksiBtnPressed(){
        String perName =name.getText().toString();
        TextView textView = findViewById(R.id.greeting_text);
        textView.setText("Terve " + perName + "!");
    }

    private void surpriseBtnPressed(){
        String perName = name.getText().toString();
        TextView textView = findViewById(R.id.greeting_text);
        textView.setText("Hola " + perName + "!");
    }
}
