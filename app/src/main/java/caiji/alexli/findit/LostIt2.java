package caiji.alexli.findit;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


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
                    // then return to main activity
                    finish();
                }
            }
        });

    }



}
