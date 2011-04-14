package com.sarahriggs.listView;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

class LarvaeAdapter extends ArrayAdapter<Larvae> {

    private ArrayList<Larvae> items;
    
    private Context context;
    public LarvaeAdapter(Context context, int textViewResourceId, ArrayList<Larvae> larvae) {
            super(context, textViewResourceId, larvae);
            this.items = larvae;
            this.context = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
            View v = convertView;
            if (v == null) {
                LayoutInflater vi = (LayoutInflater) context.getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                v = vi.inflate(R.layout.list_item, null);
            }
            
            TextView name = (TextView) v.findViewById(R.id.larvaeName);
            //TextView description = (TextView) v.findViewById(R.id.larvaeDescription);
            TextView count = (TextView) v.findViewById(R.id.larvaeCount);
            ImageView image = (ImageView) v.findViewById(R.id.larvaeImage);
            
            name.setText(items.get(position).name);
            //description.setText(items.get(position).description);
            count.setText(String.valueOf(items.get(position).count));
            image.setImageDrawable(items.get(position).image);
            return v;
    }
}