package com.example.demo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

/**新建四大组件，用以实现其功能
 * @author 			Ting听
 * @version 		1.0
 * @date 			2020-08-14 12:59
 */
public class ComponentActivity extends AppCompatActivity {
	/*
	 * 新建四大组件，用以实现其功能
	 * 		Activity
	 * 		Service
	 * 		BroadcastReceiver
	 * 		ContentProvider
	 *
	 * */
		TextView Activity;			//创建一个Activity 	TextView
		TextView Service;			//创建一个Service	TextView
	 	TextView BroadcastReceiver;	//创建一个BroadcastReceiver	TextView
	 	TextView ContentProvider;	//创建一个ContentProvider	TextView


	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//使用activity_component.xml文件定义的界面布局
		setContentView(R.layout.activity_component);
		Activity 			= findViewById(R.id.activity);				//获取UI界面中ID为R.id.activity的文本框
		Service 			= findViewById(R.id.service);				//获取UI界面中ID为R.id.service的文本框
		BroadcastReceiver 	= findViewById(R.id.broadcast_receiver);	//获取UI界面中ID为R.id.broadcast_receiver的文本框
		ContentProvider 	= findViewById(R.id.content_provider);		//获取UI界面中ID为R.id.content_provider的文本框


		//新建一个Activity，用于显示四大组件之一的Activity
		Activity.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				//新建一个intent，并且设置该intent将要启动的组件对应的类
				Intent intent = new Intent(ComponentActivity.this,ActivityActivity.class);
				//开启下一个Activity
				startActivity(intent);
			}
		});


		//新建一个Activity，用于显示四大组件之一的Service
		Service.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				//新建一个intent，并且设置该intent将要启动的组件对应的类
				Intent intent = new Intent(ComponentActivity.this,ServiceActivity.class);
				//开启下一个Activity
				startActivity(intent);
			}
		});

		//新建一个Activity，用于显示四大组件之一的BroadcastReceiver
		BroadcastReceiver.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				//新建一个intent，并且设置该intent将要启动的组件对应的类
				Intent intent = new Intent(ComponentActivity.this,BroadcastReceiverActivity.class);
				//开启下一个Activity
				startActivity(intent);
			}
		});

		//新建一个Activity，用于显示四大组件之一的ContentProvider
		ContentProvider.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				//新建一个intent，并且设置该intent将要启动的组件对应的类
				Intent intent = new Intent(ComponentActivity.this,ContentProviderActivity.class);
				//开启下一个Activity
				startActivity(intent);
			}
		});




	}
}
