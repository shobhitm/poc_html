package com.example.POC_html;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

public class HTMLActivity extends Activity {
    /**
     * Called when the activity is first created.
     */
    ListView lv;
    HTML_Adapter mAdapter;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        lv = (ListView) findViewById(R.id.list);
        mAdapter = new HTML_Adapter(getApplicationContext());
        lv.setAdapter(mAdapter);



    }

}
