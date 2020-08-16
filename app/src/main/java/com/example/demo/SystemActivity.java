package com.example.demo;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

/**登录成功界面
 * @author Ting听
 * @version 1.0
 * @date 2020-08-16 18:58
 */
public class SystemActivity extends AppCompatActivity {
	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//使用activity_system.xml文件定义的界面布局
		setContentView(R.layout.activity_system);
	}
}
