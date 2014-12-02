package com.example.POC_html;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by shobhitmandloi on 13/10/14.
 */
public class XMLAdapter extends BaseAdapter implements View.OnClickListener{

    private static final int TYPE_ITEM1 = 0;
    private static final int TYPE_ITEM2 = 1;
    private static final int TYPE_ITEM3 = 2;
    private static final int TYPE_ITEM4 = 3;
    private static final int TOTAL_COUNT = 4;
    int type;


    LayoutInflater vi;
    Context mContext;

    public XMLAdapter(Context context) {
        super();
        mContext = context;
        vi = (LayoutInflater) mContext
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        mContext = context;
    }


    @Override
    public int getItemViewType(int position) {
        switch (position % TOTAL_COUNT){
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
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        long startTime = System.currentTimeMillis();
        View view = convertView;
        ViewHolder holder;
        if (view == null || view.getTag() == null) {

            holder = new ViewHolder();
            switch (type){
                case TYPE_ITEM1:
                    view = vi.inflate(R.layout.xml_item1, null);
                    break;

                case TYPE_ITEM2:
                    view = vi.inflate(R.layout.xml_item2, null);
                    break;

                case TYPE_ITEM3:
                    view = vi.inflate(R.layout.xml_item3, null);
                    break;

                case TYPE_ITEM4:
                    view = vi.inflate(R.layout.xml_item4, null);
                    break;
            }

            holder = initializaHolder(holder, view);
            view.setTag(holder);


        } else
            holder = (ViewHolder) view.getTag();

        holder.topText.setText("MyHTML");
        holder.label.setText(String.valueOf(position));
        holder.description.setText("hike is awesome");
        int randomNum =(int) (Math.random() * 4);
        String url = Environment.getExternalStorageDirectory().getAbsolutePath() + "/poc_image/place_default" + String.valueOf(randomNum) + (randomNum == 0?".png":".jpg") ;
       // String url = Environment.getExternalStorageDirectory().getAbsolutePath() + "/poc_image/sk_noplace.png";
        Bitmap myBitmap = BitmapFactory.decodeFile(url);
       // Log.d(XMLAdapter.class.getSimpleName(),myBitmap.getWidth()+", " + myBitmap.getHeight());

        holder.imgView.setImageBitmap(myBitmap);
       // holder.imgView.setImageResource(R.drawable.sk_noplace);
        holder.buttonView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext,"Hello Android! number " + String.valueOf(position), Toast.LENGTH_SHORT).show();
            }
        });
        long endTime = System.currentTimeMillis();
        Log.d(XMLAdapter.class.getSimpleName(),"time to inflate is " + (endTime - startTime) + "msec");

        return view;
    }

    @Override
    public void onClick(View v) {

    }


    static class ViewHolder {

        ImageView imgView;
        TextView label;
        TextView description;
        TextView topText;
        TextView buttonView;

    }

    private ViewHolder initializaHolder(ViewHolder holder, View view) {
        holder.label = (TextView) view.findViewById(R.id.line1);
        holder.description = (TextView) view.findViewById(R.id.line2);
        holder.imgView = (ImageView) view.findViewById(R.id.image);
        holder.topText = (TextView) view.findViewById(R.id.hello);
        holder.buttonView = (TextView) view.findViewById(R.id.button1);
        return holder;
    }
}
