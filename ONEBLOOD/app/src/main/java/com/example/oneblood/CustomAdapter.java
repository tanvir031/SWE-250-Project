package com.example.oneblood;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class CustomAdapter extends BaseAdapter {

    String[] countrynames;
    String[] blood;
    String[] mobile;
    Context context;

    private LayoutInflater inflater;

    CustomAdapter(Context context,String[] countrynames,String[] mobile,String[] blood){
        this.context = context;
        this.countrynames = countrynames;
        this.mobile = mobile;
        this.blood = blood;
    }

    @Override
    public int getCount() {
        return countrynames.length;
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
    public View getView(int position, View convertView, ViewGroup parent) {

        if(convertView==null){

            inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.sample_view,parent,false);
        }

        TextView textView1 = (TextView) convertView.findViewById(R.id.countryNameID);
        TextView textView2 = (TextView) convertView.findViewById(R.id.bloodID);
        TextView textView3 = (TextView) convertView.findViewById(R.id.mobileID);
        textView1.setText(countrynames[position]);
        textView2.setText(blood[position]);
        textView3.setText(mobile[position]);

        return convertView;
    }
}
