package com.example.demo;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

/**
 * @author Ting听
 * @version 1.0
 * @date 2020-08-15 18:16
 * @description 通过搭建一个简易音乐播放器，用于验证Service组件
 */
public class ServiceActivity extends AppCompatActivity {
	/**
	 * @description:
	 * 		创建三个按钮Butoon，用于实现简易音乐播放器的播放、暂停和停止。
	 * */

	Button Play;		//新建一个Button按钮，用于控制音乐播放器播放音乐
	Button Pause;		//新建一个Button按钮，用于控制音乐播放器暂停音乐
	Button Stop;		//新建一个Button按钮，用于控制音乐播放器停止播放音乐

	private MediaPlayer mediaPlayer;


	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_service);

		Play 	= findViewById(R.id.play);	//绑定组件
		Pause	= findViewById(R.id.pause);	//绑定组件
		Stop 	= findViewById(R.id.stop);	//绑定组件

		mediaPlayer = MediaPlayer.create(this,R.raw.confessionsballoon);

		//触发Play按钮事件监听机制，开启播放音乐服务
		Play.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				//新建一个intent
				Intent intent = new Intent(ServiceActivity.this,MyService.class);
				//将要传的值附加到intent中
				intent.putExtra("Service",1);
				//启动Service服务
				startService(intent);
			}
		});

		//触发Pause按钮事件监听机制，暂停播放音乐服务
		Pause.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				//新建一个intent
				Intent intent2 = new Intent(ServiceActivity.this,MyService.class);
				//将要传的值附加到intent中
				intent2.putExtra("Service",2);
				//启动Service服务
				startService(intent2);
			}
		});

		//触发Stop按钮事件监听机制，停止播放音乐服务
		Stop.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				//新建一个intent
				Intent intent3 = new Intent(ServiceActivity.this,MyService.class);
				//将要传的值附加到intent中
				intent3.putExtra("Service",3);
				//启动Service服务
				startService(intent3);
			}
		});







	}
}
