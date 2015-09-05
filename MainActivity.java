package com.giridharan.motiv;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends Activity {

   // Array of strings...
    String[] countryArray = {"Start by doing what's necessary, then do what's possible, and suddenly you are doing the impossible."
    		,"The truth is you don't know what is going to happen tomorrow. Life is a crazy ride, and nothing is guaranteed."
    		,"If you do not hope, you will not find what is beyond your hopes."
    		,"I am not a product of circumstances . I am a product of my decisions."
    		,"Failure will never overtake me if my determination to succeed is strong enough."
    		,"There is more to life than increasing its speed."
    		,"Dream big and dare to fail."
    		,"Every child is an artist. The problem is how to remain an artist once be grows up."
    		,"Life isn't about finding yourself.  Life is about creating yourself."
    		,"Once you replace negative thoughts with positive ones, you'll start positive results."
    		,"With will one can do anything."
    		,"The two most important days in your life are the day you are born and the day you find out why."
    		,"Keep your face to the sunshine and you cannot see a shadow."
    		,"Believe that life is worth living and your belief will help create the fact."
    		,"The best revenge is massive success."
    		,"Love isn't something you find. Love is something that finds you."
    		,"You're going to go through tough times – that's life. But I say,  'Nothing happens to you, it happens for you.' See the positive in negative events."
    		,"We are all inventors each sailing out on a voyage of discover guided each by a private chart, of which there is no duplicate.  The world is all gates, all opportunities"
    		,"Without inspiration the best powers of the mind remain dormant. There is a fuel in us which needs to be ignited with sparks."
    		,"Life shrinks or expands in proportion tone;s courage."
    		,"The best and most beautiful things in the world cannot be seen or even touched -  they must be felt with the heart.","I believe if you keep your faith, you keep your trust, you keep the right attitude, if you're grateful, you'll see God open up new doors."
    		,"Life consist not in holding good cards, but in playing those you hold well."
    		,"Start where you are. Use what you have. Do what you can."
    		,"It does not matter how slowly you go as long as you do not stop."
    		,"To succeed you need to find something to hold on to, something to motivate you, something to inspire you."
    		,"Hope is like the sun, which, as we journey toward it, casts the shadow of our burden behind us."
    		,"Fall seven times and stand up eight."
    		,"Find the place inside where there's joy, and joy will burn out the pain."
    		,"Keep your dreams alive.  Understand to achieve anything requires faith and belief in yourself, vision, hard work, determination and dedication. Remember all things are possible for those who BELIEVE."
    		,"Men's best successes come after their disappointment."
    		,"When one door of happiness closes , another opens, but often we look so long at the closed door that we don't see the one that has been opened for us."
    		,"Sometimes the heart sees what is invisible to the eye."
    		,"If my mind can conceive and my heart can believe it I know I can achieve it."
    		,"Knowing is not enough; we must apply. Willing is not enough; we must do."
    		,"Happiness is not something ready made.  It comes from your action."
    		,"If opportunity doesn't knock, build a door."
    		,"Push yourself because, No one else is going to do it for you."
    		,"Imagine with all your mind, Believe with all your heart. Achieve with all your might."
    		,"The only way to do great work is to love what you do."
    		,"We may encounter many defeats but we must not be defeated."
    		,"Try not to become a Man of Success but  a Man of Value."
    		,"Life is about making an impact, not making an income."
    		,"Life is really simple but we insist on making it complicated."
    		,"Throughout life people will make you mad, disrespect you and treat you bad. Let God deal with the things they do cause hate in your heart will consume you too."
    		,"Put your heart, mind and soul into even your smallest acts.  This is the secret of success."
    		,"Two roads diverged in a wood, and I – I took the one less traveled by,  and that has made all the difference."
    		,"Believe in yourself and all that you are know that there is something inside you that is greater than any obstacle."
    		,"Positive anything is better than negative nothing."
    		,"Always do your best.  What you plant now, you will harvest later."
    		,"Life is dream for a wise, a game for the fool, a comedy for the rich, a tragedy for the poor."};

   @Override
   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_main);
      
      ArrayAdapter adapter = new ArrayAdapter<String>(this,R.layout.activity_listview, countryArray);
      
      ListView listView = (ListView) findViewById(R.id.country_list);
      listView.setAdapter(adapter);
      listView.setOnItemClickListener(new OnItemClickListener() {
          @Override
          public void onItemClick(AdapterView<?> parent, View view, int position,long id) {
              
            //  String item = ((TextView)view).getText().toString();
              final int p = position;
              Toast.makeText(getBaseContext(), countryArray[position], Toast.LENGTH_LONG).show();
           //change from here
              AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(MainActivity.this);
              
    	      alertDialogBuilder.setMessage(countryArray[position]);
    	      alertDialogBuilder.setPositiveButton("Whatsapp", 
    	      new DialogInterface.OnClickListener() {
    			
    	         @Override
    	         public void onClick(DialogInterface arg0, int arg1) {
    	           // Intent positveActivity = new Intent(getApplicationContext(),com.example.alertdialog.PositiveActivity.class);
    	            //startActivity(positveActivity);
    	        	 Intent waIntent = new Intent(Intent.ACTION_SEND);
    	        	    waIntent.setType("text/plain");
    	        	    waIntent.setPackage("com.whatsapp");
    	        	    if (waIntent != null) {
    	        	        waIntent.putExtra(Intent.EXTRA_TEXT, countryArray[p]);//
    	        	        startActivity(Intent.createChooser(waIntent, countryArray[p]));
    	        	    } else {
    	        	        Toast.makeText(MainActivity.this, "WhatsApp not found", Toast.LENGTH_SHORT)
    	        	                .show();
    	        	    }
    				
    	         }
    	      });
    	      alertDialogBuilder.setNegativeButton("Viber", 
    	      new DialogInterface.OnClickListener() {
    				
    	         @Override
    	         public void onClick(DialogInterface dialog, int which) {
    	            //Intent negativeActivity = new Intent(getApplicationContext(),com.example.alertdialog.NegativeActivity.class);
    	            //startActivity(negativeActivity);
    	        	 Intent waIntent = new Intent(Intent.ACTION_SEND);
 	        	    waIntent.setType("text/plain");
 	        	    waIntent.setPackage("com.viber.voip");
 	        	    if (waIntent != null) {
 	        	        waIntent.putExtra(Intent.EXTRA_TEXT, countryArray[p]);//
 	        	        startActivity(Intent.createChooser(waIntent, countryArray[p]));
 	        	    } else {
 	        	        Toast.makeText(MainActivity.this, "WhatsApp not found", Toast.LENGTH_SHORT)
 	        	                .show();
 	        	    }
    			 }
    	      });
    		    
    	      AlertDialog alertDialog = alertDialogBuilder.create();
    	      alertDialog.show();

              
              //to here
          }
      });
   }
   
}