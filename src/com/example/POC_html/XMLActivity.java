package com.example.POC_html;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

/**
 * Created by shobhitmandloi on 10/10/14.
 */
public class XMLActivity extends Activity{

     protected ListView lv;
    XMLAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        lv = (ListView) findViewById(R.id.list);
        mAdapter = new XMLAdapter(getApplicationContext());
        lv.setAdapter(mAdapter);
    }
}
