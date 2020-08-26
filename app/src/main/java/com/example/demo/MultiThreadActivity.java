package com.example.demo;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

/**Android多线程
 * @author 			Ting听
 * @version 		1.0
 * @date 			2020-08-14 12:59
 */
public class MultiThreadActivity extends AppCompatActivity {

	TextView handler;	//创建一个TextView
	TextView asyncTask;	//创建一个TextView

	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//使用activity_multithread.xml文件定义的界面布局
		setContentView(R.layout.activity_multithread);

		handler		= findViewById(R.id.handler);	//绑定事件监听
		asyncTask 	= findViewById(R.id.asynctask);	//绑定事件监听

		//使用handler来实现Android多线程
		handler.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				Intent intent = new Intent(MultiThreadActivity.this,HandlerActivity.class);
				startActivity(intent);//跳转到HandlerActivity
			}
		});

		//使用AsyncTask来实现Android多线程
		asyncTask.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				Intent intent2 = new Intent(MultiThreadActivity.this,AsyncTaskActivity.class);
				startActivity(intent2);//跳转到AsyncTaskActivity
			}
		});



	}
}
