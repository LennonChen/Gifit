package com.el1t.photif;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
		
        ImageView video = (ImageView) findViewById(R.id.video);   
        ImageView photo = (ImageView) findViewById(R.id.photo);
        ImageView gallery = (ImageView) findViewById(R.id.gallery);
        ImageView share = (ImageView) findViewById(R.id.share);
        final ImageView logo1 = (ImageView) findViewById(R.id.logo1);
        
        Animation translate = new TranslateAnimation(0, 360,-5,-5);
        translate.setDuration(1000);
        translate.setInterpolator(new AccelerateDecelerateInterpolator());
        translate.setFillEnabled(true);
        translate.setFillBefore(true);
        translate.setFillAfter(true);
        translate.setStartOffset(500);
        logo1.startAnimation(translate);
        
		photo.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				logo1.setAnimation(null);
				Intent i = new Intent(MainActivity.this, picker.class);
				startActivity(i);
			}
		});
		
		share.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				logo1.setAnimation(null);
				Intent i = new Intent(MainActivity.this, share.class);
	    		i.setType("image/*");
	    		i.setAction(Intent.ACTION_SEND);
	    		i.putExtra("Uri", Environment.getExternalStorageDirectory().getPath() + "/Pictures/gifit/test.gif");
				startActivity(i);
			}
		});
		
		gallery.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				logo1.setAnimation(null);
				Intent i = new Intent(MainActivity.this, gallery.class);
				startActivity(i);
			}
		});
		
		video.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				logo1.setAnimation(null);
				Intent i = new Intent(MainActivity.this, video.class);
				startActivity(i);
			}
		});
    }

    protected void onRestart() {
    	super.onRestart();
    	final ImageView logo1 = (ImageView) findViewById(R.id.logo1);
    	Animation translate = new TranslateAnimation(0, 360,-5,-5);
        translate.setDuration(1000);
        translate.setInterpolator(new AccelerateDecelerateInterpolator());
        translate.setFillEnabled(true);
        translate.setFillBefore(true);
        translate.setFillAfter(true);
        logo1.startAnimation(translate);
    }
}