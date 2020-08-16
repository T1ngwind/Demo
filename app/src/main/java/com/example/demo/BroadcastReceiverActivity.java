package com.example.demo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

/**用于验证BroadcastReceiver组件
 * @author Ting听
 * @version 1.0
 * @date 2020-08-15 18:18
 */
public class BroadcastReceiverActivity extends AppCompatActivity {
	MyReceiver myReceiver;
	static TextView textViewShow;

	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//使用activity_broadcastreceiver.xml文件定义的界面布局
		setContentView(R.layout.activity_broadcastreceiver);

		//新建一个广播接受者
		myReceiver = new MyReceiver();
		textViewShow = findViewById(R.id.Show);

		//创建TntentFilter
		IntentFilter intentFilter = new IntentFilter();
		//指定BroadcastReceiver监听的Action
		intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
		//注册BroadcastReceiver
		registerReceiver(myReceiver,intentFilter);

	/*	//textView.setText("Ting听，真的听到了");
		new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					Thread.sleep(1000);
				}catch(Exception e){
				}finally{
					textView.setText("Ting听的见吗？");
				}

			}
		}).start();*/


	}



	//别忘了将广播取消掉哦~
	@Override
	public void onDestroy(){
		super.onDestroy();
		unregisterReceiver(myReceiver);


	}
}
