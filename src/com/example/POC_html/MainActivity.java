package com.example.POC_html;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/**
 * Created by shobhitmandloi on 12/10/14.
 */
public class MainActivity extends Activity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_layout);
        findViewById(R.id.html_button).setOnClickListener(this);
        findViewById(R.id.xml_button).setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        if (v.getId() == R.id.html_button){
            Intent intent = new Intent(getApplicationContext(), XMLActivity.class);
            startActivity(intent);
        }
        else  if (v.getId() == R.id.xml_button){
            Intent intent = new Intent(getApplicationContext(), HTMLActivity.class);
            startActivity(intent);
        }

    }
}
