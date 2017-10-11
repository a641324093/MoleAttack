package com.myy.moleattack.collection;

import java.util.HashMap;

import com.myy.moleattack.GameSurfaceView;
import com.myy.moleattack.MainActivity;
import com.myy.moleattack.object.MyMusicService;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.util.Log;

public class MediaPlayerCollection {
	
	private HashMap<String,MediaPlayer> map;
	private Intent intent;
	
	public MediaPlayerCollection()
	{
		map = new HashMap<String,MediaPlayer>();
	}
	
	public void load(Context context,int id,String key)
	{
//		MyMusicService server = new MyMusicService(context,id); 
//		map.put(key, server);
		MediaPlayer player;
		player= MediaPlayer.create(context, id); 
		player.setLooping(true);
		map.put(key, player);
		try {
			player.prepare();
//			player.setLooping(true);//设置为循环 这设置无用
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void play(String key)
	{
		MediaPlayer player;
		player = map.get(key);
		player.setLooping(true);//设置为循环
		player.start();
	//	Log.i("MediaPlayerCollection","当前播放时间："+player.getCurrentPosition()+" 是否循环 "+player.isLooping());

		//		MyMusicService mms;
//		intent = new Intent(MainActivity.instance,MyMusicService.class);
//		mms=map.get(key);
//		mms.startService(intent);
	}
	public void pause(String key)
	{
		MediaPlayer player;
		player = map.get(key);
		if(player.getCurrentPosition()>0)
		{
			player.pause();
		}
		
//		MyMusicService mms;
//		intent = new Intent(MainActivity.instance,MyMusicService.class);
//		mms=map.get(key);
//		if(intent==null)
//		{
//			Log.i("MediaPlayerCollection", "intent is null");
//		}
//		mms.stopService(intent);
	}
	
	public void stop(String key)
	{
		MediaPlayer player;
		player = map.get(key);
		if(player.getCurrentPosition()>0)
		{
			player.stop();
		}
		
//		MyMusicService mms;
//		intent = new Intent(MainActivity.instance,MyMusicService.class);
//		mms=map.get(key);
//		mms.stopService(intent);
	}


}
