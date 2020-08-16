package com.example.demo;

import android.content.ContentProvider;
import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

/**用于验证ContentProvider组件
 * @author Ting听
 * @version 1.0
 * @date 2020-08-15 18:20
 */
public class ContentProviderActivity extends AppCompatActivity {

	Button query;		//新建一个Button按钮
	Button insert;		//新建一个Button按钮


	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//使用activity_contentprovider.xml文件定义的界面布局
		setContentView(R.layout.activity_contentprovider);

		query 	= findViewById(R.id.query);	//绑定组件
		insert 	= findViewById(R.id.insert);//绑定组件

		//绑定事件监听
		query.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				ContentResolver contentResolver = getContentResolver();
				Cursor cursor = contentResolver.query(Uri.parse("content://com.example.demo.provider"),null,null,null,null);
			}
		});

		//绑定事件监听
		insert.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {

			}
		});


	}
}
