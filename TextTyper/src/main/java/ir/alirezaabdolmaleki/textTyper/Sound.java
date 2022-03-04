package ir.alirezaabdolmaleki.textTyper;
import android.media.*;
import android.content.*;
import android.widget.*;

public class Sound
{

	public static String NORMAL = "NORMAL";
	public static String SOUND_1 = "sound_1";
	public static String SOUND_2 = "sound_2.mp3";
	public static boolean ENABLE = false;
	public static Context context;
	public MediaPlayer player;
	
	public void repeatSong()
	{
		MediaPlayer medi = player;
		medi.start();
	}

	
	public void setSound(String songName, int volume)
	{
		
		int sound_res_ID = context.getResources().getIdentifier(songName,"raw", context.getPackageName());
		player = MediaPlayer.create(context,sound_res_ID); 
		player.setVolume(volume, volume); 
		
	}

	public void setSound(MediaPlayer mPlayer, int volume)
	{
		
		player = mPlayer;
		player.setVolume(volume, volume); 
	
	}
	
	}
