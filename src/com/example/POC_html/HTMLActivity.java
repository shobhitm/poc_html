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
        lv = (ListView) findViewById(R.id.html_list);
       // ContextWrapper cw = new ContextWrapper(getApplicationContext());
        mAdapter = new HTML_Adapter(getApplicationContext());
        lv.setAdapter(mAdapter);
        // path to /data/data/yourapp/app_data/imageDir
//        File directory = cw.getDir("hike_poc", Context.MODE_PRIVATE);
//        // Create imageDir
//        File mypath=new File(directory,"index.html");
//        InputStream is = null;
//        try {
//            is = getApplicationContext().getAssets().open("html1/index.html");
//            int size = is.available();
//            byte[] buffer = new byte[size];
//            FileOutputStream fos = null;
//            fos = new FileOutputStream(mypath);
//            fos.write(buffer);
//            fos.close();
//            String temp = "temp";
//        } catch (IOException e) {
//            e.printStackTrace();
//        }


    }

}
