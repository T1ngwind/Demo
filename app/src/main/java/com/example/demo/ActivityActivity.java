package com.example.demo;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

/**
 * @author Ting听
 * @version 1.0
 * @date 2020-08-15 18:08
 * @description 用于验证Activity组件
 */
public class ActivityActivity extends AppCompatActivity {
	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_activity);
	}
}
