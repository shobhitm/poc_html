package com.example.POC_html;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by shobhitmandloi on 12/10/14.
 */
public class MyJavaScriptInterface {
    Context mContext;
    int mPosition;

    MyJavaScriptInterface(Context c, int position) {
        mContext = c;
        mPosition = position;
    }

    public void showToast(String toast){
        Toast.makeText(mContext, toast + " number " + String.valueOf(mPosition), Toast.LENGTH_SHORT).show();
    }


}
