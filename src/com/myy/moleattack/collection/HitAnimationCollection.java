package com.myy.moleattack.collection;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import android.graphics.Canvas;
import android.graphics.Paint;

import com.myy.moleattack.object.HitAnimation;

public class HitAnimationCollection {

	public static List<HitAnimation> collection;
	
	public HitAnimationCollection()
	{
		collection = new LinkedList<HitAnimation>();
	}
	
	public void draw(Canvas canvas,Paint paint)
	{
		for(HitAnimation ha:collection)
		{
			ha.draw(canvas, paint);
		}
	}
	
	public void clear()
	{
		if(collection.size()>0)
		{
			collection.clear();
		}
	}
	public void logic()
	{
		//用迭代器能够使得在list中删除元素时保持
		//modCount和expectedModCount的值的一致性，避免抛出ConcurrentModificationException异常。
		//(方法一还是出错了)方法二：遍历时把需要删除的对象装入一个新的list，遍历完后再一起删除
		Iterator<HitAnimation> i = collection.iterator();
		List<HitAnimation> dle_list = new LinkedList<HitAnimation>();
		while(i.hasNext())
		{
			HitAnimation ha= i.next();
			if(ha.finish==true)
			{
				dle_list.add(ha);
			}
		}
		collection.removeAll(dle_list);
	}
	
	public void add(HitAnimation ha)
	{
		collection.add(ha);
		ha.play();
	}
}
