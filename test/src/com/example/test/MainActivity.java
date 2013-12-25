package com.example.test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		Log.i("Songs", "File names:");
		List<File> files = getSongs();
		for(File file : files) {
			Log.i("Songs", file.getAbsolutePath());
		}
		
		setContentView(R.layout.activity_main);
	}

	private List<File> getSongs() {
		List<File> files = new ArrayList<File>();
		
		//root
		File file = new File("/");
		File[] children = file.listFiles();
		
		//print a list of all files in root folder
		for(File child : children) {
			Log.i("Songs", "Root child " +  child.getAbsolutePath());
		}
		//use recursion and add file to files list on
		/*
		if(child.getName().endsWith("mp3")) {
			files.add(child);
		}
		*/
		return files;
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
