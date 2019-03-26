package advanced.android.buttongame;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    int buttonPressed;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        final Button gameButton = new Button(this);
        gameButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                    buttonPressed = buttonPressed + 1;
                    gameButton.setText("You have pressed button "+ buttonPressed + " times" );
                }


        });
        gameButton.setText("Hello im code generated button");
        setContentView(gameButton);

    }

}
