package advanced.android.noxmllab1;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //main layout
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(LinearLayout.VERTICAL);
        linearLayout.setGravity(Gravity.CENTER | Gravity.TOP);


        //btn layout
        LinearLayout btnLayout = new LinearLayout(this);
        btnLayout.setGravity(Gravity.CENTER | Gravity.TOP);

        //btn
        Button addBtn = new Button(this);
        addBtn.setText("Add");
        btnLayout.addView(addBtn);

        Button editBtn = new Button(this);
        editBtn.setText("Edit");
        btnLayout.addView(editBtn);

        Button removeBtn = new Button(this);
        removeBtn.setText("Remove");
        btnLayout.addView(removeBtn);

        linearLayout.addView(btnLayout);


        //editText
        final EditText editText = new EditText(this);
        editText.setGravity(Gravity.CENTER | Gravity.CENTER_HORIZONTAL);
        editText.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));

        linearLayout.addView(editText);


        //ListView
        final String[] COUNTRIES = new String[]{
                "Afghanistan", "Albania", "American Samoa", "Andorra",
                "Angola", "Anguilla", "Antarctica", "Antigua and Barbuda", "Argentina",
                "Armenia", "Aruba", "Australia", "Austria", "Azerbaijan",
                "Finland", "Ukraine", "Sweden"
        };

        final ArrayList<String> countries = new ArrayList<>();

        for (int i=0; i < COUNTRIES.length ; i++) {
            String name = COUNTRIES[i];
            countries.add(name);
        }

        final ListView myListView = new ListView(this);
        final ArrayAdapter<String> aa;
        aa = new ArrayAdapter<>(this,android.R.layout.simple_expandable_list_item_1,
                countries);
        myListView.setAdapter(aa);


        linearLayout.addView(myListView);
        setContentView(linearLayout);


        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String editTextString = editText.getText().toString();
                countries.add(editTextString);
                myListView.setAdapter(aa);
                Collections.reverse(countries);

                editText.setText(null);
            }
        });

        removeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = editText.getText().toString();
                editText.setText(null);
                for (int i=0; i < countries.size(); i++){
                    String name = countries.get(i);
                    if (name.contains(text)) {
                        countries.remove(i);
                    }
                }
                myListView.setAdapter(aa);
            }
        });
    }


}
