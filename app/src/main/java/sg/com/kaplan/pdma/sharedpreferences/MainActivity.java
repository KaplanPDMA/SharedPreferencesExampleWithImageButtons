package sg.com.kaplan.pdma.sharedpreferences;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int numClicks;
    TextView textViewNumClicks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences sharedPref = getPreferences(Context.MODE_PRIVATE);
        numClicks = sharedPref.getInt("numclicks", 0);
        textViewNumClicks = (TextView) findViewById(R.id.textViewNumClicks);
        textViewNumClicks.setText("" + numClicks);
    }

    @Override
    protected void onPause() {
        super.onPause();
        //save the value to SharedPreferences here
        SharedPreferences sharedPref = getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putInt("numclicks", numClicks);
        editor.commit();
    }

    //onClick method
    public void watchClicked(View v) {

        numClicks++;
        textViewNumClicks.setText("" + numClicks);

        String message = "";
        switch (v.getId()) {
            case R.id.imageButton:
                message = "Samsung Gear S2";
                break;
            case R.id.imageButton2:
                message = "Huawei";
                break;
            case R.id.imageButton3:
                message = "Moto360";
                break;
            case R.id.imageButton4:
                message = "Asus Zenwatch2";
                break;
        }
        Toast.makeText(getApplicationContext(),
                message + " clicked", Toast.LENGTH_SHORT).show();
    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.menu_main, menu);
//        return true;
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        // Handle action bar item clicks here. The action bar will
//        // automatically handle clicks on the Home/Up button, so long
//        // as you specify a parent activity in AndroidManifest.xml.
//        int id = item.getItemId();
//
//        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        }
//
//        return super.onOptionsItemSelected(item);
//    }
}
