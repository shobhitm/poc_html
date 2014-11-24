package com.example.POC_html;

import android.app.Application;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/**
 * Created by shobhitmandloi on 14/10/14.
 */
public class POCApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        WebView mWebView = new WebView(getApplicationContext());
        mWebView.setWebViewClient(new WebViewClient());
    }
}
