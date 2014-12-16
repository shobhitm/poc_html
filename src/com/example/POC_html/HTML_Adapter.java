package com.example.POC_html;

import android.content.Context;
import android.os.Environment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.BaseAdapter;

/**
 * Created by shobhitmandloi on 10/10/14.
 */
public class HTML_Adapter extends BaseAdapter{

    LayoutInflater vi;
    Context mContext;
    boolean isLoaded ;
    private static final int TOTAL_TYPES = 4;
    private static final int TYPE_ITEM1 = 0;
    private static final int TYPE_ITEM2 = 1;
    private static final int TYPE_ITEM3 = 2;
    private static final int TYPE_ITEM4 = 3;
    int type;

    @Override
    public int getCount() {
        return 500;
    }

    public HTML_Adapter(Context context) {
        super();
        mContext = context;
        vi = (LayoutInflater) mContext
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        mContext = context;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemViewType(int position) {
        switch (position % TOTAL_TYPES){
            case 0:
                type = TYPE_ITEM1;
                break;

            case 1:
                type = TYPE_ITEM2;
                break;

            case 2:
                type = TYPE_ITEM3;
                break;

            case 3:
                type = TYPE_ITEM4;
                break;
        }
        return type;
    }

    @Override
    public int getViewTypeCount() {
        return TOTAL_TYPES;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        long startTime = System.currentTimeMillis();
        View view = convertView;
        ViewHolder holder;
        if (view == null || view.getTag() == null) {

            Log.d(HTML_Adapter.class.getSimpleName(),"position "+position+" inflated");
            holder = new ViewHolder();
            view = vi.inflate(R.layout.html_item, null);
            holder = initializaHolder(holder, view);
            webViewHandler(holder.myBrowser, position, type);
            view.setTag(holder);
            isLoaded = true;

        } else {
            Log.d(HTML_Adapter.class.getSimpleName(),"position "+position+" reused");
            holder = (ViewHolder) view.getTag();
            isLoaded = false;
       }
       webViewDataHandler(holder.myBrowser,position);

        long endTime = System.currentTimeMillis();
        Log.d(HTML_Adapter.class.getSimpleName(),"time to inflate is " + (endTime - startTime) + "msec");

       return view;
    }



    private void webViewHandler(final WebView myBrowser, final int position, int type) {

        final MyJavaScriptInterface myJavaScriptInterface
                = new MyJavaScriptInterface(mContext, position);
        myBrowser.setVerticalScrollBarEnabled(false);
        myBrowser.setHorizontalScrollBarEnabled(false);
        myBrowser.addJavascriptInterface(myJavaScriptInterface, "AndroidFunction");

        myBrowser.getSettings().setJavaScriptEnabled(true);


        switch (type){
            case TYPE_ITEM1:
                myBrowser.loadUrl("file://" + Environment.getExternalStorageDirectory().getAbsolutePath() + "/poc/index1.html");
                //myBrowser.loadUrl("file://" + Environment.getExternalStorageDirectory().getAbsolutePath() + "/poc/index1.html");
                break;

            case TYPE_ITEM2:
               // myBrowser.loadUrl("file:///android_asset/html1/index2.html");
                myBrowser.loadUrl("file://" + Environment.getExternalStorageDirectory().getAbsolutePath() + "/poc/index2.html");
                break;

            case TYPE_ITEM3:
               // myBrowser.loadUrl("file:///android_asset/html1/index3.html");
                myBrowser.loadUrl("file://" + Environment.getExternalStorageDirectory().getAbsolutePath() + "/poc/index3.html");
                break;

            case TYPE_ITEM4:
               // myBrowser.loadUrl("file:///android_asset/html1/index4.html");
                myBrowser.loadUrl("file://" + Environment.getExternalStorageDirectory().getAbsolutePath() + "/poc/index4.html");
                break;
        }


    }

    private void webViewDataHandler(final WebView myBrowser, final int position) {

        if (isLoaded){
            myBrowser.setWebViewClient(new WebViewClient(){
                @Override
                public void onPageFinished(WebView view, String url) {
                    super.onPageFinished(view, url);
                    htmlInteractor(position, myBrowser);

                }
            });
        } else
            htmlInteractor(position, myBrowser);

    }


    private void htmlInteractor(int position, WebView myBrowser) {

        String msgToSend = String.valueOf(position);
        myBrowser.loadUrl("javascript:callToChangeTitle(\""+msgToSend+"\")");

        String msg = "hike is awesome";
        myBrowser.loadUrl("javascript:callToChangeDescription(\""+msg+"\")");

        // String imgSrc = "file:///android_asset/html1/sk_noplace.png";
        int randomNum =(int) (Math.random() * 4);
         String imgSrc = Environment.getExternalStorageDirectory().getAbsolutePath() + "/poc_image/place_default" + String.valueOf(randomNum) + (randomNum == 0?".png":".jpg") ;
        myBrowser.loadUrl("javascript:callToChangeImage(\""+imgSrc+"\")");
    }


    static class ViewHolder {

        WebView myBrowser;
    }

    private ViewHolder initializaHolder(ViewHolder holder, View view) {
        holder.myBrowser = (WebView) view.findViewById(R.id.webcontent);
        return holder;
    }

}
