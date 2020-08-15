package com.example.demo;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Binder;
import android.os.IBinder;
import android.provider.MediaStore;
import android.util.Log;
import android.widget.Toast;

/**
 * @author Ting听
 * @version 1.0
 * @date 2020-08-15 21:12
 * @description 自定义Service，主要是为了实现音乐的播放、暂停和停止功能
 *
 * 		Attention！！！不要忘记在Manifest中注册该服务。
 */
public class MyService extends Service {

	//媒体播放功能
	private MediaPlayer mediaPlayer;

	//接口对象
	IBinder iBinder = new MyBinder();

	//定义一个静态数字，用于统计Service被Created的次数
	static int mIndex = 0;

	/**
	 * @description：MyBinder
	 * 		定义Binder接口实现
	 * */
	class MyBinder extends Binder {
		public MyService getService(){
			return  MyService.this;
		}

	}


	@Override
	public void onCreate() {
		super.onCreate();
		mediaPlayer = MediaPlayer.create(this,R.raw.confessionsballoon);
		Log.i("Ting Demo log","Service Create"+(++mIndex));
	}

	@Override
	public IBinder onBind(Intent intent) {
		//暴露我们的IBinder的接口定义
		Log.i("Ting Demo log","Service onBind");
		return iBinder;
	}

	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		int command;
		if(intent!=null){
			command = intent.getExtras().getInt("Service");
			switch(command){
				//Service 指令为1，则开始播放音乐
				case 1:
					mediaPlayer.start();
					Toast toast = Toast.makeText(this,null,Toast.LENGTH_SHORT);
					toast.setText("开始播放音乐");
					toast.show();
					break;
				//Service 指令为2，则暂停播放音乐
				case 2:
					mediaPlayer.pause();
					Toast toast2 = Toast.makeText(this,null,Toast.LENGTH_SHORT);
					toast2.setText("暂停播放音乐");
					toast2.show();
					break;
				//Service 指令为3，则停止播放音乐,并且释放mediaPlayer资源
				case 3:
					mediaPlayer.stop();
					mediaPlayer.release();
					Toast toast3 = Toast.makeText(this,null,Toast.LENGTH_SHORT);
					toast3.setText("停止播放音乐");
					toast3.show();
					mediaPlayer = null;
					break;
				default:
					break;
			}


		}





		return super.onStartCommand(intent, flags, startId);
	}

	@Override
	public boolean onUnbind(Intent intent) {
		Log.i("Ting Demo log","Service Unbind");
		return super.onUnbind(intent);
	}

	@Override
	public void onDestroy() {
		super.onDestroy();
		Log.i("Ting Demo log","Service Destroy");
	}
}
