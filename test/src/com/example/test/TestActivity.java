package com.example.test;

import java.io.File;
import java.io.FileDescriptor;
import java.io.FileInputStream;

import android.app.Activity;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;

public class TestActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		Log.i("Songs", new File("/storage/extSdCard/Music/wakawaka.mp3").exists()+"");
		
		 MediaPlayer mediaPlayer = new MediaPlayer();
		 mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
		 
		//playing a local file system mp3 file
		 
		try {
				//mediaPlayer.setDataSource(getApplicationContext(), myUri);
				// change the file location to point to a song in your phone.
				FileInputStream fis = new FileInputStream("/storage/extSdCard/Music/wakawaka.mp3");
				FileDescriptor fd = fis.getFD();
				mediaPlayer.setDataSource(fd);

				mediaPlayer.prepare();
				mediaPlayer.start();
				} catch (Exception e) {
					e.printStackTrace();
			}
		
		/* online play
		Uri myUri = Uri.parse("http://www.tonycuffe.com/mp3/tailtoddle_lo.mp3");
		MediaPlayer mediaPlayer = new MediaPlayer();
		mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
		
		try {
		mediaPlayer.setDataSource(getApplicationContext(), myUri);
		mediaPlayer.prepare();
		}
		catch (Exception e) {
		e.printStackTrace();
}
		mediaPlayer.start();
		
*/
		setContentView(R.layout.activity_test);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.test, menu);
		return true;
	}
	


}
