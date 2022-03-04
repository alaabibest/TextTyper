package com.mycompany.myapp;

import android.app.*;
import android.graphics.*;
import android.os.*;
import ir.alirezaabdolmaleki.textTyper.*;
import ir.alirezaabdolmaleki.*;

public class MainActivity extends Activity 
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
		
			TextTyper texttyper = (TextTyper) findViewById(R.id.texttyper);
			texttyper.typeText("alireza abdolmaleki", 100);
			texttyper.setSound(R.raw.sound_1, 9);
			texttyper.setFont(Fonts.PresianFont);
		
			
    }

	
	
}
