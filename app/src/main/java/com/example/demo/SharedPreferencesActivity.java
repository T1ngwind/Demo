package com.example.demo;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

/**Android数据存储之SharedPreferences
 * @author Ting听
 * @version 1.0
 * @date 2020-08-16 11:03
 */
public class SharedPreferencesActivity extends AppCompatActivity {

	SharedPreferences sharedPreferences;
	SharedPreferences.Editor editor;

	String str_username;
	String str_password;
	String spPsw;

	EditText username;
	EditText password;

	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//使用activity_sharedpreferences.xml文件定义的界面布局
		setContentView(R.layout.activity_sharedpreferences);


		//获取只能被本应用读写的SharedPreferences
		sharedPreferences = getSharedPreferences("testdemo",MODE_PRIVATE);
		editor = sharedPreferences.edit();


		Button load = findViewById(R.id.load);
		Button register = findViewById(R.id.register);
		register.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				Intent intent  = new Intent(SharedPreferencesActivity.this,RegisterActivity.class);
				startActivity(intent);
			}
		});

		load.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {

				username = findViewById(R.id.username);
				password = findViewById(R.id.password);

				str_username = username.getText().toString().trim();
				str_password = password.getText().toString().trim();

				spPsw = readPsw(str_username);

				Toast toast = Toast.makeText(SharedPreferencesActivity.this,null,Toast.LENGTH_SHORT);
				if(TextUtils.isEmpty(str_username)){
					toast.setText("请输入用户名");
//					return;
				}else if(TextUtils.isEmpty(str_password)){
					toast.setText("请输入密码");
//					return;
				}else if (str_username.equals(sharedPreferences.getString("user",""))){
					toast.setText("请输入正确的用户名");
//					return;
				}else if(str_password.equals(spPsw)){
					Intent intent2 = new Intent(SharedPreferencesActivity.this,SystemActivity.class);
					startActivity(intent2);
					toast.setText("登录成功");
//					return;
				}else if(!TextUtils.isEmpty(spPsw)&&!str_password.equals(spPsw)){
					toast.setText("输入的用户名和密码不一致");
//					return;
				}else{
					toast.setText("此用户名不存在");
				}
				toast.show();
			}
		});

	}

	private String readPsw(String str_username) {
		SharedPreferences sp = getSharedPreferences("loginInfo",MODE_PRIVATE);
		return sp.getString(str_username,"");

	}



}
