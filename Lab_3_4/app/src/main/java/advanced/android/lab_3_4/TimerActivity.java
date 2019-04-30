package advanced.android.lab_3_4;

import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;

public class TimerActivity extends AppCompatActivity {

    private TextView timerView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.timer_activity);

        String countdown = getIntent().getStringExtra("countdown");
        int time = (Integer.parseInt(countdown) + 1) * 1000;

        timerView = findViewById(R.id.countdown);

        new CountDownTimer(time, 1000) {
            public void onTick(long millisUntilFinished) {
                timerView.setText( String.valueOf(millisUntilFinished / 1000));
            }

            public void onFinish() {
                Vibrator v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                // Vibrate for 1000 milliseconds or 1 second
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    v.vibrate(VibrationEffect.createOneShot(1000, VibrationEffect.DEFAULT_AMPLITUDE));
                } else {
                    //deprecated in API 26
                    v.vibrate(1000);
                }

                MediaPlayer mediaPlayer;
                mediaPlayer = MediaPlayer.create(TimerActivity.this, R.raw.elephant);
                mediaPlayer.start();

                Toast.makeText(TimerActivity.this, "DONE",
                Toast.LENGTH_LONG).show();
                
                TimerActivity.super.onBackPressed();
            }
        }.start();
    }
}
