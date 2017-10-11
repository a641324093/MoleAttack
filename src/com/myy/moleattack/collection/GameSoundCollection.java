package com.myy.moleattack.collection;

import java.util.HashMap;

import android.R.integer;
import android.content.Context;
import android.media.AudioManager;
import android.media.SoundPool;

public class GameSoundCollection {
	private static final int MAXSIZE=10;
	public SoundPool collection;
	private HashMap<String,Integer> map;
	
	public GameSoundCollection()
	{
		collection = new SoundPool(MAXSIZE,AudioManager.STREAM_MUSIC,0);
		map=new HashMap<String,Integer>();
	}
	
	public void load(Context context,int  resId,String key)
	{
		int id;
		id=collection.load(context, resId, 1);
		map.put(key, id);
	}
	
	public void play(String key)
	{
		int id= map.get(key);
		collection.play(id, 1, 1,0,0,1);
	}
}
