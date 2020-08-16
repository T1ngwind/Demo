package com.example.demo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

/**用于存储数据
 * @author Ting听
 * @version 1.0
 * @date 2020-08-14 12:56
 */
public class StorageActivity extends AppCompatActivity {

	TextView SharedPreferences;	//新建一个TextView控件
	TextView FileIO;			//新建一个TextView控件
	TextView SQLite;			//新建一个TextView控件

	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//使用activity_storage.xml文件定义的界面布局
		setContentView(R.layout.activity_storage);

		SharedPreferences 	= findViewById(R.id.sharedPreferences);		//绑定控件
		FileIO 				= findViewById(R.id.fileio);				//绑定控件
		SQLite 				= findViewById(R.id.sqlite);				//绑定控件

		//绑定事件监听机制，跳转到SharedPreferencesActivity界面完成数据存储之SharedPreferences。
		SharedPreferences.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				//新建intent
				Intent intent = new Intent(StorageActivity.this,SharedPreferencesActivity.class);
				//跳转到SharedPreferencesActivity界面
				startActivity(intent);
			}
		});

		//绑定事件监听机制，跳转到FileIOActivity界面完成数据存储之FileIO。
		FileIO.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				//新建intent
				Intent intent2 = new Intent(StorageActivity.this,FileIOActivity.class);
				//跳转到FileIOActivity界面
				startActivity(intent2);
			}
		});

		//绑定事件监听机制，跳转到SQLiteActivity界面完成数据存储之SQLite。
		SQLite.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				//新建intent
				Intent intent3 = new Intent(StorageActivity.this,SQLiteActivity.class);
				//跳转到SQLiteActivity界面
				startActivity(intent3);
			}
		});





	}
}
