package caiji.alexli.findit;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;


public class LostIt2 extends Activity {

    private EditText mItemName, mDescription, mReward;
    private String itemName, description, reward, address;
    private double latitude, longitude;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lost_it2);

        mItemName = (EditText) findViewById(R.id.editText);
        mDescription = (EditText) findViewById(R.id.editText2);
        mReward = (EditText) findViewById(R.id.editText3);



        address = getIntent().getStringExtra("address");
        latitude = getIntent().getDoubleExtra("latitude", 0);
        longitude = getIntent().getDoubleExtra("longitude", 0);



        Button submit = (Button)findViewById(R.id.button);

        submit.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                itemName = mItemName.getText().toString();
                description = mDescription.getText().toString();
                reward = mReward.getText().toString();

                // return to main activity if name and description provided (reward not necessary)
                if (!(itemName.isEmpty() || description.isEmpty())) {
                    // send itemName, description, address, latitude, longitude, reward to database
                    Log.i("send stuff to database", itemName + " " + description + " " + address + " " + latitude + " " + longitude + " " + reward);

                    String url = "http://alexli.ca/filelost.php?";
                    url = "name=" + URLEncoder.encode(itemName) + "&" +
                          "desc=" + URLEncoder.encode(description) + "&" +
                          "address=" + URLEncoder.encode(address) + "&" +
                          "lat=" + URLEncoder.encode("" + latitude) + "&" +
                          "lng=" + URLEncoder.encode("" + longitude) + "&" +
                          "reward=" + URLEncoder.encode(reward) + "&" +
                          "date=" + URLEncoder.encode((new SimpleDateFormat("yyyy/MM/dd HH:mm:ss")).format(new Date()));

                    Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                    startActivity(browserIntent);

                    // then return to main activity
                    finish();
                }
            }
        });

    }



}
