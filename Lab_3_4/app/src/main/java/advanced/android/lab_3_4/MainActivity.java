package advanced.android.lab_3_4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView timerView;
    private Button btnStart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        timerView =findViewById(R.id.timer_number);
        btnStart = findViewById(R.id.btnStart);

        btnStart.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        if(v.getId() == R.id.btnStart){
            String time = timerView.getText().toString();

            if (time.length() > 0 && !time.equals("0")) {
                Intent intent = new Intent(MainActivity.this, TimerActivity.class);
                intent.putExtra("countdown", time);
                startActivity(intent);
            } else {
                Toast.makeText(MainActivity.this, "Timer cannot be 0 seconds!",
                    Toast.LENGTH_LONG).show();
            }

        }
    }
}
