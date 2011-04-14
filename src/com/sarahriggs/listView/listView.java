package com.sarahriggs.listView;

import java.util.ArrayList;

import android.app.Dialog;
import android.app.ListActivity;
import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class listView extends ListActivity {
	

	ArrayList<Larvae> myLarvae = new ArrayList<Larvae>();
	Context mContext;
	Dialog dialog;
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = this;
        Larvae egg = new Larvae();
        egg.name = "Egg";
        egg.description = "Football Shape, Offwhite";
        egg.count = 0;
        egg.image = getResources().getDrawable(R.drawable.egg);
        egg.high_def_image = getResources().getDrawable(R.drawable.eggc);
        
        myLarvae.add(egg);
        
        Larvae instar1 = new Larvae();
        instar1.name = "Instar 1";
        instar1.description = "5cm Long, Offwhite";
        instar1.count = 0;
        instar1.image = getResources().getDrawable(R.drawable.instar1);
        instar1.high_def_image = getResources().getDrawable(R.drawable.instar1c);

        myLarvae.add(instar1);
        
        Larvae instar2 = new Larvae();
        instar2.name = "Instar 2";
        instar2.description = "8cm Long, Yellow";
        instar2.count = 0;
        instar2.image = getResources().getDrawable(R.drawable.instar2);
        instar2.high_def_image = getResources().getDrawable(R.drawable.instar2c);

        myLarvae.add(instar2);
        
        
        Larvae instar3 = new Larvae();
        instar3.name = "Instar 3";
        instar3.description = "8cm Long, Yellow";
        instar3.count = 0;
        instar3.image = getResources().getDrawable(R.drawable.instar3);
        instar3.high_def_image = getResources().getDrawable(R.drawable.instar3c);

        myLarvae.add(instar3);
        
        Larvae instar4 = new Larvae();
        instar4.name = "Instar 4";
        instar4.description = "8cm Long, Yellow";
        instar4.count = 0;
        instar4.image = getResources().getDrawable(R.drawable.instar4);
        instar4.high_def_image = getResources().getDrawable(R.drawable.instar4c);

        myLarvae.add(instar4);
        
        Larvae instar5 = new Larvae();
        instar5.name = "Instar 5";
        instar5.description = "8cm Long, Yellow";
        instar5.count = 0;
        instar5.image = getResources().getDrawable(R.drawable.instar5);
        instar5.high_def_image = getResources().getDrawable(R.drawable.instar5c);
        
        myLarvae.add(instar5);

        setListAdapter(new LarvaeAdapter(this, R.layout.list_item, myLarvae));

        ListView lv = getListView();
        //lv.setTextFilterEnabled(true);

        lv.setOnItemClickListener(new OnItemClickListener() {
          public void onItemClick(AdapterView<?> parent, View view,
              int position, long id) {
            // When clicked, show a toast with the TextView text
           // Toast.makeText(getApplicationContext(), "recorded",
                //Toast.LENGTH_SHORT).show();
        	  myLarvae.get(position).increment();
        	  ((ArrayAdapter) parent.getAdapter()).notifyDataSetChanged();
          }
        });
        
        
        
        lv.setOnItemLongClickListener(new OnItemLongClickListener() {

			@Override
			public boolean onItemLongClick(AdapterView<?> parent, View view,
					int position, long id) {
				
				dialog = new Dialog(mContext);

				dialog.setContentView(R.layout.custom_dialog);
				dialog.setTitle(myLarvae.get(position).name);

				TextView text = (TextView) dialog.findViewById(R.id.description);
				text.setText(myLarvae.get(position).description);
				ImageView image = (ImageView) dialog.findViewById(R.id.image);
				image.setImageDrawable(myLarvae.get(position).high_def_image);
				Button closeButton = (Button) dialog.findViewById(R.id.closeDialog);
				closeButton.setOnClickListener(new OnClickListener(){

					@Override
					public void onClick(View arg0) {
						dialog.dismiss();
					}
					
				});
				
				dialog.show();
				
				
				
				return true;
			}
        	
        });
        
    }
    
    
}

