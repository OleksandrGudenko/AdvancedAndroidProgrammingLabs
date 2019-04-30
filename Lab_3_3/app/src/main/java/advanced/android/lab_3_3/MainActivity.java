package advanced.android.lab_3_3;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView bearImage, wolfImage, elephantImage, lambImage,
                      owlImage, finchImage, wrenImage, bullfinchImage;
    MediaPlayer mediaPlayer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mammals);

        mammalsOnClick();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.mammals_item_menu) {
            setContentView(R.layout.mammals);
            mammalsOnClick();
        } else if (item.getItemId() == R.id.birds_item_menu) {
            setContentView(R.layout.birds);

            birdsOnClick();
        }
        return true;
    }


    void mammalsOnClick() {

        bearImage = findViewById(R.id.image_bear);
        wolfImage = findViewById(R.id.image_wolf);
        elephantImage = findViewById(R.id.image_elephant);
        lambImage = findViewById(R.id.image_lamb);

        bearImage.setOnClickListener(this);
        wolfImage.setOnClickListener(this);
        elephantImage.setOnClickListener(this);
        lambImage.setOnClickListener(this);
    }

    void birdsOnClick() {

        owlImage = findViewById(R.id.image_eagle_owl);
        finchImage = findViewById(R.id.image_finch);
        wrenImage = findViewById(R.id.image_wren);
        bullfinchImage = findViewById(R.id.image_bullfinch);

        owlImage.setOnClickListener(this);
        finchImage.setOnClickListener(this);
        wrenImage.setOnClickListener(this);
        bullfinchImage.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.image_bear:
                Toast.makeText(MainActivity.this,
                        "Bear clicked",
                        Toast.LENGTH_SHORT).show();

                mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.bear);
                mediaPlayer.start();
                break;

            case R.id.image_wolf:
                Toast.makeText(MainActivity.this, "Wolf clicked", Toast.LENGTH_SHORT).show();
                mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.wolf);
                mediaPlayer.start();
                break;

            case R.id.image_elephant:
                Toast.makeText(MainActivity.this,
                        "Elephant clicked",
                        Toast.LENGTH_SHORT).show();
                mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.elephant);
                mediaPlayer.start();
                break;

            case R.id.image_lamb:
                Toast.makeText(MainActivity.this,
                        "Lamb clicked",
                        Toast.LENGTH_SHORT).show();
                mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.lamb);
                mediaPlayer.start();
                break;

            case R.id.image_eagle_owl:
                Toast.makeText(MainActivity.this,
                        "Eagle Owl clicked",
                        Toast.LENGTH_SHORT).show();
                mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.huuhkaja_norther_eagle_owl);
                mediaPlayer.start();
                break;

            case R.id.image_finch:
                Toast.makeText(MainActivity.this,
                        "Finch clicked",
                        Toast.LENGTH_SHORT).show();
                mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.peippo_chaffinch);
                mediaPlayer.start();
                break;

            case R.id.image_wren:
                Toast.makeText(MainActivity.this,
                        "Wren clicked",
                        Toast.LENGTH_SHORT).show();
                mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.peukaloinen_wren);
                mediaPlayer.start();
                break;

            case R.id.image_bullfinch:
                Toast.makeText(MainActivity.this,
                        "Bullfinch clicked",
                        Toast.LENGTH_SHORT).show();
                mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.punatulkku_northern_bullfinch);
                mediaPlayer.start();
                break;
        }
    }
}
