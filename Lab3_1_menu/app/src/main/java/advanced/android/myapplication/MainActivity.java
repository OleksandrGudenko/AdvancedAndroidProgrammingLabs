package advanced.android.myapplication;

import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private ConstraintLayout cl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cl  = findViewById(R.id.main_layout);
        cl.setBackgroundColor(getResources().getColor(R.color.red));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        TextView textView = findViewById(R.id.center_text);
        ConstraintLayout constraintLayout = findViewById(R.id.main_layout);

        if (item.getItemId() == R.id.red_item_menu) {
            Log.d(TAG, "Changing background color to RED");
            textView.setText(getString(R.string.red));
            constraintLayout.setBackgroundColor(getResources().getColor(R.color.red));
        } else if (item.getItemId() == R.id.green_item_menu) {
            Log.d(TAG, "Changing background color to GREEN");
            textView.setText(getString(R.string.green));
            constraintLayout.setBackgroundColor(getResources().getColor(R.color.green));
        } else if (item.getItemId() == R.id.blue_item_menu) {
            Log.d(TAG, "Changing background color to BLUE");
            textView.setText(getString(R.string.blue));
            constraintLayout.setBackgroundColor(getResources().getColor(R.color.blue));
        } else if (item.getItemId() == R.id.yellow_item_menu) {
            Log.d(TAG, "Changing background color to red");
            textView.setText(getString(R.string.yellow));
            constraintLayout.setBackgroundColor(getResources().getColor(R.color.yellow));
        }
        return true;
    }
}
