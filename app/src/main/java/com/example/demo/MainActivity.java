package com.example.demo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

/**Android应用的主界面，用于后续组件开发的启动页
 * @version 		1.0
 * @author  		Ting听
 * @date 			2020年8月14日11:01:37
 *
 * */


public class MainActivity extends AppCompatActivity {
	/*
	 * 		four_component
	 * 		ui_widget
	 * 		multi_thread
	 * 		storage
	 * 	*/
	TextView four_component;	//四大组件
	TextView ui_widget;			//UI控件
	TextView multi_thread;		//多线程
	TextView storage;			//存储

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//使用activity_main.xml文件定义的界面布局
		setContentView(R.layout.activity_main);				//绑定layout布局文件

		four_component = findViewById(R.id.four_component);	//绑定UI控件
		ui_widget = findViewById(R.id.ui_widget);			//绑定UI控件
		multi_thread = findViewById(R.id.multi_thread);		//绑定UI控件
		storage = findViewById(R.id.storage);				//绑定UI控件


		 //为TextView组件four_component绑定事件监听机制，跳转到新建的四大组件界面ComponentActivity
		four_component.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				Intent intent = new Intent();//新建Intent意图
				//设置改intent将要启动的组件对应的类
				intent.setClass(MainActivity.this,ComponentActivity.class);
				startActivity(intent);//启动其他Activity
			}
		});


		 //为TextView组件ui_widget绑定事件监听机制,跳转到新建的UI控件界面UIWedgetActivity
		ui_widget.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				Intent intent2 = new Intent();//新建Intent意图
				//设置改intent将要启动的组件对应的类
				intent2.setClass(MainActivity.this,UIWedgetActivity.class);
				startActivity(intent2);//启动其他Activity
			}
		});


		//为TextView组件multi_thread绑定事件监听机制,跳转到新建的多线程界面MultiThreadActivity
		multi_thread.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				Intent intent3 = new Intent();//新建Intent意图
				//设置改intent将要启动的组件对应的类
				intent3.setClass(MainActivity.this,MultiThreadActivity.class);
				startActivity(intent3);//启动其他Activity
			}
		});


		 //为TextView组件storage绑定事件监听机制,跳转到新建的存储界面StorageActivity
		storage.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				Intent intent4 = new Intent();//新建Intent意图
				//设置改intent将要启动的组件对应的类
				intent4.setClass(MainActivity.this,StorageActivity.class);
				startActivity(intent4);//启动其他Activity
			}
		});



	}
}
